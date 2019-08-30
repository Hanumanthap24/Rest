package Rest.Rest;

import org.json.JSONObject;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;

import static io.restassured.RestAssured.given;

public class Delete {
	
	
public static void main(String[] args) {

		RestAssured.baseURI="http://restapi.demoqa.com/customer";
		JSONObject requestparam=new JSONObject();
		requestparam.put("FirstName", "Hanumanthaa");
		requestparam.put("LastName" , "Hanumanthaa");
		requestparam.put("UserName" , "Hanumanthaa");
		requestparam.put("Password" , "Hanumanthaa");
		requestparam.put("Email","hanumni@gmaial.com");
		Response resoResponse=given().
		header("Content-Type","application/Json").
		body(requestparam.toString()).	
		when().post("/register")
		.then().extract().response();
		System.out.println(resoResponse.jsonPath().toString());
		///First time 201 ,subsequent time 200
	}

}
