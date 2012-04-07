package com.javadude.adapter;

import javax.swing.event.TableModelListener;
import javax.swing.table.TableModel;

public class BasicTableModel implements TableModel {
	private String id;
	private int cols;
	
	public BasicTableModel(String id, int cols) {
		super();
		this.id = id;
		this.cols = cols;
	}

	@Override
	public int getRowCount() {
		return 10;
	}

	@Override
	public int getColumnCount() {
		return cols;
	}

	@Override
	public String getColumnName(int columnIndex) {
		return "c" + columnIndex;
	}

	@Override
	public Class<?> getColumnClass(int columnIndex) {
		return String.class;
	}

	@Override
	public boolean isCellEditable(int rowIndex, int columnIndex) {
		return false;
	}

	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		return id + ": " + rowIndex + "," + columnIndex;
	}	

	@Override
	public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
	}

	@Override
	public void addTableModelListener(TableModelListener l) {
	}

	@Override
	public void removeTableModelListener(TableModelListener l) {
	}
}
