package com.javadude.memento;

public class Factory {
	private static class MyMemento implements PersonMemento {
		private String firstName;
		private String lastName;
		private int age;
	}
	public static Person create(PersonMemento memento) {
		MyMemento personMemento = (MyMemento) memento;
		Person p = new Person();
		p.setFirstName(personMemento.firstName);
		p.setLastName(personMemento.lastName);
		p.setAge(personMemento.age);
		return p;
	}
	static PersonMemento createPersonMemento(String firstName, String lastName, int age) {
		MyMemento m = new MyMemento();
		m.firstName = firstName;
		m.lastName = lastName;
		m.age = age;
		return m;
	}
}
