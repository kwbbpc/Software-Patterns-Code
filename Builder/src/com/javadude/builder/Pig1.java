package com.javadude.builder;

public class Pig1 implements Builder {
	private StringBuilder sb;
	
	public StringBuilder getSb() {
		return sb;
	}

	public void setSb(StringBuilder sb) {
		this.sb = sb;
	}

	@Override
	public void createFoundation() {
		sb.append("f-earth ");
	}

	@Override
	public void createWalls() {
		sb.append("w-straw ");
	}

	@Override
	public void createRoof() {
		sb.append("r-straw ");
	}
	public String getResult() {
		return sb.toString();
	}
}
