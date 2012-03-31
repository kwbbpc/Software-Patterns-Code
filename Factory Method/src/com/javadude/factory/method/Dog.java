package com.javadude.factory.method;

import java.util.List;

public class Dog implements Mammal {
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
		System.out.println("Combing the dog's hair");
	}

}
