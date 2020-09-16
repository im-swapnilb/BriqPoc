package briqPoc.briqPoc;

import com.jayway.restassured.RestAssured;
import com.jayway.restassured.mapper.ObjectMapper;
import com.jayway.restassured.response.Response;
import com.jayway.restassured.specification.RequestSpecification;
import org.apache.commons.io.FileUtils;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.util.List;

import javax.naming.Name;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.CreationHelper;
import org.apache.poi.ss.usermodel.Font;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.json.CDL;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.w3c.dom.NameList;
import org.testng.Assert;

import com.fasterxml.jackson.databind.*;
import com.github.opendevl.JFlat;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.type.TypeReference;

 

public class RestAssuredApi {

	static String responseData;
	static boolean status = false;
	public static void main(String[] args) throws Exception {
		System.out.println("Excel conversion "+restAssuredApi());
	}
	
	public static boolean restAssuredApi() {
		
	    RestAssured.baseURI ="https://data.sfgov.org/resource/";
		RequestSpecification request = RestAssured.given();
		Response response = request.get("p4e4-a5a7.json");

		int statusCode = response.getStatusCode();
		responseData = response.getBody().asString();
		Assert.assertEquals(statusCode, 200);
		System.out.println(responseData);
		
		// create Jflat object
	JFlat jsonToExcel = new JFlat(responseData);
	
	
	//write the 2D representation in csv format
		try {
			jsonToExcel.json2Sheet().headerSeparator("_").write2csv("D:\\briqPoc\\briqPoc\\JsonData.csv");
			status = true;
		} 
		 catch (Exception e) {
			 status = false;
			e.printStackTrace();
		}	
			return status;
		}
		
}
