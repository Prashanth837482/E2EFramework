

package restAssured;

import java.util.List;
import java.util.Map;

import org.json.JSONArray;
import org.json.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import io.restassured.RestAssured;
import io.restassured.http.Header;
import io.restassured.http.Headers;
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
	
	//@Test(priority=5)
	public void requestWithAllParts() {
		
		// This Given When Then can be used for all authentications which simplifies the steps but can go with normal flow for better understanding
		
		RestAssured.baseURI="https://postman-echo.com/basic-auth";
		Header h1 = new Header("content-Type", "application/json");	
		Header h2 = new Header("content-Type", "application/json");
		Headers headers = new Headers(h1,h2);
		RequestSpecification spec = RestAssured.given();
		spec.headers(headers);
		spec.body("test").auth().basic("test", "test");
		spec.queryParam("user", 1);
		Response rs = spec.get();
		rs.statusCode();
		
		
	}
	
	@Test(priority = 5)
	public void ParseJsonResponseAndValidate() throws JsonMappingException, JsonProcessingException {
	    
	        String json = "{\n" +
	                "    \"Id\": 123,\n" +
	                "    \"CustomFields\": [\n" +
	                "        {\n" +
	                "            \"Name\": \"apple\",\n" +
	                "            \"Color\": \"Red\"\n" +
	                "        },\n" +
	                "        {\n" +
	                "            \"Name\": \"banana\",\n" +
	                "            \"Color\": \"Yellow\"\n" +
	                "        }\n" +
	                "    ]\n" +
	                "}";

	        // Parsing json reponse using jsonArray and objects (org.json dependency or package)
	        
	        JSONObject obj = new JSONObject(json);
	        JSONArray fields = obj.getJSONArray("CustomFields");

	        for (int i = 0; i < fields.length(); i++) {
	            JSONObject field = fields.getJSONObject(i);
	            if ("apple".equalsIgnoreCase(field.getString("Name"))) {
	                System.out.println("Color of apple: " + field.getString("Color"));
	            }
	        }
	        
	        
	        // Parsing json reponse using objectmapper 
	        
	        ObjectMapper mapper = new ObjectMapper();
	        // Parse JSON into a Map
	        Map<String, Object> root = mapper.readValue(json, new TypeReference<Map<String, Object>>() {});

	        // Get the CustomFields list
	        List<Map<String, Object>> customFields = (List<Map<String, Object>>) root.get("CustomFields");
	        
	        // Loop through and find "apple"
	        for (Map<String, Object> field : customFields) {
	            if ("apple".equalsIgnoreCase((String) field.get("Name"))) {
	                System.out.println("Color of apple: " + field.get("Color"));
	            }
	        }
	        
	        // Using dot groovy notation available in jsonPath to find an element
	        JsonPath path = new JsonPath(json);
	        String color = path.get("CustomFields.find {it.Name == 'apple' }.Color");
	        System.out.println(color);
	    
	}
	

	
	
}
