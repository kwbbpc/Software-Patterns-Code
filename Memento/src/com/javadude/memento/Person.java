package com.javadude.memento;

public class Person {
	private String firstName;
	private String lastName;
	private String fullName;
	private int age;
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
		fullName = null;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
		fullName = null;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getFullName() {
		if (fullName == null) {
			fullName = firstName + " " + lastName;
		}
		return fullName;
	}

	public PersonMemento createMemento() {
		return Factory.createPersonMemento(firstName, lastName, age);
	}
}
