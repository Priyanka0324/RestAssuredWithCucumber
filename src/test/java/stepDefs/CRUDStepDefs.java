package stepDefs;

import java.util.HashMap;
import java.util.Map;

import org.junit.Assert;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;


public class CRUDStepDefs {
	Response response;
	RequestSpecification request;
	Map<String,Object> MapObj ;

	@Given("The base URI is {string}")
	public void the_base_URI_is(String URI) {

		// requesting the URI link
		request = RestAssured.given().baseUri(URI);

	}

	@When("I perform the Get Operation")
	public void i_perform_the_Get_Operation() {
		
		// in feature file we have employees added
		response = request.get(); 

	}

	@Then("Response code should be {int}")
	public void response_code_should_be(int expResponseCode) {
		
		//Here import Assert from Junit
		Assert.assertEquals(expResponseCode,response.getStatusCode());

	}

	
	
	@When("I pass name as {string} and salary as {string}")
	public void i_pass_name_as_and_salary_as(String name, String salary) {
	    // Write code here that turns the phrase above into concrete actions
		MapObj= new HashMap<String,Object>();
		
		MapObj.put("name", name);
		MapObj.put("salary", salary);
		
	}

	@Then("I perform Post operation")
	public void i_perform_Post_operation() {
	    // Write code here that turns the phrase above into concrete actions
	    response =request
	    		.contentType(ContentType.JSON)
	    		.accept(ContentType.JSON)
	    		.body(MapObj)
	    		.post("/create");
	    System.out.println(response.body().asString());
	}
}
