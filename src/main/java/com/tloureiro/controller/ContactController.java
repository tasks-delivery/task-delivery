package com.tloureiro.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.tloureiro.controller.exceptions.ElementNotFoundException;
import com.tloureiro.controller.exceptions.WrongIdFormatException;
import com.tloureiro.entity.Contact;
import com.tloureiro.repository.ContactRepository;
import com.tloureiro.repository.OrganizationRepository;
import com.tloureiro.repository.OrganizationTypeRepository;

@RestController
@RequestMapping("/resources/contacts")
public class ContactController {

	@Autowired
	ContactRepository contactRepository;
	
	@Autowired
	OrganizationRepository organizationRepository;
	
	@Autowired
	OrganizationTypeRepository organizationTypeRepository;
	
	@RequestMapping(method = RequestMethod.POST)
	public Contact create(@RequestBody Contact contact, HttpServletResponse response){
		
		
		contactRepository.save(contact);
		
		response.setStatus(HttpServletResponse.SC_CREATED);
		
		return contact;
	}
	
	/**
	 * Contacts list can be refined by providing the organizationId on the query 
	 * @param organizationId
	 * @return
	 */
	@RequestMapping(method = RequestMethod.GET)
	public List<Contact> retrieveContacts(@RequestParam(value="organizationId", required=false) String organizationId){
		
		List<Contact> contacts = new ArrayList<Contact>();
		
		if(organizationId != null){
			
			try{
				contacts = contactRepository.findByOrganizationId(new Integer(organizationId));
			}catch(NumberFormatException e){
				throw new WrongIdFormatException();
			}
			
		}else{
			for(Contact c : contactRepository.findAll()){
				contacts.add(c);
			}
		}
		
		
		return contacts;
	}
	
	@RequestMapping(value = "{id}",method = RequestMethod.GET)
	public Contact retrieveContact(@PathVariable String id){
		
		Contact contact;
		try{
			 contact = contactRepository.findOne(new Integer(id));
		}catch(NumberFormatException e){
			throw new WrongIdFormatException();
		}
		
		if(contact == null){
			throw new ElementNotFoundException(id);
		}
		
		return contact;
	}
	
	@RequestMapping(value = "{id}",method = RequestMethod.PUT)
	public Contact updateClient(@PathVariable String id, @RequestBody Contact contact){
		
		contactRepository.save(contact);
		
		return contact;
	}
	
	@RequestMapping(value = "{id}",method = RequestMethod.DELETE)
	public void deleteContact(@PathVariable String id){
		
		try{
			 contactRepository.delete(new Integer(id));
		}catch(NumberFormatException e){
			throw new WrongIdFormatException();
		}	
	}	
	
}
