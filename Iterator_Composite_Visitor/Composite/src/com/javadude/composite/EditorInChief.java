package com.javadude.composite;

import java.util.HashSet;
import java.util.Set;

public class EditorInChief extends Employee {
	private Set<Employee> employees = new HashSet<Employee>();
	private String name;
	
	public EditorInChief(String name) {
		this.name = name;
	}

	public boolean add(Employee e) {
		return employees.add(e);
	}

	@Override
	public void doWork() {
		System.out.println(name + " starts yelling");
		for (Employee employee : employees) {
			employee.doWork();
		}
		System.out.println(name + " stops yelling");
	}
}
