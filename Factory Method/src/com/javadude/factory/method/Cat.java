package com.javadude.factory.method;

import java.util.List;

public class Cat implements Mammal, Cloneable {
	@Override
	public List<Mammal> liveBirth() {
		return null;
	}

	@Override
	public int getBloodTemperature() {
		return 0;
	}

	@Override
	public void combHair() {
		System.out.println("Combing the cat's hair");
	}

	@Override
	public Cat clone() {
		try {
			return (Cat) super.clone();
		} catch (CloneNotSupportedException ignoreMe) {
			return null; // THIS CAN NEVER HAPPEN. SO THERE!
		}
	}
}
