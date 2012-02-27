package com.ws.econcierge.service;

import java.util.Set;

import com.ws.econcierge.view.Person;

public interface PersonService
{
	interface Cache 
	{
		String PERSON = "person";
		String PERSONS = "persons";
	}
	
	Person getPerson(String id);

	Set<Person> getPersons();

	void addPerson(Person person);

	void removePerson(String id);
}
