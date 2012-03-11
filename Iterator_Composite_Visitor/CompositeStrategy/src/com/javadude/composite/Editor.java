package com.javadude.composite;

import java.util.HashSet;
import java.util.Set;

public class Editor extends Employee {
	private Set<Employee> employees = new HashSet<Employee>();
	private String specialty;
	
	public String getSpecialty() {
		return specialty;
	}

	public Editor(String name, String specialty) {
		super(name);
		this.specialty = specialty;
	}

	public boolean add(Employee e) {
		return employees.add(e);
	}

	@Override
	public void doWork() {
		getWhatToDo().doBefore(this);
		for (Employee employee : employees) {
			employee.doWork();
		}
		getWhatToDo().doAfter(this);
	}
}
