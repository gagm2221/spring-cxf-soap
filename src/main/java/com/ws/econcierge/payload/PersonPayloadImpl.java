package com.ws.econcierge.payload;

import java.util.Set;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ws.econcierge.service.PersonService;
import com.ws.econcierge.view.Person;

/**
 * Sample Web Service Interface Payload
 * @author Bonec
 *
 */
@Service("personPayload")
@WebService(endpointInterface = "com.ws.econcierge.payload.PersonPayload", serviceName = "PersonPayload", portName = "PersonPayloadPort")
public class PersonPayloadImpl implements PersonPayload
{
	
	@Autowired
	private PersonService servicePerson;
	
	@WebMethod
	public Person getPerson(@WebParam(name = Param.CODE) String id)
	{
		return servicePerson.getPerson(id);
	}

	@WebMethod
	public Set<Person> getPersons()
	{
		return servicePerson.getPersons();
	}

	@WebMethod
	public void addPerson(@WebParam(name = Param.PERSON) Person person)
	{
		servicePerson.addPerson(person);
	}

	@WebMethod
	public void removePerson(@WebParam(name = Param.CODE) String id)
	{
		servicePerson.removePerson(id);
	}
}
