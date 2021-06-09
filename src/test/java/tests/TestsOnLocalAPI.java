package tests;

import static org.hamcrest.Matchers.*;

import org.json.simple.JSONObject;
import org.testng.annotations.Ignore;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;

import  static io.restassured.RestAssured.*;

public class TestsOnLocalAPI {
	
	@Test
	public void getTestOnLocalAPI() {
		
		baseURI = "http://localhost:3000";
		
		given().
		when().
			get("/users").
		then().
			statusCode(200).
			body("firstName", hasItem("Eder")).
			log().all();		
	}
	
	@SuppressWarnings("unchecked")
	@Ignore
	@Test
	public void postTestOnLocalAPI() {
		
		baseURI = "http://localhost:3000";
	
		JSONObject request = new JSONObject();
		
		request.put("firstName", "Eder");
		request.put("lastName", "Sant'ana");
		request.put("subjectId", "1");

		given().
			header("Content-Type", "application/json").
			contentType(ContentType.JSON).
			accept(ContentType.JSON).
			body(request.toJSONString()).
		when().
			post("/users").
		then().
			statusCode(201).
			log().all();
					
	}
	
	@Ignore
	@SuppressWarnings("unchecked")
	@Test
	public void putTestOnLocalAPI() {
		
		baseURI = "http://localhost:3000";
		
		JSONObject request = new JSONObject();
		
		request.put("firstName", "Steve");
		request.put("lastName", "Jobs");
		request.put("subjectId", "2");
		
		given().
			contentType(ContentType.JSON).
			accept(ContentType.JSON).
			body(request.toJSONString()).
		when().
			put("/users/4").
		then().
			statusCode(200).
				log().all();		
	}
	
	@Ignore
	@SuppressWarnings("unchecked")
	@Test
	public void patchTestOnLocalAPI() {
		
		baseURI = "http://localhost:3000";
		
		JSONObject request = new JSONObject();
		
		request.put("lastName", "Harris");

		given().
			contentType(ContentType.JSON).
			accept(ContentType.JSON).
			body(request.toJSONString()).
		when().
			patch("/users/4").
		then().
			statusCode(200).
				log().all();	
	}
		
	@Ignore
	@Test
	public void deleteTestOnLocalAPI() {
		
		baseURI = "http://localhost:3000";
		
		given().
		when().
			delete("/users/4").
		then().
			statusCode(200).
				log().all();	
	}
	
	
	
}





