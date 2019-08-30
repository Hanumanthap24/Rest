package com.stepdefinitions;

import com.BaseUtils.BaseUtil;
import static org.hamcrest.Matchers.*;
import static org.junit.Assert.assertArrayEquals;
import static org.hamcrest.Matchers.*;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ResponseOptions;

import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.when;
import static org.hamcrest.MatcherAssert.assertThat;
import java.util.HashMap;
import java.util.Map;

import org.json.JSONObject;
import org.testng.Assert;

public class StepDef extends BaseUtil {
	
	public static Map<String, String> body=null;



@Given("^Fetch User data$")
public void when_I_perform_get_on() throws Throwable {
	Map<String,String> map=new HashMap<String, String>();
	map.put("title", "foo");
	map.put("body", "bar");
	map.put("userId", "1");
	body=map;
	
	
	setupRequest(body,"https://jsonplaceholder.typicode.com/posts");

	
}


@Given("^ I do post,verify for the values$")
public void when_I_perform_post_on() throws Throwable {
	HashMap<String,String> map=new HashMap<String, String>();
	map.put("title", "foo");
	map.put("body", "bar");
	map.put("userId", "1");
	body=map;
	setupRequest(body,"https://jsonplaceholder.typicode.com");

	
}

@Then("^my response should contain$")
public void my_response_should_cntain() throws Throwable {
	//postOps(uri);	
	postWithBodyParams(body);
	System.out.println(response.asString());
	//
	assertThat(response.jsonPath().get(),hasItem("id"));

}

@Given("^Fetch User data for my Module$")
public void Fetch_User_data_for_my_Module() {
	
	HashMap<String,String> map=new HashMap<String, String>();
	map.put("title", "foo");
	map.put("body", "bar");
	map.put("userId", "1");
	body=null;
	setupRequest(body,"");	
	
}

@When("^I do post,verify for the values$")
public void I_do_post_verify_for_the_values() {
	
	
}

@Given("^User data required to fetch 5 days$")
public void User_data_required_to_fetch_5_days() {
	
	HashMap<String,String> map=new HashMap<String, String>();
	body=null;
	Map<String, String> params=new HashMap<String, String>();

	params.put("APPID", "87c1c03a14ab5024bc9529d71eb13ea0");
	params.put("q", "London");
	params.put("mode", "json");	
	setupRequest(body,params,"http://api.openweathermap.org/data/2.5/forecast");	
	
}



@When("^I do get opertaion verify the data$")
public void I_do_get_opertaion_verify_the_data() {	
 getOps("http://api.openweathermap.org/data/2.5/forecast");
 System.out.println(response.getBody().asString());


}





}
