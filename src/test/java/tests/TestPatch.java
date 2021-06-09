package tests;

import org.testng.annotations.Test;

import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

import org.json.simple.JSONObject;

public class TestPatch {

	@SuppressWarnings("unchecked")
	@Test
	public void testPatch() {

		baseURI = "https://reqres.in/api";

		JSONObject request = new JSONObject();
		request.put("id", "3");
		request.put("email", "emma.wong@reqres.in");
		request.put( "first_name", "Emma");
		request.put("last_name", "Kong");
		request.put("avatar", "https://reqres.in/img/faces/3-image.jpg");

		given().
			header("Content-Type", "application/json").
			contentType(ContentType.JSON).
			accept(ContentType.JSON).
			body(request.toJSONString()).
		when().
			patch("/users/" + request.get("id")).
		then().
			assertThat().
				body("first_name", equalTo("Emma")).
				body("last_name", equalTo("Kong")).
				statusCode(200).
			log().all();
		

		
	}
}






