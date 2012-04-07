package com.javadude.composite;

public class Reporter extends Employee {
	private String specialty;
	private final String name;
	
	public Reporter(String name, String specialty) {
		this.name = name;
		this.specialty = specialty;
	}

	@Override
	public void doWork() {
		System.out.println(name + " writes an article on " + specialty);
	}
}
