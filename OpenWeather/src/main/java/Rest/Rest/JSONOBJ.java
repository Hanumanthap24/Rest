package Rest.Rest;

import io.restassured.RestAssured;
import io.restassured.response.Response;

import static io.restassured.RestAssured.given;

public class JSONOBJ {
	
	public static void main(String[] args) {
		RestAssured.baseURI="http://api.openweathermap.org/data/2.5";
		Response response=
				given().
		param("id", "524901").param("APPID", "87c1c03a14ab5024bc9529d71eb13ea0").param("cnt","6").
		when().
		get("/forecast/daily").
		then().extract().response();
		System.out.println(response.asString());
		
			    
		
	}

}
