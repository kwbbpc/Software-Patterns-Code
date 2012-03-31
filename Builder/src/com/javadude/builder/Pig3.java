package com.javadude.builder;

public class Pig3 implements Builder {
	private StringBuilder sb;
	
	public StringBuilder getSb() {
		return sb;
	}

	public void setSb(StringBuilder sb) {
		this.sb = sb;
	}

	@Override
	public void createFoundation() {
		sb.append("f-embedded concrete ");
	}

	@Override
	public void createWalls() {
		sb.append("w-brick ");
	}
	public String getResult() {
		return sb.toString();
	}

	@Override
	public void createRoof() {
		sb.append("r-brick ");
	}

}
