package Rest.Rest;

import org.json.JSONObject;

import groovyjarjarasm.asm.commons.Method;
import io.restassured.RestAssured;
import static io.restassured.RestAssured.given;

import io.restassured.http.ContentType;
import io.restassured.http.Header;
import io.restassured.http.Headers;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import static org.hamcrest.Matchers.equalTo;
 

/**
 * Hello world!
 *
 */
public class App 
{
	
	
    public static void main( String[] args )
    {
     RestAssured.baseURI="http://api.openweathermap.org/data/2.5";  
     
     Response response=given(). 
      param("APPID", "87c1c03a14ab5024bc9529d71eb13ea0").
      param("q", "Bangalore").
      when().
      get("/weather").     // then().extract().response();
		
		  then().assertThat().statusCode(200).and().assertThat().contentType(
		  ContentType.JSON).extract().response();
		 
    	
    	JsonPath json=new JsonPath(response.asString());
	    System.out.println(json.get("clouds.all")+" weather from jason"); 
	    System.out.println(json.get("timezone")+" weather from jason"); 
	    System.out.println(json.get("sys.id")+" weather from jason"); 
	    System.out.println(json.get("name")+" weather from jason"); 
	  
    
		/*
		 * Res ponse response=(Response) given().when().post("").then().extract(); String
		 * resString=response.asString(); JsonPath jsonPath=new JsonPath(resString);
		 * jsonPath.get("id");
		 */
      
      
    
    	
    	}
      
}
