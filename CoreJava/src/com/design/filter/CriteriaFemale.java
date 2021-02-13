package com.design.filter;

import java.util.ArrayList;
import java.util.List;

public class CriteriaFemale implements Criteria {

	public List<Person> meetCriteria(List<Person> persons) {
		List<Person> femalePersons = new ArrayList<Person>();
		for(Person person : femalePersons) {
			if(person.getGender().equalsIgnoreCase("FEMALE")) {
				femalePersons.add(person);
			}
		}
		return femalePersons;
	}
}
