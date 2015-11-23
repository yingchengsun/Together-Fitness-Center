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
 * @author 孙建波
 * @version 1.1<br>
 *          此类为画甘特图做准备，主要是准备数据集
 */
public class DrawGanttChart {

	/**
	 * 配置数据集
	 * 
	 * @param ganttlist
	 *            传入由数据库查询的数据列表
	 * 
	 */
	public IntervalCategoryDataset createSampleDataset(
			List<BksxTabGanttplan> ganttlist) {
		final TaskSeries s = new TaskSeries("日程表");
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
	 * 整合日期格式
	 * 
	 * @param day
	 *            日
	 * @param month
	 *            月
	 * @param year
	 *            年
	 * 
	 */
	private Date date(final int day, final int month, final int year) {
		final Calendar calendar = Calendar.getInstance();
		calendar.set(year, month, day);
		final Date result = calendar.getTime();
		return result;
	}

	/**
	 * 将日期转换为整型
	 * 
	 * @param date
	 *            传入的日期
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
	 * 配置字体 解决中文乱码
	 * 
	 * @param chart
	 *            JFreeChart 对象
	 */
	public void configFont(JFreeChart chart) {

		Font xfont = new Font("宋体", Font.PLAIN, 12);
		Font yfont = new Font("宋体", Font.PLAIN, 12);
//		Font kfont = new Font("宋体", Font.PLAIN, 12);
		Font titleFont = new Font("隶书", Font.BOLD, 25);
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
