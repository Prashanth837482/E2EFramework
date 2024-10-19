package restAssuredDemo;

import org.json.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.google.gson.JsonObject;

import io.restassured.RestAssured;
import io.restassured.internal.path.json.mapping.JsonObjectDeserializer;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class Rest {

	@Test(priority = 0)
	public void restCheck() {
		RestAssured.baseURI="https://reqres.in/";
		RequestSpecification req= RestAssured.given().header("content-type","application/json");
		
		Response res=req.get("api/users/2");
		System.out.println(res.asString());
		
		Assert.assertEquals(200, res.getStatusCode(),"Incorrect Status");
		
		System.out.println(res.getStatusCode()+" "+res.getStatusLine());
		System.out.println(res.getBody().asString());
		System.out.println(res.getContentType());
		JsonPath path=res.jsonPath();
		System.out.println(path.getString("data"));
		System.out.println(path.getString("support"));
		
		// Dot notation to access the json data
		System.out.println(path.getString("data.id"));  // first give parent then "." and child node for accessing that element
	}
	
	@Test(priority = 1)
	public void GetJsonArrayData() {
		RestAssured.baseURI="https://reqres.in/";
		RequestSpecification req= RestAssured.given().header("content-type","application/json");
		
		Response res=req.get("api/users?page=2");
		
		System.out.println(res.asPrettyString()); // to print the data indentation format the way we see a json object.
		
		JsonPath path=res.jsonPath();
		
		
		System.out.println(path.getString("data[0].id") + " "+path.getString("data[0].first_name")); // we should provide the index of array element that we are accessing
	}
	
	
	
	@Test(priority = 2)
	public void PostMethod() {
		
		RestAssured.baseURI="https://reqres.in/";
		
		RequestSpecification request = RestAssured.given().header("content-type","application/json");
		// create a JSONObject to send the PayLoad to server
		JSONObject obj= new JSONObject();
		obj.put("name","morpheus");
		obj.put("job", "ITTech");
		//load the request body with the json object payload.
		request.body(obj.toString());
		
		Response response= request.post("api/users");
		
		System.out.println(response.asPrettyString());
		
		JsonPath path = response.jsonPath();
		//201(resource created) if resource created
		System.out.println("Generated Resource Id :"+path.getString("id"));
		System.out.println("Created At :"+path.getString("createdAt"));
		
		Assert.assertEquals(201, response.getStatusCode(),"Resource Not Created");
		
		
	}
	
	
	@Test(priority = 4)
	public void PutMethod() {
	
		// we should send full representation of the object for updating resource through put method.
		
		RestAssured.baseURI="https://reqres.in/";
		
		RequestSpecification request = RestAssured.given().header("content-type","application/json");
		// create a JSONObject to send the PayLoad to server to update the existing data in server or create new one.
		JSONObject obj= new JSONObject();
		obj.put("first_name","prashanth");
		obj.put("email", "prahsanthvangapelli369@gmail.com");
		obj.put("id", "1177580");
		obj.put("last_name", "vangapelli");
		obj.put("Avatar", "ttps://reqres.in/img/faces/2-image.jpg");
		
		
		JSONObject obj2=new JSONObject();
		obj2.put("url", "prash.com");
		obj2.put("text", "iam updating");
		
		JSONObject mainObj=new JSONObject();
		mainObj.put("data", obj);
		mainObj.put("support", obj2);
		
		//load the request body with the json object payload.
		request.body(mainObj.toString());
		//Give the resource that is already been there in the server.
		Response response= request.post("api/users/2");
		

		System.out.println(response.asPrettyString());
		//201(resource created) if resource created, 200(ok) if resource updated
		System.out.println("status code of the response is: "+response.getStatusCode());
		
		JsonPath path = response.jsonPath();
		
		System.out.println("Updated Resource Id :"+path.getString("data.id"));
		System.out.println("Updated At :"+path.getString("UpdatedAt"));
		
		// when assertion fails it throws assertion error and execution of this test method will stop.
		Assert.assertEquals(201, response.getStatusCode(),"Resource Not Updated or Resource Created");
		
		System.out.println("Created At :"+path.getString("CreatedAt"));
	
	}
	
	
	@Test(priority = 3)
	public void DeleteMethod() {
	
		
		
		RestAssured.baseURI="https://reqres.in/";
		
		//RequestSpecification request = RestAssured.given().header("content-type","application/json");
		
		Response response= RestAssured.delete("api/users/2");
		

		System.out.println(response.asPrettyString());
		//204(resource not found) or 200(ok) if resource deleted
		System.out.println("status code of the response is: "+response.getStatusCode());
		
		
	}
	
	
	
}
