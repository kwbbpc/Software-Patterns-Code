package com.javadude.composite;

public class Reporter extends Employee {
	private String specialty;
	
	public Reporter(String name, String specialty) {
		super(name);
		this.specialty = specialty;
	}
	public String getSpecialty() {
		return specialty;
	}

	@Override
	public void doWork(WhatToDo whatToDo) {
		whatToDo.doBefore(this);
		whatToDo.doAfter(this);
	}
}
