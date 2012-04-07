package com.javadude.composite;

import java.util.HashSet;
import java.util.Set;

public class CompositeEmployee extends Employee {
	private Set<Employee> employees = new HashSet<Employee>();
	
	public CompositeEmployee(String name) {
		super(name);
	}

	public boolean add(Employee e) {
		return employees.add(e);
	}

	@Override
	public void doWork(WhatToDoVisitor v) {
		v.preVisit(this);
		for (Employee employee : employees) {
			employee.doWork(v);
		}
		v.postVisit(this);
	}
}
