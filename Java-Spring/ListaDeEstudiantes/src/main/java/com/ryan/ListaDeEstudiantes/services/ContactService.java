package com.ryan.ListaDeEstudiantes.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ryan.ListaDeEstudiantes.models.AddressModel;
import com.ryan.ListaDeEstudiantes.repositories.AddressRepositorie;

@Service
public class ContactService {
	
	@Autowired
	private AddressRepositorie addressRepo;
	
	public AddressModel createContact(AddressModel contact) {
		return addressRepo.save(contact);
	}
}
