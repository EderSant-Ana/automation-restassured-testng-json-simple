package tests;

import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

public class TestGet {
	
	@Test
	public void testGet() {
		
		baseURI = "https://reqres.in/api";
		
		given().
		when().
			get("/users?page=2").
		then().
			log().all().
			statusCode(200).
			body("data[4].first_name", equalTo("George")).
			body("data.first_name", hasItems("George", "Rachel")).
			body("data.size()", greaterThan(0)).
			body("data.email", everyItem(notNullValue()));	
	}
	
	
}
