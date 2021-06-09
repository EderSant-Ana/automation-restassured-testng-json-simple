package tests;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

public class TestDelete {

	@SuppressWarnings("unchecked")
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






