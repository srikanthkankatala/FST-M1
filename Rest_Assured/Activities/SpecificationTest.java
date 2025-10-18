package Examples;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.lessThanOrEqualTo;
import static io.restassured.RestAssured.given;

import java.util.HashMap;
import java.util.Map;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;


public class SpecificationTest {

	RequestSpecification requestSpec;
	ResponseSpecification responsespec;
	int petId;

	@BeforeClass
	public void setUp() {
		// create the request specification
		requestSpec = new RequestSpecBuilder().setBaseUri("https://petstore.swagger.io/v2/pet")
				.addHeader("Content-Type", "application/json").build();
		// create the response specification
		responsespec = new ResponseSpecBuilder().expectStatusCode(200).expectBody("status", equalTo("alive"))
				.expectResponseTime(lessThanOrEqualTo(5000L)).build();
	}
	
	

	// POST https://petstore.swagger.io/v2/pet
	@Test(priority=1)
	public void postRequestTest()
	{
		Map<String, Object> reqBody=new HashMap<>();
		reqBody.put("id", 654656);
		reqBody.put("name", "Riley");
		reqBody.put("status", "alive");
		//sent request and save the response
		Response  response = given().spec(requestSpec).body(reqBody).when().post();
		//extract petId from the response
		this.petId = response.then().extract().path("id");
		//Assertions
		response.then().spec(responsespec);
	}
	// GET https://petstore.swagger.io/v2/pet/{pet Id}
	@Test(priority = 2)
	public void getRequestTest()
	{
		given().spec(requestSpec.pathParam("petId", this.petId)).
		log().all().
		when().get("/{petId}").
		then().log().all().spec(responsespec).body("name", equalTo("Riley"));
	}
	
	// DELETE https://petstore.swagger.io/v2/pet/{pet Id}
	@Test(priority = 3)
	public void deleteRequestTest()
	{
		given().spec(requestSpec.pathParam("petId", this.petId)).
		when().delete("/{petId}").
		then().statusCode(200);
	}
}