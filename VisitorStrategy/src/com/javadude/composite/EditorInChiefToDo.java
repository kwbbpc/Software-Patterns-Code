package com.javadude.composite;

public class EditorInChiefToDo implements WhatToDo {
	@Override
	public void doBefore(Employee e) {
		System.out.println(e.getName() + " starts yelling");
	}

	@Override
	public void doAfter(Employee e) {
		System.out.println(e.getName() + " stops yelling");
	}
}
