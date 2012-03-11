package com.javadude.composite;

import java.util.HashSet;
import java.util.Set;

public class Editor extends Employee {
	private Set<Employee> employees = new HashSet<Employee>();
	private String name;
	private String specialty;
	
	
	public Editor(String name, String specialty) {
		this.name = name;
		this.specialty = specialty;
	}

	public boolean add(Employee e) {
		return employees.add(e);
	}

	@Override
	public void doWork() {
		for (Employee employee : employees) {
			employee.doWork();
		}
		System.out.println(name + " lays out the " + specialty + " page");
	}
}
