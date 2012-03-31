package com.javadude.builder;

public interface Director {
	void buildIt();
	void setBuilder(Builder builder);
	String getResult();
}
