package com.javadude.adapter;

import javax.swing.event.TableModelListener;
import javax.swing.table.TableModel;

public class CombinedTableModel implements TableModel {
	private TableModel[] tables = new TableModel[2];
	
	public CombinedTableModel(TableModel t1, TableModel t2) {
		this.tables[0] = t1;
		this.tables[1] = t2;
	}

	@Override
	public int getRowCount() {
		return Math.max(tables[0].getRowCount(), tables[1].getRowCount());
	}

	@Override
	public int getColumnCount() {
		return tables[0].getColumnCount() + tables[1].getColumnCount();
	}

	private int realColumn;
	private int tableNum;
	
	private void determineLocation(int columnIndex) {
		if (columnIndex < tables[0].getColumnCount()) {
			tableNum = 0;
			realColumn = columnIndex;
		} else {
			tableNum = 1;
			realColumn = columnIndex - tables[0].getColumnCount();
		}
	}
	@Override
	public String getColumnName(int columnIndex) {
		determineLocation(columnIndex);
		return tables[tableNum].getColumnName(realColumn);
	}

	@Override
	public Class<?> getColumnClass(int columnIndex) {
		determineLocation(columnIndex);
		return tables[tableNum].getColumnClass(realColumn);
	}

	@Override
	public boolean isCellEditable(int rowIndex, int columnIndex) {
		determineLocation(columnIndex);
		return tables[tableNum].isCellEditable(rowIndex, realColumn);
	}

	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		determineLocation(columnIndex);
		return tables[tableNum].getValueAt(rowIndex, realColumn);
	}

	@Override
	public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
		determineLocation(columnIndex);
		tables[tableNum].setValueAt(aValue, rowIndex, realColumn);
	}

	@Override
	public void addTableModelListener(TableModelListener l) {
	}

	@Override
	public void removeTableModelListener(TableModelListener l) {
	}
}
