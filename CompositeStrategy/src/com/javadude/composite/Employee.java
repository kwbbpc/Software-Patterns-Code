package com.javadude.composite;

public abstract class Employee {
	abstract public void doWork();
	private WhatToDo whatToDo;
	public WhatToDo getWhatToDo() {
		return whatToDo;
	}
	public void setWhatToDo(WhatToDo whatToDo) {
		this.whatToDo = whatToDo;
	}
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
