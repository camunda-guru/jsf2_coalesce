package com.ness.qm.beans;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import com.ness.qm.model.Person;

public class PersonBean implements Serializable{
	private List<Person> personList;
	private Person person;
	
	public PersonBean()
	{
		personList=new ArrayList<Person>();
		person =new Person();
		
	}

	public List<Person> getPersonList() {
		return personList;
	}

	public void setPersonList(List<Person> personList) {
		this.personList = personList;
	}
	
	public String savePerson()
	{
		this.personList.add(person);
		return "view.xhtml";
		
	}
	

}
