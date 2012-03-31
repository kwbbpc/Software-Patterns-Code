package com.javadude.builder;

public class Mashup implements Builder {
	private Builder b1;
	private Builder b2;
	private StringBuilder sb = new StringBuilder();
	
	public Mashup(Builder b1, Builder b2) {
		this.b1 = b1;
		this.b2 = b2;
	}

	@Override
	public void createFoundation() {
		b1.setSb(sb);
		b1.createFoundation();
	}

	@Override
	public void createWalls() {
		b1.setSb(sb);
		b1.createWalls();
	}

	@Override
	public void createRoof() {
		b2.setSb(sb);
		b2.createWalls();
	}

	@Override
	public String getResult() {
		return sb.toString();
	}

	@Override
	public void setSb(StringBuilder sb) {
		this.sb = sb;
	}
}
