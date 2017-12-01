package com.tloureiro.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.tloureiro.controller.exceptions.ElementNotFoundException;
import com.tloureiro.controller.exceptions.WrongIdFormatException;
import com.tloureiro.entity.Organization;
import com.tloureiro.repository.OrganizationRepository;

@RestController
@RequestMapping("/resources/organizations")
public class OrganizationController {
	
	
	@Autowired
	OrganizationRepository organizationRepository;
	
	@RequestMapping(method = RequestMethod.POST)
	public Organization create(@RequestBody Organization organization, HttpServletResponse response){
		
		
		organizationRepository.save(organization);
		
		response.setStatus(HttpServletResponse.SC_CREATED);
		
		return organization;
	}	
	
	@RequestMapping(method = RequestMethod.GET)
	public List<Organization> retrieveOrganizations(){
		
		List<Organization> organizations = new ArrayList<Organization>();
		
		for(Organization o : organizationRepository.findAll()){
			organizations.add(o);
		}
		
		return organizations;
	}
	
	@RequestMapping(value = "{id}",method = RequestMethod.GET)
	public Organization retrieveOrganization(@PathVariable String id){
		
		Organization organization;
		try{
			 organization = organizationRepository.findOne(new Integer(id));
		}catch(NumberFormatException e){
			throw new WrongIdFormatException();
		}
		
		if(organization == null){
			throw new ElementNotFoundException(id);
		}
		
		return organization;		
	}
	
	@RequestMapping(value = "{id}",method = RequestMethod.PUT)
	public Organization updateOrganization(@PathVariable String id, @RequestBody Organization organization){
		
		organizationRepository.save(organization);
		
		return organization;
	}
	
	@RequestMapping(value = "{id}",method = RequestMethod.DELETE)
	public void deleteOrganization(@PathVariable String id){
		
		try{
			 organizationRepository.delete(new Integer(id));
		}catch(NumberFormatException e){
			throw new WrongIdFormatException();
		}	
		
	}

}
