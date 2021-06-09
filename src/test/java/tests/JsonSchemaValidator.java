package tests;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;
import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchemaInClasspath;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.everyItem;
import static org.hamcrest.Matchers.greaterThan;
import static org.hamcrest.Matchers.hasItems;
import static org.hamcrest.Matchers.notNullValue;

import org.testng.annotations.Test;

public class JsonSchemaValidator {
	
	@Test
	public void testGet() {
		
		baseURI = "https://reqres.in/api";
		
		given().
		when().
			get("/users?page=2").
		then().			
			assertThat().
			body(matchesJsonSchemaInClasspath("schema.json")).
			statusCode(200).
			body("data[4].first_name", equalTo("George")).
			body("data.first_name", hasItems("George", "Rachel")).
			body("data.size()", greaterThan(0)).
			body("data.email", everyItem(notNullValue())).
			log().all();
		
	}
}
