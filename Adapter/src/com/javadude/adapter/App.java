package com.javadude.adapter;

import javax.swing.JFrame;
import javax.swing.JTree;
import javax.swing.WindowConstants;

public class App {
	@SuppressWarnings("serial")
	public static void main(String[] args) {
		Person p = new PersonBean();
		p.setName("Scott");
		p.setAge(45);
		
		p = new Doctor(p);
		
		System.out.println(p.getName());
		System.out.println(p.getAge());
		
		
		
		BinaryTreeNodeImpl root = new BinaryTreeNodeImpl(42);
		root.insert(10);
		root.insert(100);
		root.insert(76);
		root.insert(406);
		root.insert(33);
		root.insert(12);
		root.insert(1024);
		
		final BinaryTreeNodeTreeModel model = new BinaryTreeNodeTreeModel(new BTN1000(root));
		new JFrame() {{
			JTree tree = new JTree(model);
			tree.setCellRenderer(new BinaryTreeNodeRenderer());
			add(tree);
//			BasicTableModel t1 = new BasicTableModel("t1", 4);
//			BasicTableModel t2 = new BasicTableModel("t2", 6);
//			CombinedTableModel ctm = new CombinedTableModel(t1, t2);
//			JTable table = new JTable(ctm);
//			add(new JScrollPane(table));
			setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
			setVisible(true);
		}};
	}
}
