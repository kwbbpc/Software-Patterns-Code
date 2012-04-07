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
	public void doWork(WhatToDo whatToDo) {
		whatToDo.doBefore(this);  // doBefore(EditorInChief)
		for (Employee employee : employees) {
			employee.doWork(whatToDo);
		}
		whatToDo.doAfter(this);
	}
}
