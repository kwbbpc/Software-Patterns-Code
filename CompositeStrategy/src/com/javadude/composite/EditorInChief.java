package com.javadude.composite;

import java.util.HashSet;
import java.util.Set;

public class EditorInChief extends Employee {
	private Set<Employee> employees = new HashSet<Employee>();
	
	public EditorInChief(String name) {
		super(name);
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
