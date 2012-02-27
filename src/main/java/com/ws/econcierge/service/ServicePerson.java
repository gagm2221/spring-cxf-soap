package com.ws.econcierge.service;

import java.util.HashSet;
import java.util.Set;

import org.springframework.stereotype.Service;

import com.googlecode.ehcache.annotations.Cacheable;
import com.googlecode.ehcache.annotations.TriggersRemove;
import com.googlecode.ehcache.annotations.When;
import com.ws.econcierge.view.Person;

@Service
public class ServicePerson implements PersonService
{
	private Set<Person> persons = new HashSet<Person>();

	@Override
	@Cacheable(cacheName = Cache.PERSON)
	public Person getPerson(String id)
	{
		Person person = new Person(id, "", "");
		if (persons.contains(person))
		{
			for (Person p : persons)
			{
				if (p.equals(person))
				{
					return p;
				}
			}
		}
		return null;
	}

	@Cacheable(cacheName = Cache.PERSONS)
	public Set<Person> getPersons()
	{
		return persons;
	}

	@TriggersRemove(cacheName =
	{ Cache.PERSON, Cache.PERSONS }, when = When.AFTER_METHOD_INVOCATION, removeAll = true)
	public void addPerson(Person person)
	{
		persons.add(person);
	}

	@TriggersRemove(cacheName =
	{ Cache.PERSON, Cache.PERSONS }, when = When.AFTER_METHOD_INVOCATION, removeAll = true)
	public void removePerson(String id)
	{
		persons.remove(new Person(id, "", ""));
	}
}
