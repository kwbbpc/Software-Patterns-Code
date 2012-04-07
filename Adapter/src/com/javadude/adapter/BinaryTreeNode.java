package com.javadude.adapter;

public interface BinaryTreeNode {

	public abstract void insert(int data);

	public abstract int getData();

	public abstract BinaryTreeNode getLeft();

	public abstract BinaryTreeNode getRight();

}