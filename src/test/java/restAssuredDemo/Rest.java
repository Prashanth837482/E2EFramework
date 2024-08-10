package restAssuredDemo;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class Rest {

	@Test()
	public void restCheck() {
		RestAssured.baseURI="https://reqres.in/";
		RequestSpecification req= RestAssured.given().header("content-type","application/json");
		
		Response res=req.get("api/users/2");
		System.out.println(res.asString());
		System.out.println(res.getStatusCode()+" "+res.getStatusLine());
		System.out.println(res.getBody().asString());
		System.out.println(res.getContentType());
		JsonPath path=res.jsonPath();
		System.out.println(path.getString("data"));
		System.out.println(path.getString("support"));
	}
}
