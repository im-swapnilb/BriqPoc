package briqPoc.briqPoc;

import com.jayway.restassured.RestAssured;
import com.jayway.restassured.response.Response;
import com.jayway.restassured.specification.RequestSpecification;

import org.testng.Assert;

import com.github.opendevl.JFlat;


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
