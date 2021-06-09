package tests;

import org.testng.annotations.Test;

import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

import org.json.simple.JSONObject;

public class TestDelete {

	@Test
	public void testDelete() {

		baseURI = "https://reqres.in/api";

		JSONObject request = new JSONObject();
		request.put("id", "3");

		given().
		when().
			delete("/users/" + request.get("id")).
		then().
			assertThat().
				statusCode(204).
			log().all();
		

		
	}
}






