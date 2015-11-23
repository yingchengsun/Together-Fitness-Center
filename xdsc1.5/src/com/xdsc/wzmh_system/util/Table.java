package com.xdsc.wzmh_system.util;

import java.util.ArrayList;
import java.util.List;

/**
 * table
 * @author �·�
 *
 */

public class Table extends Atag {
	/**Ĭ��һ��Ϊ������ǩ*/
	private Integer colsize = 2;
	/**Ĭ��һ��Ϊ����*/
	private Integer rowsize = 2;
	/**���б�*/
	private List<TableRow> rowlist = new ArrayList<TableRow>();
	/**��ǩ�б�*/
	private List<Atag> taglist = new ArrayList<Atag>();
	/***/
	private TableRow currentRow = new TableRow();

	public Table() {
	}

	public Table(Integer colSize, Integer rowSize) {
		colsize = colSize;
		rowsize = rowSize;
	}

	public Integer getColsize() {
		return colsize;
	}

	public void setColszie(Integer colsize) {
		this.colsize = colsize;
	}

	/**
	 * ����һ����ǩ
	 * @param tag
	 * @return ��ǰ����
	 */
	public Table addAtag(Atag tag) {
		taglist.add(tag);
		return this;
	}

	/**
	 * ��������ǩ
	 * @param tag
	 * @return ��ǰ����
	 */
	public Table addAtag(Atag[] tag) {
		for (int i = 0; i < tag.length; i++)
			taglist.add(tag[i]);
		return this;
	}

	/**
	 * ����һ��
	 * @param row
	 * @return ��ǰ����
	 */
	public Table addRow(TableRow row) {
		rowlist.add(row);
		return this;
	}

	public String toString() {
		String returnValue = "";
		int k = 0;
		boolean flag = false;
		while (true) {
			TableCol col = new TableCol();
			col.setColSpan("3");
			for (int j = 0; j < colsize; j++, k++) {
				if (k == taglist.size()) {
					flag = true;
					break;
				}
				col.add(taglist.get(k));
			}
			if (col.getSize() > 0)
				currentRow.add(col);
			if (currentRow.getSize() == rowsize) {
				addRow(currentRow);
				currentRow = new TableRow();
			}
			if (flag)
				break;
		}
		for (TableRow row : rowlist)
			returnValue += row.toString();
		if (currentRow.getSize() > 0)
			returnValue += currentRow;
		return returnValue;
	}

	/**
	 * ���table
	 */
	public void clear() {
		taglist.clear();
		rowlist.clear();
		currentRow = new TableRow();
	}

	/**
	 * ȡ��table����
	 * @return ����
	 */
	public int getSize() {
		return rowlist.size();
	}

}
