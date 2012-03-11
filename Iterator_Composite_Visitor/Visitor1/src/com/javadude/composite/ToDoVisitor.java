package com.javadude.composite;

public interface ToDoVisitor {
	void visitBefore(Employee e);
	void visitAfter(Employee e);
	void visitBefore(Reporter e);
	void visitAfter(Reporter e);
	void visitBefore(Editor e);
	void visitAfter(Editor e);
	void visitBefore(EditorInChief e);
	void visitAfter(EditorInChief e);
}
