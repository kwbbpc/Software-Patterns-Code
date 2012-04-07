package com.javadude.composite;

public class EditorToDo implements WhatToDo {
	@Override
	public void doBefore(Employee e) {
	}

	@Override
	public void doAfter(Employee e) {
		System.out.println(e.getName() + " lays out the " + ((Editor)e).getSpecialty() + " page");
	}
}
