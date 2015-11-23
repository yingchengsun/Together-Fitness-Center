package com.xdsc.action.bksx_system;

import java.awt.Color;
import java.awt.Font;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.CategoryAxis;
import org.jfree.chart.axis.CategoryLabelPositions;
import org.jfree.chart.axis.ValueAxis;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.title.TextTitle;
import org.jfree.data.category.IntervalCategoryDataset;
import org.jfree.data.gantt.Task;
import org.jfree.data.gantt.TaskSeries;
import org.jfree.data.gantt.TaskSeriesCollection;

import com.xdsc.model.BksxTabGanttplan;

/**
 * @author �ｨ��
 * @version 1.1<br>
 *          ����Ϊ������ͼ��׼������Ҫ��׼�����ݼ�
 */
public class DrawGanttChart {

	/**
	 * �������ݼ�
	 * 
	 * @param ganttlist
	 *            ���������ݿ��ѯ�������б�
	 * 
	 */
	public IntervalCategoryDataset createSampleDataset(
			List<BksxTabGanttplan> ganttlist) {
		final TaskSeries s = new TaskSeries("�ճ̱�");
		for (int i = 0; i < ganttlist.size(); i++) {
			final Task t = new Task(ganttlist.get(i).getFTaskName(), date(
					getIntDate(ganttlist.get(i).getFStartDate())[2],
					getIntDate(ganttlist.get(i).getFStartDate())[1],
					getIntDate(ganttlist.get(i).getFStartDate())[0]), date(
					getIntDate(ganttlist.get(i).getFFinishDate())[2],
					getIntDate(ganttlist.get(i).getFFinishDate())[1],
					getIntDate(ganttlist.get(i).getFFinishDate())[0]));
			t.setPercentComplete(ganttlist.get(i).getFCompletePercent());
			s.add(t);
		}
		final TaskSeriesCollection collection = new TaskSeriesCollection();
		collection.add(s);
		return collection;
	}

	/**
	 * �������ڸ�ʽ
	 * 
	 * @param day
	 *            ��
	 * @param month
	 *            ��
	 * @param year
	 *            ��
	 * 
	 */
	private Date date(final int day, final int month, final int year) {
		final Calendar calendar = Calendar.getInstance();
		calendar.set(year, month, day);
		final Date result = calendar.getTime();
		return result;
	}

	/**
	 * ������ת��Ϊ����
	 * 
	 * @param date
	 *            ���������
	 * 
	 */

	private int[] getIntDate(Date date) {
		DateFormat dateFormat = new SimpleDateFormat("yyyyMMdd");
		String str = dateFormat.format(date);
		int year = Integer.parseInt(str.substring(0, 4));
		int month = Integer.parseInt(str.substring(4, 6));
		int day = Integer.parseInt(str.substring(6, 8));
		int[] intDate = { year, month - 1, day };
		return intDate;
	}

	/**
	 * �������� �����������
	 * 
	 * @param chart
	 *            JFreeChart ����
	 */
	public void configFont(JFreeChart chart) {

		Font xfont = new Font("����", Font.PLAIN, 12);
		Font yfont = new Font("����", Font.PLAIN, 12);
//		Font kfont = new Font("����", Font.PLAIN, 12);
		Font titleFont = new Font("����", Font.BOLD, 25);
		CategoryPlot plot = chart.getCategoryPlot();

		chart.setTitle(new TextTitle(chart.getTitle().getText(), titleFont));

//		chart.getLegend().setItemFont(kfont);

		CategoryAxis domainAxis = plot.getDomainAxis();
		domainAxis.setLabelFont(xfont);
		domainAxis.setTickLabelFont(xfont);
		domainAxis.setTickLabelPaint(Color.BLACK);
		domainAxis.setCategoryLabelPositions(CategoryLabelPositions.UP_45);

		ValueAxis rangeAxis = plot.getRangeAxis();
		rangeAxis.setLabelFont(yfont);
		rangeAxis.setLabelPaint(Color.BLACK);
		rangeAxis.setTickLabelFont(yfont);

	}

}
