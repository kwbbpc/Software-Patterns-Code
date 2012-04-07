package com.javadude.composite;

public class StuffToDo implements WhatToDo {

	@Override
	public void doBefore(Reporter e) {
	}

	@Override
	public void doAfter(Reporter e) {
		System.out.println(e.getName() + " writes an article on " + e.getSpecialty());
	}

	@Override
	public void doBefore(Editor e) {
	}

	@Override
	public void doAfter(Editor e) {
		System.out.println(e.getName() + " lays out the " + ((Editor)e).getSpecialty() + " page");
	}

	@Override
	public void doBefore(EditorInChief e) {
		System.out.println(e.getName() + " starts yelling");
	}

	@Override
	public void doAfter(EditorInChief e) {
		System.out.println(e.getName() + " stops yelling");
	}

	@Override
	public void doBefore(Employee e) {
		System.out.println("Generic employee handler - ewww");
	}

	@Override
	public void doAfter(Employee e) {
		System.out.println("Generic employee handler - ewww");
	}

}
