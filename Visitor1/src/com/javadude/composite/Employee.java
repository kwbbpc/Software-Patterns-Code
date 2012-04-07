package com.javadude.composite;

public abstract class Employee {
	abstract public void accept(ToDoVisitor v);
	private String name;
	public String getName() {
		return name;
	}
	
	public Employee(String name) {
		this.name = name;
	}
	public void setName(String name) {
		this.name = name;
	}
}
