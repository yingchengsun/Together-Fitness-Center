package com.xdsc.wzmh_system.util;

import java.util.ArrayList;
import java.util.List;

/**
 * table
 * @author 陈丰
 *
 */

public class Table extends Atag {
	/**默认一列为两个标签*/
	private Integer colsize = 2;
	/**默认一行为两列*/
	private Integer rowsize = 2;
	/**行列表*/
	private List<TableRow> rowlist = new ArrayList<TableRow>();
	/**标签列表*/
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
	 * 加入一个标签
	 * @param tag
	 * @return 当前对象
	 */
	public Table addAtag(Atag tag) {
		taglist.add(tag);
		return this;
	}

	/**
	 * 加入多个标签
	 * @param tag
	 * @return 当前对象
	 */
	public Table addAtag(Atag[] tag) {
		for (int i = 0; i < tag.length; i++)
			taglist.add(tag[i]);
		return this;
	}

	/**
	 * 加入一行
	 * @param row
	 * @return 当前对象
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
	 * 清空table
	 */
	public void clear() {
		taglist.clear();
		rowlist.clear();
		currentRow = new TableRow();
	}

	/**
	 * 取得table行数
	 * @return 行数
	 */
	public int getSize() {
		return rowlist.size();
	}

}
