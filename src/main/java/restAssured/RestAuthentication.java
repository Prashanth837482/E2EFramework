
package restAssured;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class RestAuthentication {

	//Authentication: it is to validate identity of user whether the user is valid or not  (first check)
	//Authorization: Validates whether the authenticated user has access to get or modify the resource data (second check)

	@Test()
	public void restBasicAuthentication() {
		
		RestAssured.baseURI="https://postman-echo.com/basic-auth";
		RequestSpecification req= RestAssured.given().header("content-type","application/json");		
		// basic auth, preemitive, digest takes username and passwrod to authenticate to server just algorithm while connecting to server differs
		req.auth().basic("postman", "password");
		
		Response response = req.get();
		
		//401 un-authorized if user is not authorized to access resource
		Assert.assertEquals(200, response.getStatusCode(),"Un-Authorized");
		System.out.println(response.body().asPrettyString());
		
		System.out.println(response.getContentType());		
		Assert.assertEquals("true", response.jsonPath().getString("authenticated"),"not authenticated");
		
		
	}
	
	@Test(priority=2)
	public void bearerTokenAuth() {
		
		// generate the bearer token @ https://github.com/settings/tokens use classic
		String bearerToken="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";
		
		//using github API URI
		RestAssured.baseURI="https://api.github.com/user/repos";
		RequestSpecification req= RestAssured.given().header("content-type","application/json");
		
		//when we test manually in postman we pass the bearer token in the authorization tab by selecting bearer token
		// when we switch to headers we can see this gets added to header of the request
		// with key as : Authorization and value as : Bearer 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. so we should pass the same key value data to header for authentication
		req.headers("Authorization", "Bearer "+bearerToken);
		
		Response response = req.get();
		
		
		Assert.assertEquals(200, response.getStatusCode(),"Request failed");
		System.out.println(response.asPrettyString());
		
		// this will retrieve the list of repository names from the response that we have in github
		System.out.println(response.jsonPath().getList("name"));
		System.out.println(response.jsonPath().getString("owner.login"));
		// to retrieve name from the first element of json array. json array will be enclosed in "[" square braces.
		System.out.println(response.jsonPath().getString("owner[0].login"));
	}
	
	
	@Test(priority=3)
	public void OAuth2() {
		
		// generate the bearer token @ https://github.com/settings/tokens use classic
		String bearerToken="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";
		
		//using github API URI
		RestAssured.baseURI="https://api.github.com/user/repos";
		RequestSpecification req= RestAssured.given().header("content-type","application/json");
		
		//below is the format for the OAuth1 which needs below details for authentication which all Clients doesn't have (support)
		//req.auth().oauth(consumerky, consumersecret, accesstoken, tokensecret);
		
		//OAuth2 is the update version of OAuth1 where it requires only bearerToken which is used widely
		req.auth().oauth2(bearerToken);
		
		Response response = req.get();
		
		
		Assert.assertEquals(200, response.getStatusCode(),"Request failed");
		System.out.println(response.asPrettyString());
		
		// this will retrieve the list of repository names from the response that we have in github
		System.out.println(response.jsonPath().getList("name"));
		System.out.println(response.jsonPath().getString("owner.login"));
		// to retrieve name from the first element of json array
		System.out.println(response.jsonPath().getString("owner[0].login"));
		// to get the headers data pass the header name that avble in postman after the success response in headers tab below
		System.out.println(response.getHeader("Content-Encoding"));
	}
	
	
	@Test(priority=4)
	public void restBasicAuthenticationWithGivenWhen() {
		
		// This Given When Then can be used for all authentications which simplifies the steps but can go with normal flow for better understanding
		
		RestAssured.baseURI="https://postman-echo.com/basic-auth";
		
		// we can have all in one line
		//RestAssured.given().auth().basic("postman", "password").when().get().then().statusCode(200).log().all();
		
		
		//just separating for our understanding
		// specify the auth Type and provide credentials
		RestAssured.given().auth().basic("postman", "password")
		// this is to specify method 
			.when().get()
			// to validate status code and log all to get the entire response with headers as well
			.then().statusCode(200).log().all();
		
		
		
		
	}
	
	
}
