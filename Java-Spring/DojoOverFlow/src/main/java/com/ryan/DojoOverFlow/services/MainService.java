package com.ryan.DojoOverFlow.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.ryan.DojoOverFlow.models.AnswerModel;
import com.ryan.DojoOverFlow.models.QuestionModel;
import com.ryan.DojoOverFlow.models.QuestionTagModel;
import com.ryan.DojoOverFlow.models.TagModel;
import com.ryan.DojoOverFlow.repositories.AnswerRepo;
import com.ryan.DojoOverFlow.repositories.QuestionAndTagRepo;
import com.ryan.DojoOverFlow.repositories.QuestionRepo;
import com.ryan.DojoOverFlow.repositories.TagRepo;


@Service
public class MainService {

	
	//INYECCION DE DEPENDENCIAS
	private final AnswerRepo answerRepo;
	private final QuestionRepo questionRepo;
	private final TagRepo tagRepo;
	private final QuestionAndTagRepo quesTagRepo;
	public MainService(AnswerRepo awRe, QuestionRepo queRe, TagRepo tagRe, QuestionAndTagRepo qtRe) {
		this.answerRepo = awRe;
		this.questionRepo = queRe;
		this.tagRepo = tagRe;
		this.quesTagRepo = qtRe;
	}
	
	//CREAR PREGUNTA
	public QuestionModel createQuestion(QuestionModel question) {
		return questionRepo.save(question);
	}
	
	//CREAR TAG
	public TagModel createTag(TagModel tag) {
		return tagRepo.save(tag);
	}
	
	//CREAR ANSWER
	public AnswerModel createAnswer(AnswerModel answer) {
		return answerRepo.save(answer);
	}
	
	//CREAR VINCULACION DE PREGUNTA TAGS
	public QuestionTagModel saveQuestionTag(QuestionTagModel object) {
		return quesTagRepo.save(object);
	}
	
	public List<QuestionTagModel> allQuestionsTags() {
		return  quesTagRepo.findAll();
	}
	
	public List<QuestionModel> allQuestion(){
		return questionRepo.findAll();
	}
	
	//BUSCAR QUESTION POR ID
	
	public QuestionModel findQuestionById(Long id){
		return questionRepo.findById(id).orElse(null);
	}
	
	//CHECK SI EXISTE ETIQUETA
	public TagModel checkTag(String nameTag) {
		return tagRepo.findBySubject(nameTag);
	}
}
