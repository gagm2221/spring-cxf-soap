package com.ws.econcierge.view;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "person")
public class Person implements Serializable
{
	private static final long serialVersionUID = 1L;
	private String id;
	private String name;
	private String age;

	public Person()
	{
		super();
	}

	public Person(String id, String name, String age)
	{
		this.id = id;
		this.name = name;
		this.age = age;
	}

	public String getId()
	{
		return id;
	}

	@XmlElement(name = "code", nillable = false, required = true)
	public void setId(String id)
	{
		this.id = id;
	}

	public String getName()
	{
		return name;
	}

	@XmlElement(name = "fullname", nillable = false, required = true)
	public void setName(String name)
	{
		this.name = name;
	}

	public String getAge()
	{
		return age;
	}

	@XmlElement(name = "edad")
	public void setAge(String age)
	{
		this.age = age;
	}

	@Override
	public int hashCode()
	{
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj)
	{
		if (this == obj)
		{
			return true;
		}
		if (obj == null)
		{
			return false;
		}
		if (getClass() != obj.getClass())
		{
			return false;
		}
		Person other = (Person) obj;
		if (id == null)
		{
			if (other.id != null)
			{
				return false;
			}
		} else if (!id.equals(other.id))
		{
			return false;
		}
		return true;
	}

}
