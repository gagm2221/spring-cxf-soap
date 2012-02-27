package com.ws.econcierge.payload;

import java.util.Set;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;

import com.ws.econcierge.view.Person;

@WebService
public interface PersonPayload
{

	interface Param
	{
		String CODE = "code";
		String PERSON = "person";
	}

	@WebMethod
	Person getPerson(@WebParam(name = Param.CODE) String id);

	@WebMethod
	Set<Person> getPersons();

	@WebMethod
	void addPerson(@WebParam(name = Param.PERSON) Person person);

	@WebMethod
	void removePerson(@WebParam(name = Param.CODE) String id);

}
