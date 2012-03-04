package com.javadude.observer;

import java.util.Date;

import com.javadude.annotations.Observable;
import com.javadude.annotations.Observer;

@Observable
@Observer
public class Student implements SunListener {
	private String name;
	
	public Student(String name) {
		this.name = name;
	}
	@Override public void sunRose(Date date) {
		System.out.println(name + ": sun rose at " + date);
	}
	@Override public void sunSet(Date date) {
		System.out.println(name + ": sun set at " + date);
	}
}
