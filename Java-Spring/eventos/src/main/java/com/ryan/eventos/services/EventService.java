package com.ryan.eventos.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.ryan.eventos.models.EventModel;
import com.ryan.eventos.models.MessageModel;
import com.ryan.eventos.models.User;
import com.ryan.eventos.repositories.EventRepo;
import com.ryan.eventos.repositories.MessageRepo;

@Service
public class EventService {

	private final EventRepo eventRepo;
	private final MessageRepo messageRepo;
	public EventService(EventRepo eRe, MessageRepo mRe) {
		this.eventRepo = eRe;
		this.messageRepo = mRe;
	}
	
	//CREAR EVENTO
	public EventModel createEvent(EventModel evento) {
		return eventRepo.save(evento);
	}
	
	//EDITAR EVENTO
	public EventModel editEvent(EventModel evento) {
		return eventRepo.save(evento);
	}
	
	//DELETE EVENTO
	public void deleteEvent(Long id) {
		eventRepo.deleteById(id);
	}
	
	
	//UNIRSE O CANCELAR ASIST A EVENTO
	public void joinCancelAsist(EventModel event, User user, boolean asist) {
		if(asist) {
			event.getAsist().add(user);
		} else{
			event.getAsist().remove(user);
		}
		eventRepo.save(event);
	}
	
	//CREAR COMENTARIO
	public void addComment(User user, EventModel event, String comment) {
		
		MessageModel message = new MessageModel(user, event, comment);
		messageRepo.save(message);
	}
	
	
	public List<EventModel> sameEventState(String state) {
		return eventRepo.findByState(state);
	}
	
	public List<EventModel> otherEventState(String state){
		return eventRepo.findByStateNotContains(state);
	}
	
	public EventModel eventById(Long id) {
		return eventRepo.findById(id).orElse(null);
	}
}
