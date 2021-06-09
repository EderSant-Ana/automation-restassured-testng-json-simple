package tests;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

import java.util.HashMap;
import java.util.Map;

public class TestPost {
	
	@Test
	public void testPost() {
		
		baseURI = "https://reqres.in/api";

		Map<String, String> map = new HashMap<String, String>();
		
		map.put("name", "eder");
		map.put("job", "developer");

		//System.out.println(map);
		
		JSONObject request = new JSONObject(map);
		
		//request.put("name", "eder"); request.put("job", "developer");
		
		System.out.println("Executing POST");
		
		given().
			header("Content-Type", "application/json").
			contentType(ContentType.JSON).
			accept(ContentType.JSON).
			body(request.toJSONString()).
		when().
			post("/users").
		then().
			assertThat().
				statusCode(201).
				header("Content-Type", equalTo("application/json; charset=utf-8")).
				log().all();
		
		
	}
}











