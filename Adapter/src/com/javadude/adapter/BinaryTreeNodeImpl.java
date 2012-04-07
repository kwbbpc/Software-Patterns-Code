package com.javadude.adapter;

public class BinaryTreeNodeImpl implements BinaryTreeNode {
	private int data;
	private BinaryTreeNodeImpl left;
	private BinaryTreeNodeImpl right;
	public BinaryTreeNodeImpl(int data) {
		this.data = data;
	}
	/* (non-Javadoc)
	 * @see com.javadude.adapter.BinaryTreeNode#insert(int)
	 */
	@Override
	public void insert(int data) {
		if (data < this.data) {
			if (left == null)
				left = new BinaryTreeNodeImpl(data);
			else
				left.insert(data);
		} else {
			if (right == null)
				right = new BinaryTreeNodeImpl(data);
			else
				right.insert(data);
		}
	}
	/* (non-Javadoc)
	 * @see com.javadude.adapter.BinaryTreeNode#getData()
	 */
	@Override
	public int getData() {
		return data;
	}
	/* (non-Javadoc)
	 * @see com.javadude.adapter.BinaryTreeNode#getLeft()
	 */
	@Override
	public BinaryTreeNode getLeft() {
		return left;
	}
	/* (non-Javadoc)
	 * @see com.javadude.adapter.BinaryTreeNode#getRight()
	 */
	@Override
	public BinaryTreeNode getRight() {
		return right;
	}
}
