package com.javadude.composite;

public class StuffToDo implements ToDoVisitor {

	@Override
	public void visitBefore(Reporter e) {
	}

	@Override
	public void visitAfter(Reporter e) {
		System.out.println(e.getName() + " writes an article on " + e.getSpecialty());
	}

	@Override
	public void visitBefore(Editor e) {
	}

	@Override
	public void visitAfter(Editor e) {
		System.out.println(e.getName() + " lays out the " + ((Editor)e).getSpecialty() + " page");
	}

	@Override
	public void visitBefore(EditorInChief e) {
		System.out.println(e.getName() + " starts yelling");
	}

	@Override
	public void visitAfter(EditorInChief e) {
		System.out.println(e.getName() + " stops yelling");
	}

	@Override
	public void visitBefore(Employee e) {
		System.out.println("Generic employee handler - ewww");
	}

	@Override
	public void visitAfter(Employee e) {
		System.out.println("Generic employee handler - ewww");
	}

}
