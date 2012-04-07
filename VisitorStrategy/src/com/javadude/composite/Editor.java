package com.javadude.composite;

public class Editor extends CompositeEmployee {
	private String specialty;
	
	public String getSpecialty() {
		return specialty;
	}

	public Editor(String name, String specialty) {
		super(name);
		this.specialty = specialty;
	}
}
