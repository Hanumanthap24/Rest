package Rest.Rest;
import static io.restassured.RestAssured.given;

import io.restassured.RestAssured;

public class Authentication {

	
	public static void main(String[] args) {
		RestAssured.baseURI = "http://restapi.demoqa.com/authentication/CheckForAuthentication";
		int code=given().auth().basic("ToolsQA", "TestPassword").when().get("http://restapi.demoqa.com/authentication/CheckForAuthentication").getStatusCode();
		System.out.println(code);
	}
}
