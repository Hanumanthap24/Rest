package com.BaseUtils;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.HashMap;
import java.util.Map;

import org.json.JSONObject;

import gherkin.deps.com.google.gson.JsonObject;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ResponseOptions;
import io.restassured.specification.RequestSpecification;
import static io.restassured.RestAssured.when;
import static io.restassured.RestAssured.given;

public class BaseUtil {
	public static JsonObject body;
	public static String accesskey;
	public static RequestSpecification request;
	public static Response response;
	public static Map<String, String> data;
	public static String uri = "http://api.openweathermap.org/data/2.5/forecast";

	public static void setupRequest(Map<String, String> body,Map<String, String> param,String uri) {
		RequestSpecBuilder requestSpecBuilder = new RequestSpecBuilder();
		requestSpecBuilder.setBaseUri(uri);
		if(!(body==null)) {
 
			requestSpecBuilder.setBody(body);
		}
		if(param!=null) {
		requestSpecBuilder.addQueryParams(param);
		}
		/*
		 * requestSpecBuilder.setBody(body); requestSpecBuilder.setBody("{\r\n" +
		 * "      title: 'foo',\r\n" + "      body: 'bar',\r\n" + "      userId: 1\r\n"
		 * + "    }");
		 */
		requestSpecBuilder.setContentType(ContentType.JSON);
		request = requestSpecBuilder.build();
	}

	public void getOps(String Url) {
		try {
			response= given(request).when().get().then().extract().response();
		} catch (Exception e) {
			// TODO Auto-generated catch block

		}
	}

	public static String getAcccessKey() {
		return "87c1c03a14ab5024bc9529d71eb13ea0";
	}

	public static JSONObject getBodyAsJson(Map<String, String> data) {
		JSONObject jsonObject = new JSONObject();
		// jsonObject.put(data.get("Name"), "Name");
		return jsonObject;
	}

	public static void postOps(String uri)  {
		try {
			response = given(request).when().post(uri).then().extract().response();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static void postWithBodyParams(HashMap<String, String> body) {

		response = given(request).when().post(uri).then().extract().response();
	}

}
