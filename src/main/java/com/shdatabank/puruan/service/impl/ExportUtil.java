package com.shdatabank.puruan.service.impl;
import java.io.IOException;
import java.util.List;

import javax.servlet.ServletOutputStream;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFCellStyle;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import com.shdatabank.puruan.model.InvestCompany;
import com.shdatabank.puruan.util.ExportInternalUtil;
 
/**
 *投资机构 Excel操作类
 * @author swc
 * 供外部调用，可设置Sheet名称、标题、数据等
 */
public class ExportUtil {
 
    public static void ExportExcel(String[] titles, List<InvestCompany> list, ServletOutputStream outputStream) {
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
            InvestCompany investCompany = list.get(j);
 
            cell = bodyRow.createCell(0);
            cell.setCellStyle(bodyStyle);
            cell.setCellValue(investCompany.getInvestCompanyName());
 
            cell = bodyRow.createCell(1);
            cell.setCellStyle(bodyStyle);
            cell.setCellValue(investCompany.getBuildDate().toString());
 
            cell = bodyRow.createCell(2);
            cell.setCellStyle(bodyStyle);
            cell.setCellValue(investCompany.getInvestCase());
             
            cell = bodyRow.createCell(3);
            cell.setCellStyle(bodyStyle);
            cell.setCellValue(investCompany.getInvestPreference());
             
            cell = bodyRow.createCell(4);
            cell.setCellStyle(bodyStyle);
            cell.setCellValue(investCompany.getInvestDomain());
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
}