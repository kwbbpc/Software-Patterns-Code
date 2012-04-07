package com.javadude.adapter;

public class Doctor implements Person {
	private Person realPerson;
	
	public Doctor(Person realPerson) {
		this.realPerson = realPerson;
	}

	public String getName() {
		return "Dr. " + realPerson.getName();
	}

	public void setName(String name) {
		if (name.startsWith("Dr."))
			name = name.substring(3);
		realPerson.setName(name.trim());
	}

	public int getAge() {
		return realPerson.getAge();
	}

	public void setAge(int age) {
		realPerson.setAge(age);
	}
	

}
