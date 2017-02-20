package com.shdatabank.puruan.service.impl;

import java.io.IOException;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletOutputStream;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFCellStyle;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import com.shdatabank.puruan.model.Fancing;
import com.shdatabank.puruan.util.ExportInternalUtil;

/**
 * 融资信息 Excel操作类
 * 
 * @author swc
 */
public class FancingExport {

	public static void ExportExcel(String[] titles, List<Fancing> list, ServletOutputStream outputStream) {
		// 创建一个workbook 对应一个excel应用文件
		XSSFWorkbook workBook = new XSSFWorkbook();
		// 在workbook中添加一个sheet,对应Excel文件中的sheet
		XSSFSheet sheet = workBook.createSheet("Sheet1");
		ExportInternalUtil exportUtil = new ExportInternalUtil(workBook, sheet);
		XSSFCellStyle headStyle = exportUtil.getHeadStyle();
		XSSFCellStyle bodyStyle = exportUtil.getBodyStyle();
		// 构建表头
		XSSFRow headRow = sheet.createRow(0);
		XSSFCell cell = null;

		// 输出标题
		for (int i = 0; i < titles.length; i++) {
			cell = headRow.createCell(i);
			cell.setCellStyle(headStyle);
			cell.setCellValue(titles[i]);
		}
		// 构建表体数据
		for (int j = 0; j < list.size(); j++) {
			XSSFRow bodyRow = sheet.createRow(j + 1);
			Fancing fancing = list.get(j);

			cell = bodyRow.createCell(0);
			cell.setCellStyle(bodyStyle);
			cell.setCellValue(fancing.getProjectName());

			cell = bodyRow.createCell(1);
			cell.setCellStyle(bodyStyle);
			cell.setCellValue(fancing.getPublishName());

			cell = bodyRow.createCell(2);
			cell.setCellStyle(bodyStyle);
			cell.setCellValue(fancing.getFancingMoney().toString());

			cell = bodyRow.createCell(3);
			cell.setCellStyle(bodyStyle);
			cell.setCellValue(timeFormat(fancing.getCreateDatetime()));
		}
		try {
			workBook.write(outputStream);
			outputStream.flush();
			outputStream.close();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				outputStream.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	/**
	 * 时间装化只要年月日
	 */
	public static String timeFormat(Timestamp sd){
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		String sdate = sdf.format(sd);
		//Date date = sdf.parse(sdate);
		return sdate;
	}
}
