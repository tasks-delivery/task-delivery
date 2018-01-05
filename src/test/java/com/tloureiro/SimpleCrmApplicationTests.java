package com.tloureiro;
/*
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.util.Assert;
import org.springframework.web.context.WebApplicationContext;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.tloureiro.entity.Address;
import com.tloureiro.entity.Contact;
import com.tloureiro.entity.Organization;
import com.tloureiro.entity.OrganizationType;
import com.tloureiro.repository.ContactRepository;
import com.tloureiro.repository.OrganizationRepository;
import com.tloureiro.repository.OrganizationTypeRepository;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = SimpleCrmApplication.class)
@WebAppConfiguration
*/
public class SimpleCrmApplicationTests {
/*
	private MockMvc mockMvc;

	private MediaType contentType; 

	@Autowired
	private WebApplicationContext webApplicationContext;

	@Autowired
	private ContactRepository contactRepository;

	@Autowired
	private OrganizationRepository organizationRepository;

	@Autowired
	private OrganizationTypeRepository organizationTypeRepository;

	@Before
	public void setup() throws Exception {

		this.contentType = new MediaType(MediaType.APPLICATION_JSON.getType(),
				MediaType.APPLICATION_JSON.getSubtype(),
				Charset.forName("utf8"));

		this.mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();

	}

	@Test
	public void testRestSimpleContactInclusion() throws Exception{

		Contact contact = new Contact();
		contact.setFirstName("James");
		contact.setLastName("Loureiro");
		contact.setPhone("30932039209");
		contactRepository.save(contact);

		mockMvc.perform(
				MockMvcRequestBuilders.post("/resources/contacts").
				content(new ObjectMapper().writeValueAsString(contact)).
				contentType(contentType)
				).andExpect(
						MockMvcResultMatchers.status().isCreated()
						);


		List<Contact> contacts = contactRepository.findByFirstNameContainingIgnoreCase("James");
		Assert.notEmpty(contacts);
		Assert.notNull(contacts.get(0).getId());

		contacts = contactRepository.findByFirstNameContainingIgnoreCase("Mary");
		Assert.isTrue(contacts.isEmpty());

	}

	@Test
	public void testRestSimpleOrganizationInclusion() throws Exception{

		Organization organization = new Organization();
		organization.setName("Test charity");
		organization.setPhone("20093940384");

		mockMvc.perform(
				MockMvcRequestBuilders.post("/resources/organizations").
				content(new ObjectMapper().writeValueAsString(organization)).
				contentType(contentType)
				).andExpect(
						MockMvcResultMatchers.status().isCreated()
						);


		List<Organization> organizations = organizationRepository.findByNameContainingIgnoreCase("charity");
		Assert.notEmpty(organizations);
		Assert.notNull(organizations.get(0).getId());

		organizations = organizationRepository.findByNameContainingIgnoreCase("Umbrella");
		Assert.isTrue(organizations.isEmpty());
	}


	@Test
	public void testSimpleOrganizationTypeInclusion(){

		OrganizationType organizationType = new OrganizationType();
		organizationType.setName("Test type");

		organizationTypeRepository.save(organizationType);

		List<OrganizationType> organizationTypes = organizationTypeRepository.findByNameContainingIgnoreCase("test");

		Assert.notEmpty(organizationTypes);
		Assert.notNull(organizationTypes.get(0).getId());
	}

	@Test
	public void testRestContactsList() throws JsonProcessingException, Exception{

		MvcResult mvcResult = mockMvc.perform(
					MockMvcRequestBuilders.get("/resources/contacts")
				).andExpect(
						MockMvcResultMatchers.status().is2xxSuccessful()
				).andReturn();
		
		Assert.notNull(mvcResult.getResponse().getContentAsString());
		Assert.isTrue(!mvcResult.getResponse().getContentAsString().isEmpty());

		List<Contact> contacts = new ArrayList<Contact>();
		contacts = new ObjectMapper().readValue(mvcResult.getResponse().getContentAsString(), new TypeReference<List<Contact>>(){});

		Assert.notNull(contacts);
		Assert.notEmpty(contacts);
		Assert.isTrue(contacts.size() == 1);
		
		Assert.notNull(contacts.get(0).getId());
		
	}

	@Test
	public void testRestOrganizationsList() throws Exception{

		MvcResult mvcResult = mockMvc.perform(
				MockMvcRequestBuilders.get("/resources/organizations")
			).andExpect(
					MockMvcResultMatchers.status().is2xxSuccessful()
			).andReturn();
	
		Assert.notNull(mvcResult.getResponse().getContentAsString());
		Assert.isTrue(!mvcResult.getResponse().getContentAsString().isEmpty());
	
		List<Organization> organizations = new ArrayList<Organization>();
		organizations = new ObjectMapper().readValue(mvcResult.getResponse().getContentAsString(), new TypeReference<List<Organization>>(){});
	
		Assert.notNull(organizations);
		Assert.notEmpty(organizations);
		Assert.isTrue(organizations.size() > 1);
		
		Assert.notNull(organizations.get(0).getId());		
	}

	@Test
	public void testRestOrganizationTypesList() throws Exception{

		MvcResult mvcResult = mockMvc.perform(
				MockMvcRequestBuilders.get("/resources/organizationtypes")
			).andExpect(
					MockMvcResultMatchers.status().is2xxSuccessful()
			).andReturn();
	
		Assert.notNull(mvcResult.getResponse().getContentAsString());
		Assert.isTrue(!mvcResult.getResponse().getContentAsString().isEmpty());
	
		List<OrganizationType> organizationsTypes = new ArrayList<OrganizationType>();
		organizationsTypes = new ObjectMapper().readValue(mvcResult.getResponse().getContentAsString(), new TypeReference<List<OrganizationType>>(){});
	
		Assert.notNull(organizationsTypes);
		Assert.notEmpty(organizationsTypes);
		Assert.isTrue(organizationsTypes.size() > 1);
		
		Assert.notNull(organizationsTypes.get(0).getId());		
	}
	
	@Test
	public void testUpdateContact() throws Exception{
		
		Contact contact = contactRepository.findAll().iterator().next();
		
		contact.setFirstName(contact.getFirstName() + " Modified");

		mockMvc.perform(
				MockMvcRequestBuilders.put("/resources/contacts/" + contact.getId()).
				content(new ObjectMapper().writeValueAsString(contact)).
				contentType(contentType)
			).andExpect(
					MockMvcResultMatchers.status().is2xxSuccessful()
			);
		
		List<Contact> contacts = contactRepository.findByFirstNameContainingIgnoreCase("modified");
		Assert.notNull(contacts);
		Assert.notEmpty(contacts);
	}
	
	@Test
	public void testUpdateOrganization() throws Exception{
		
		Organization organization = organizationRepository.findAll().iterator().next();
		
		organization.setName(organization.getName() + " Modified");

		mockMvc.perform(
				MockMvcRequestBuilders.put("/resources/organizations/" + organization.getId()).
				content(new ObjectMapper().writeValueAsString(organization)).
				contentType(contentType)
			).andExpect(
					MockMvcResultMatchers.status().is2xxSuccessful()
			);
		
		List<Organization> organizations = organizationRepository.findByNameContainingIgnoreCase("modified");
		Assert.notNull(organizations);
		Assert.notEmpty(organizations);
	}
	
	@Test
	public void testDeleteContact() throws Exception{
		
		Contact contact1 = new Contact();
		contact1.setFirstName("Tobe Deleted");
		contact1.setLastName("User");
		contact1.setPhone("04940394309");
		contact1.setEmail("to@deleted.com");
		
			Address address = new Address();
			address.setCity("Toronto");
			address.setCountry("Canada");
			address.setNumber("10A");
			address.setPostalCode("9090");
			address.setProvince("Quebec");
			address.setStreet("Street");
		contact1.setAddress(address);
			
			Organization organization = new Organization();
			organization.setName("Another organization");
			organization.setPhone("22902293");
			organization.setEmail("another@organization.com");
			organization.setAddress(address);
			
			organization.setOrganizationType(organizationTypeRepository.findByNameContainingIgnoreCase("charity").get(0));
			organizationRepository.save(organization);
		contact1.setOrganization(organization);
			
		contactRepository.save(contact1);
		
		Contact contact = contactRepository.findByFirstNameContainingIgnoreCase("tobe deleted").get(0);
		
		Assert.notNull(contact);

		mockMvc.perform(
				MockMvcRequestBuilders.delete("/resources/contacts/" + contact.getId())
			).andExpect(
					MockMvcResultMatchers.status().is2xxSuccessful()
			);
		
		List<Contact> contacts = contactRepository.findByFirstNameContainingIgnoreCase("tobe deleted");
		Assert.isTrue(contacts.size() == 0);
	}
	
	
	@Test
	public void testDeleteOrganization() throws Exception{
		
		Contact contact1 = new Contact();
		contact1.setFirstName("John");
		contact1.setLastName("User");
		contact1.setPhone("04940394389");
		contact1.setEmail("john@john.com");
		
			Address address = new Address();
			address.setCity("Toronto1");
			address.setCountry("Canada");
			address.setNumber("10A");
			address.setPostalCode("9090");
			address.setProvince("Quebec");
			address.setStreet("Street");
		contact1.setAddress(address);
			
			Organization organization1 = new Organization();
			organization1.setName("Dharma");
			organization1.setPhone("22902293");
			organization1.setEmail("contact@dharma.com");
			organization1.setAddress(address);
			
			organization1.setOrganizationType(organizationTypeRepository.findByNameContainingIgnoreCase("company").get(0));
			organizationRepository.save(organization1);
		contact1.setOrganization(organization1);		
		
		Organization organization = organizationRepository.findByNameContainingIgnoreCase("dharma").get(0);
		
		
		Assert.notNull(organization);

		mockMvc.perform(
				MockMvcRequestBuilders.delete("/resources/organizations/" + organization.getId())
			).andExpect(
					MockMvcResultMatchers.status().is2xxSuccessful()
			);
		
		List<Organization> organizations = organizationRepository.findByNameContainingIgnoreCase("dharma");
		Assert.isTrue(organizations.size() == 0);
		
	}
	
	*/

}
