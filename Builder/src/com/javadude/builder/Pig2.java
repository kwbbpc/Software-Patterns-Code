package com.javadude.builder;

public class Pig2 implements Builder {
	private StringBuilder sb;
	
	public StringBuilder getSb() {
		return sb;
	}

	public void setSb(StringBuilder sb) {
		this.sb = sb;
	}

	@Override
	public void createFoundation() {
		sb.append("f-concrete ");
	}

	@Override
	public void createWalls() {
		sb.append("w-wood ");
	}

	@Override
	public void createRoof() {
		sb.append("r-wood ");
	}
	public String getResult() {
		return sb.toString();
	}

}
