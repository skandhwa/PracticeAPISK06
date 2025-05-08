package StepDefinition8;

import static io.restassured.RestAssured.given;

import java.io.IOException;

import org.testng.Assert;

import com.fasterxml.jackson.core.JsonProcessingException;

import TestData.POJOImplementation;
import TestData.TestDataExcel;
import Utilities.FetchDataFromProperty;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;

public class StepDefinition8 {
	
	RequestSpecification req,res;
	 
	ResponseSpecification respec;
	Response response;
	
	
	
	
	String URI1=FetchDataFromProperty.readDataFromProperty().getProperty("URI1");
	String URI2=FetchDataFromProperty.readDataFromProperty().getProperty("URI2");
	String AuthToken;
	
	
	
	@Given("user requests to hit an application URI")
	public void user_requests_to_hit_an_application_uri() {
		
		req=new RequestSpecBuilder() .setBaseUri(URI1).setContentType(ContentType.JSON).setRelaxedHTTPSValidation()
				.build();
		
		
		
		
	    
	}

	@Given("user passed the payload with all required details")
	public void user_passed_the_payload_with_all_required_details() throws JsonProcessingException {
		
		res= given().log().all().headers("x-api-key","reqres-free-v1").
				relaxedHTTPSValidation().spec(req)
				.body(POJOImplementation.createUserData());
		
	  
	}

	@When("user will hit the {string}")
	public void user_will_hit_the(String endpoint) {
		
		respec=new ResponseSpecBuilder().build();
		
		response=	res.when().post(endpoint).then().log().all().spec(respec).extract().response();

		System.out.println("My dummy code");
		
	    
	}
	
	
	@Given("user hit the gorest with on its uri")
	public void user_hit_the_gorest_with_on_its_uri() {
		
		req=new RequestSpecBuilder() .setBaseUri(URI2).setContentType(ContentType.JSON)
				.build();
		
		
	}

	@When("user enters the authentication token")
	public void user_enters_the_authentication_token() {
		
		
		AuthToken=FetchDataFromProperty.readDataFromProperty().getProperty("Token");
	    
	}

	@When("user passed the payload in gorest site with all required details")
	public void user_passed_the_payload_in_gorest_site_with_all_required_details() throws IOException {
	   
		System.out.println(AuthToken);
		res= given().log().all().relaxedHTTPSValidation().headers("Authorization",AuthToken)
				.spec(req)
				.body(TestDataExcel.getDataFromExcel());
		
		
	}

	@When("user will hit the gorest {string}")
	public void user_will_hit_the_gorest(String endpoint) {
		
respec=new ResponseSpecBuilder().build();
		
		response=	res.when().post(endpoint).then().log().all().spec(respec).extract().response();
		
	    
	}

	@Then("user will validate the details in status body")
	public void user_will_validate_the_details_in_status_body() {
		
		System.out.println("validate status body");
		JsonPath js=new JsonPath(response.asString());
	String name=	js.getString("name");
	Assert.assertEquals("Saurabh", name);
	System.out.println("Test case Completed");
		
		
		
		
	    
	}



	
	

	@Then("user validates the status code as {string}")
	public void user_validates_the_status_code_as(String status_code) {
		
	long time=	response.getTime();
	
	if(time>5000)
	{
		throw new ArithmeticException() ;
	}
	else
	{
		System.out.println("The performance is within threshold");
	}
		
	String s=status_code;
int expectedStatusCode=	Integer.parseInt(s);
int actualStatusCode=response.getStatusCode();
Assert.assertEquals(actualStatusCode, expectedStatusCode);

//JsonPath js=new JsonPath(response.asString());
//String Uname=js.getString("username");
//Assert.assertEquals("Harry",Uname);
//System.out.println("Scenario passed");

		
	    
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
