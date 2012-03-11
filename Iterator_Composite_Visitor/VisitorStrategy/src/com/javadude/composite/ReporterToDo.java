package com.javadude.composite;

public class ReporterToDo implements WhatToDo {
	@Override
	public void doBefore(Employee e) {
	}

	@Override
	public void doAfter(Employee e) {
		System.out.println(e.getName() + " writes an article on " + ((Reporter)e).getSpecialty());
	}
}
