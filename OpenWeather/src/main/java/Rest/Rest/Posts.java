package Rest.Rest;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import static org.hamcrest.Matchers.*;


import static io.restassured.RestAssured.given;

import java.util.List;
import java.util.Map;

import org.hamcrest.collection.HasItemInArray;
import org.json.JSONObject;
import org.springframework.util.Assert;


public class Posts {
	
	public static void main(String[] args) {
		RestAssured.baseURI="https://jsonplaceholder.typicode.com/posts";
		JSONObject body=new JSONObject();
		body.put("title", "fooo");
		body.put("body", "bar");
		body.put("userId", "1");	
		Response response=given().
		/*when().get("https://jsonplaceholder.typicode.com/posts").then().extract().response();
        JsonPath jsonPath = new JsonPath(response.asString());
        System.out.println(response.asString());
		
		List<String> titles= new JsonPath(response.asString()).get("title");
		titles.forEach(t->System.out.println(t));*/
		header("Content-type", "application/json; charset=UTF-8").body(body).
		when().post("https://jsonplaceholder.typicode.com/posts").then().assertThat().statusCode(201).and().extract().response();
		System.out.println(response.asString());
		
		
		JsonPath responseJson=new JsonPath(response.asString());
        final List<Map<String, String>> object = JsonPath.from(response.asString()).get("");
		
	System.out.println(responseJson.getInt("id"));	;
		

	}

}
