package com.pdf;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;

public class JasperReportFill2 {
   @SuppressWarnings("unchecked")
   public static void main(String[] args) {
      String sourceFileName ="report/reports.jasper";
      DataBeanList DataBeanList = new DataBeanList();
      ArrayList<DataBean> dataList = DataBeanList.getDataBeanList();

      JRBeanCollectionDataSource beanColDataSource = new JRBeanCollectionDataSource(dataList);

      Map parameters = new HashMap();
      try {
         JasperPrint jasperPrint = JasperFillManager.fillReport(
         sourceFileName,
         parameters,
         beanColDataSource);
         JasperExportManager.exportReportToPdfFile(jasperPrint,"report/001.pdf");
         
      } catch (JRException e) {
         e.printStackTrace();
      }
   }
}