package briqPoc.briqPoc;


import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
 
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
public class ConvertExcel2Json {
	public static void main(String[] args) {
	    // Step 1: Read Excel File into Java List Objects
	    List<Leads> customers = readExcelFile("D:\\briqPoc\\briqPoc\\leads.xlsx");
	    
	    // Step 2: Convert Java Objects to JSON String
	    String jsonString = convertObjects2JsonString(customers);
	    ObjectMapper mapper = new ObjectMapper();
	    mapper.setSerializationInclusion(Include.NON_NULL);
	  
	    System.out.println(jsonString);
	  }
	  
	  /**
	   * Read Excel File into Java List Objects
	   * 
	   * @param filePath
	   * @return
	   */
	  private static List<Leads> readExcelFile(String filePath){
	    try {
	      FileInputStream excelFile = new FileInputStream(new File(filePath));
	        Workbook workbook = new XSSFWorkbook(excelFile);
	     
	        Sheet sheet = workbook.getSheet("leads");
	        Iterator<Row> rows = sheet.iterator();
	        
	        List<Leads> lstCustomers = new ArrayList<Leads>();
	        
	        int rowNumber = 0;
	        while (rows.hasNext()) {
	          Row currentRow = rows.next();
	          
	          // skip header
	          if(rowNumber == 0) {
	            rowNumber++;
	            continue;
	          }
	          
	          Iterator<Cell> cellsInRow = currentRow.iterator();
	 
	          Leads cust = new Leads();
	          
	          int cellIndex = 0;
	          for(cellIndex=0;cellIndex<10;cellIndex++)
	          {
	            Cell currentCell = cellsInRow.next();

	            	
	            	
	            	if(cellIndex==0 )
	            	{
	            		cust.setProjectName((currentCell.getStringCellValue()));
	            		System.out.println(currentCell.getStringCellValue());
	            	}
//	            	
	            	else if(cellIndex==1)
	            	{
	            		 cust.setDescription((currentCell.getStringCellValue()));
	            			System.out.println(currentCell.getStringCellValue());
	            	}
//	            	
	            	else if(cellIndex==2)
	            	{
	            		 cust.setPermitNumber((currentCell.getStringCellValue()));
	            			System.out.println(currentCell.getStringCellValue());
	            	}
	            	else if(cellIndex==3)
	            	{
	            		 cust.setNoticeType((currentCell.getStringCellValue()));
	            			System.out.println(currentCell.getStringCellValue());
	            	}
	            	else if(cellIndex==4)
	            	{
	            		 cust.setStreet((currentCell.getStringCellValue()));
	            			System.out.println(currentCell.getStringCellValue());
	            	}
	            	else if(cellIndex==5)
	            	{
	            		 cust.setCity((currentCell.getStringCellValue()));
	            			System.out.println(currentCell.getStringCellValue());
	            	}
	            	else if(cellIndex==6)
	            	{
	            		 cust.setState((currentCell.getStringCellValue()));
	            			System.out.println(currentCell.getStringCellValue());
	            	}
	            	else if(cellIndex==7)
	            	{
	            		 cust.setContactInfo((currentCell.getStringCellValue()));
	            			System.out.println(currentCell.getStringCellValue());
	            	}
	            	else if(cellIndex==8)
	            	{
	            		 cust.setContactPhone((currentCell.getStringCellValue()));
	            			System.out.println(currentCell.getStringCellValue());
	            	}
	            	else if(cellIndex==9)
	            	{
	            		 cust.setContactEmail((currentCell.getStringCellValue()));
	            			System.out.println(currentCell.getStringCellValue());
	            	}
	            	else if(cellIndex==10)
	            	{
	            		 cust.setArchitect((currentCell.getStringCellValue()));
	            			System.out.println(currentCell.getStringCellValue());
	            	}
	            	else if(cellIndex==11)
	            	{
	            		 cust.setUploadDate((currentCell.getStringCellValue()));
	            			System.out.println(currentCell.getStringCellValue());
	            	}
	            	else if(cellIndex==12)
	            	{
	            		 cust.setStatus((currentCell.getStringCellValue()));
	            			System.out.println(currentCell.getStringCellValue());
	            	}
	            	else if(cellIndex==13)
	            	{
	            		 cust.setLink((currentCell.getStringCellValue()));
	            			System.out.println(currentCell.getStringCellValue());
	            	}
	            	else if(cellIndex==14)
	            	{
	            		 cust.setSource((currentCell.getStringCellValue()));
	            			System.out.println(currentCell.getStringCellValue());
	            	}
	            	else if(cellIndex==15)
	            	{
	            		 cust.setConstructionStartDate((currentCell.getStringCellValue()));
	            			System.out.println(currentCell.getStringCellValue());
	            	}

	          lstCustomers.add(cust);
	        }
	        
	        // Close WorkBook
	        workbook.close();
	        
	     // return lstCustomers;
	        }
	    return lstCustomers;}
	    catch (IOException e) {
	          throw new RuntimeException("FAIL! -> message = " + e.getMessage());
	        }
	  }
	  
	  /**
	   * Convert Java Objects to JSON String
	   * 
	   * @param customers
	   * @param fileName
	   */
	  private static String convertObjects2JsonString(List<Leads> customers) {
	    
	      String jsonString = "";
	      
	      try {
	    	  ObjectMapper mapper = new ObjectMapper();
	        jsonString = mapper.writeValueAsString(customers);
	      } catch (JsonProcessingException e) {
	        e.printStackTrace();
	      }
	      
	      return jsonString; 
	  }
}
