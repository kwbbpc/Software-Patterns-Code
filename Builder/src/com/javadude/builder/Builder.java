package com.javadude.builder;

public interface Builder {
	void createFoundation();
	void createWalls();
	void createRoof();
	void setSb(StringBuilder sb);
	String getResult();
}
