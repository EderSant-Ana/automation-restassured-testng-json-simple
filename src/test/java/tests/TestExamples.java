package tests;

import static org.testng.Assert.assertEquals;

import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;
import io.restassured.response.Response;
import static org.hamcrest.Matchers.*;

public class TestExamples {
	
	@Test
	public void test1() {
		
		//Response response = RestAssured.get("https://reqres.in/api/users?page=2");
		Response response = get("https://reqres.in/api/users?page=2");
		
		System.out.println(response.getStatusCode());
		System.out.println(response.getStatusLine());
		System.out.println(response.getTime());
		System.out.println(response.getBody().asString());	
		System.out.println(response.getHeader("content-type"));

		assertEquals(response.getStatusCode(), 200);
		
	}
		
	@Test
	public void test2() {
		
		baseURI = "https://reqres.in/api/";
		
		given().
		when().
			get("users?page=2").
		then().
			log().all().
			assertThat().
				statusCode(200);	
	}
	
	@Test
	public void test3() {
		
		baseURI = "https://reqres.in/api/";
		
		given().
		when().
			get("users?page=2").
		then().assertThat().
				statusCode(200).
				body("data[1].id", equalTo(8));
		
		
		given().
			queryParam("id", 8).
		when().
			get("https://reqres.in/api/users/").
		then().
			body("data.first_name", equalTo("Lindsay")).
			log().body();
		
		
		
		
	}
}
