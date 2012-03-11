package com.javadude.composite;

public interface WhatToDo {
	void doBefore(Employee e);
	void doAfter(Employee e);
	void doBefore(Reporter e);
	void doAfter(Reporter e);
	void doBefore(Editor e);
	void doAfter(Editor e);
	void doBefore(EditorInChief e);
	void doAfter(EditorInChief e);
}
