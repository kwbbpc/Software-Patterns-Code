package com.javadude.adapter;

public class BTN1000 implements BinaryTreeNode {
	private BinaryTreeNode realNode;

	public BTN1000(BinaryTreeNode realNode) {
		super();
		this.realNode = realNode;
	}

	public void insert(int data) {
		realNode.insert(data);
	}

	public int getData() {
		return realNode.getData() + 1000;
	}

	public BinaryTreeNode getLeft() {
		if (realNode.getLeft() == null)
			return null;
		return new BTN1000(realNode.getLeft());
	}

	public BinaryTreeNode getRight() {
		if (realNode.getRight() == null)
			return null;
		return new BTN1000(realNode.getRight());
	}

}
