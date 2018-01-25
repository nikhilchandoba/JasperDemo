

          //..........This is simple example, no database.........//
package com.pdfFile;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import net.sf.jasperreports.engine.JRDataSource;
import net.sf.jasperreports.engine.JREmptyDataSource;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;

public class PdfFile {
 
	public static void main(String[] args)throws JRException, IOException {
	
		
		
	    // Compile jrxml file.
		//to get the jrxml file from the system 
		   FileInputStream filein= new FileInputStream("C:/jasperFile/demo1.jrxml");
		
		   //compile the jrxmal file
	       JasperReport jasperReport = JasperCompileManager.compileReport("C:/jasperFile/demo1.jrxml");
	
	       // Parameters for report
	       Map<String, Object> parameters = new HashMap<String, Object>();
	      
	       
	       //create the list and pass the data to collection data sourcce
	       List<JasperModel>parameters1=new ArrayList<>();
	 
	       //set data to model class 
	       JasperModel jm=new JasperModel();
	       jm.setAirLineClass("classA");
	       jm.setAirLineFFP("airline FFp");
	       jm.setAirLineFit("airlinefit");
	       jm.setAirLineFrom("MAA");
	       jm.setAirLineGuest("Nikhil chandoba");
	       jm.setAirLineTime("11.44");
	       jm.setAirLineTo("Goa");
	       jm.setAirLineDate(new Date());
	       parameters1.add(jm);
	       
	       //collection data source required so this is used
	       JRBeanCollectionDataSource beanColDataSource = new 
	    	         JRBeanCollectionDataSource(parameters1);
	       
	       // DataSource
	      
	       // then using empty data source.
	       JRDataSource dataSource = new JREmptyDataSource();
	
	       JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport,
	    		   parameters,  beanColDataSource);
	 
	    
	       // Make sure the output directory exists.
	       File outDir = new File("C:/jasperoutput");
	       outDir.mkdirs();
	 
	       // Export to PDF.
	       JasperExportManager.exportReportToPdfFile(jasperPrint,
	               "C:/jasperoutput/StyledTextReport3.pdf");
	        
	       System.out.println("Done!");

	}

}
