package api.endpoint;

import static io.restassured.RestAssured.given;

import api.pojoPayload.User;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class UserEndPoint {

	// POST
	public static Response createUser(User Payload) {
		Response responce = given().contentType(ContentType.JSON).accept(ContentType.JSON).body(Payload)

				.when().post(Routes_URL.post_url);
		return responce;
	}

	// GET
	public static Response readUser(String userName) {
		Response responce = given().pathParam("username", userName)

				.when().get(Routes_URL.get_url);
		return responce;
	}

	// PUT
	public static Response updateUser(User Payload, String userName) {
		Response responce = given().contentType(ContentType.JSON).accept(ContentType.JSON)
				.pathParam("username", userName).body(Payload)

				.when().put(Routes_URL.update_url);
		return responce;
	}

	// DELETE
	public static Response deleteUser(String userName) {
		Response responce = given().pathParam("username", userName)

				.when().delete(Routes_URL.delete_url);
		return responce;
	}

}
