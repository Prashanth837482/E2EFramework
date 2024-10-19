package javaCoding;

import java.util.List;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class InformaticaRest {
	
	@Test()
	public void getMethod() {
		RestAssured.baseURI = "https://reqres.in/";
		
		//RequestSpecification request =RestAssured.given().auth().basic("username", "password");
		
		Response res = RestAssured.get("/api/users?page=2");
		
		Assert.assertEquals(200, res.getStatusCode(),"failed to get data");
		
		JsonPath path = res.jsonPath();
		System.out.println(res.asPrettyString());
		List<String> frstname=path.getList("data.first_name");
		//List<String> frstname=path.getList("first_name");
		System.out.println(frstname);
		for(String name : frstname) {
			System.out.println(name);
		}
		
		
	}
}
