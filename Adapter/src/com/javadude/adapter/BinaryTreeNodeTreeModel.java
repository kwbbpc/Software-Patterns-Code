package com.javadude.adapter;

import java.util.HashMap;
import java.util.Map;

import javax.swing.event.TreeModelListener;
import javax.swing.tree.TreeModel;
import javax.swing.tree.TreePath;

public class BinaryTreeNodeTreeModel implements TreeModel {
	private BinaryTreeNode root;
	private Map<BinaryTreeNode, BinaryTreeNode> parents = new HashMap<BinaryTreeNode, BinaryTreeNode>();
	
	public BinaryTreeNodeTreeModel(BinaryTreeNode root) {
		this.root = root;
		mapParents(null, root);
	}

	private void mapParents(BinaryTreeNode parent, BinaryTreeNode child) {
		if (parent != null)
			parents.put(child, parent);
		if (child.getLeft() != null) {
			mapParents(child, child.getLeft());
		}
		if (child.getRight() != null) {
			mapParents(child, child.getRight());
		}
	}
	
	public enum Child {
		Left, Right, NoParent;
	}
	
	public Child getPosition(BinaryTreeNode child) {
		BinaryTreeNode parent = parents.get(child);
		if (parent == null)
			return Child.NoParent;
		if (parent.getLeft() == child)
			return Child.Left;
		return Child.Right;
	}
	
	@Override
	public Object getRoot() {
		return root;
	}

	@Override
	public Object getChild(Object parent, int index) {
		BinaryTreeNode node = (BinaryTreeNode) parent;
		if (index == 1 || node.getLeft() == null)
			return node.getRight();
		return node.getLeft();
	}

	@Override
	public int getChildCount(Object parent) {
		BinaryTreeNode node = (BinaryTreeNode) parent;
		int count = 0;
		if (node.getLeft() != null)
			count++;
		if (node.getRight() != null)
			count++;
		return count;
	}

	@Override
	public boolean isLeaf(Object node) {
		return getChildCount(node) == 0;
	}

	@Override
	public int getIndexOfChild(Object parent, Object child) {
		BinaryTreeNode node = (BinaryTreeNode) parent;
		if (node.getLeft() == child || node.getLeft() == null)
			return 0;
		return 1;
	}
	
	@Override public void valueForPathChanged(TreePath path, Object newValue) { }
	@Override public void addTreeModelListener(TreeModelListener l) { }
	@Override public void removeTreeModelListener(TreeModelListener l) { }
}
