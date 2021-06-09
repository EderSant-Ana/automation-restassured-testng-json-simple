package tests;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.apache.commons.io.IOUtils;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;

public class SoapXMLRequest {
	
	@Test
	public void validateSoapXML() throws IOException {
		
		File file = new File("./SoapRequest/add.xml");
		FileInputStream fileInputStream = new FileInputStream(file);  
		String requestBody = IOUtils.toString(fileInputStream, "UTF-8");
		
		baseURI = "https://ecs.syr.edu/faculty/fawcett/Handouts/cse775/code/calcWebService";
				
		given().
			contentType("text/XML").
			accept(ContentType.XML).
			body(requestBody).
		when().
			post("/Calc.asmx").
		then().
			assertThat().
				statusCode(200).
				body("//*:AddResult.text()", equalTo("5")).
				log().all();

			
				
	}
}
