package briqPoc.briqPoc;


import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
 
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
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
	    List<Leads> ProjDetails = readExcelFile("D:\\briqPoc\\briqPoc\\leads.xlsx");
	    
	    // Step 2: Convert Java Objects to JSON String
	    String jsonString = convertObjects2JsonString(ProjDetails);
	    ObjectMapper mapper = new ObjectMapper();
	    mapper.setSerializationInclusion(Include.NON_NULL);
	  
	    System.out.println(jsonString);
	  }
	  
	  /**
	   * Read Excel File into Java List Objects
	   * 
	   *
	   * @return
	   */
	  private static List<Leads> readExcelFile(String filePath){
	    try {
	      FileInputStream excelFile = new FileInputStream(new File(filePath));
	        Workbook workbook = new XSSFWorkbook(excelFile);
	     
	        Sheet sheet = workbook.getSheet("leads");
	        Iterator<Row> rows = sheet.iterator();
	        
	        List<Leads> projectData = new ArrayList<Leads>();
	        
	        int rowNumber = 0;
	        while (rows.hasNext()) {
	          Row currentRow = rows.next();
	          
	          // skip header
	          if(rowNumber == 0) {
	            rowNumber++;
	            continue;
	          }
	          
	     //     currentRow.getCell(2);
	          Leads data = new Leads();
	          String value = "";
	     //     int cellIndex = 0;
	          for(int cellIndex=0;cellIndex<23;cellIndex++)
	          {
	        	  Cell currentCell =  currentRow.getCell(cellIndex);
	        if (currentCell != null && currentCell.getCellType() != CellType.BLANK) {
	        		    value = currentCell.getStringCellValue();// This cell is non empty
	        		}
	        else {
	        	value = "";
	        }
	            	
	            	if(cellIndex==0 )
	            	{
	            		data.setProjectName(value);
	            	}	            	
	            	else if(cellIndex==1)
	            	{
	            		data.setProjectType(value);
	            	}            	
	            	else if(cellIndex==2)
	            	{
	            		data.setDescription(value);
	            	}
	            	else if(cellIndex==3)
	            	{
	            		data.setSqft(value);
	            	}
	            	else if(cellIndex==4)
	            	{
	            		data.setEstimatedProjectCost(value);
	            	}
	            	else if(cellIndex==5)
	            	{
	            		data.setPermitNumber(value);
	            	}
	            	else if(cellIndex==6)
	            	{
	            		data.setNoticeType(value);
	            	}
	            	else if(cellIndex==7)
	            	{
	            		data.setStreet(value);
	            	}
	            	else if(cellIndex==8)
	            	{
	            		data.setCity(value);
	            	}
	            	else if(cellIndex==9)
	            	{
	            		data.setState(value);
	            	}
	            	else if(cellIndex==10)
	            	{
	            		data.setZipcode(value);
	            	}
	            	else if(cellIndex==11)
	            	{
	            		data.setContactInfo(value);
	            	}
	            	else if(cellIndex==12)
	            	{
	            		data.setContactPhone(value);
	            	}
	            	else if(cellIndex==13)
	            	{
	            		data.setContactAddress(value);
	            	}
	            	else if(cellIndex==14)
	            	{
	            		data.setContactEmail(value);
	            	}
	            	else if(cellIndex==15)
	            	{
	            		data.setOwner(value);
	            	}
	            	else if(cellIndex==16)
	            	{
	            		data.setArchitect(value);
	            	}
	            	else if(cellIndex==17)
	            	{
	            		data.setApplicationDate(value);
	            	}
	            	else if(cellIndex==18)
	            	{
	            		data.setUploadDate(value);
	            	}
	            	else if(cellIndex==19)
	            	{
	            		data.setStatus(value);
	            	}
	            	else if(cellIndex==20)
	            	{
	            		data.setCloseDate(value);
	            	}
	            	else if(cellIndex==21)
	            	{
	            		data.setLink(value);
	            	}
	            	else if(cellIndex==22)
	            	{
	            		data.setSource(value);
	            	}
	            	else if(cellIndex==23)
	            	{
	            		data.setConstructionStartDate(value);
	            	}
	            	
	            	projectData.add(data);
	        }
	        
	        // Close WorkBook
	        workbook.close();
	        
	     // return listProjectdata;
	        }
	    return projectData;}
	    catch (IOException e) {
	          throw new RuntimeException("FAIL! -> message = " + e.getMessage());
	        }
	  }
	  
	  /**
	   * Convert Java Objects to JSON String
	   * 
	  
	   */
	  private static String convertObjects2JsonString(List<Leads> ProjDetails) {
	    
	      String jsonString = "";
	      
	      try {
	    	  ObjectMapper mapper = new ObjectMapper();
	        jsonString = mapper.writeValueAsString(ProjDetails);
	      } catch (JsonProcessingException e) {
	        e.printStackTrace();
	      }
	      
	      return jsonString; 
	  }
}
