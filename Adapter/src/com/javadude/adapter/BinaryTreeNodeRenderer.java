package com.javadude.adapter;

import java.awt.Component;

import javax.swing.JLabel;
import javax.swing.JTree;
import javax.swing.tree.DefaultTreeCellRenderer;

@SuppressWarnings("serial")
public class BinaryTreeNodeRenderer extends DefaultTreeCellRenderer {
	@Override
	public Component getTreeCellRendererComponent(
			JTree tree, Object value,
			boolean sel, boolean expanded, boolean leaf, int row,
			boolean hasFocus) {
		JLabel label = (JLabel) super.getTreeCellRendererComponent(tree, value, sel, expanded, leaf, row, hasFocus);
		BinaryTreeNode node = (BinaryTreeNode) value;
		
		BinaryTreeNodeTreeModel m = (BinaryTreeNodeTreeModel) tree.getModel();
		switch (m.getPosition(node)) {
			case Left:
				label.setText("LEFT: " + node.getData());
				break;
			case NoParent:
				label.setText("" + node.getData());
				break;
			case Right:
				label.setText("RIGHT: " + node.getData());
				break;
		}
		
		return label;
	}
}
