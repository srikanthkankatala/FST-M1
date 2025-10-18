package Examples;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.equalTo;

import org.hamcrest.Matchers;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class FirstTest {
	String baseURI;

	@Test
	public void helloRest() {
		baseURI = "https://petstore.swagger.io/v2/pet";

		Response response = given().contentType(ContentType.JSON).when().get(baseURI + "/findByStatus?status=sold");
		response.prettyPrint();

		// Print the status code
		System.out.println(response.statusCode());
		System.out.println("===============================");
		// Print the response headers
		System.out.println(response.getHeaders().asList());
		System.out.println("===============================");
		// Print the response body
		System.out.println(response.getBody().asString());
		System.out.println("===============================");
		System.out.println(response.getBody().asPrettyString());

		// StringBuilder petStatus=response.then().extract().path("[0].status");

		response.then().statusCode(200);
		response.then().body("[0].status", equalTo("sold"));
	}

	@Test
	public void getrequestWithPathParam() {
		// Send request, get response, and assert
				RestAssured.given().  // Request Specification
					baseUri("https://petstore.swagger.io/v2/pet").
					header("Content-Type", "application/json"). // Request content type
					pathParam("petId", 12).
				when().get("/{petId}").
				then().
					statusCode(200).
					body("[0].status", Matchers.equalTo("sold")).
					body("[0].name", Matchers.equalTo("doggie"));
		 

	}

}