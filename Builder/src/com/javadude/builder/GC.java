package com.javadude.builder;

public class GC implements Director {
	private Builder builder;
	
	public Builder getBuilder() {
		return builder;
	}

	public void setBuilder(Builder builder) {
		this.builder = builder;
	}

	@Override
	public void buildIt() {
		builder.createFoundation();
		builder.createWalls();
		builder.createRoof();
	}

	@Override
	public String getResult() {
		return builder.getResult();
	}
}
