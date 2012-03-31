package com.javadude.builder;

public class App {
	public static void main(String[] args) {
		Pig2 p2 = new Pig2();
		Pig3 p3 = new Pig3();
		Mashup m = new Mashup(p2, p3);
		GC gc = new GC();
		gc.setBuilder(m);
		gc.buildIt();
		System.out.println(gc.getResult());
	}
}
