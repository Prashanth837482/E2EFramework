package restAssured;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;


public class PojoRestAssured {
	
	private int id;
	private String name;
	
	public PojoRestAssured() { }
	
	public PojoRestAssured(int id, String name) {
		this.id = id;
		this.name = name;		
	}
	
	public void setId(int id) {
		this.id = id;		
	}
	
	public void setName(String name) {
		this.name = name;		
	}
	
	public int getId() {
		return id;
	}
	
	public String getName() {
		return name;
	}
	
	
	public static void main(String args[]) {
		PojoRestAssured obj = new PojoRestAssured(1, "prash");
		
		RestAssured.baseURI = "https://www.httpbin.org/anything";
		
		RequestSpecification request = RestAssured.given().header("Content-Type","application/json");
		request.header("Authorization","Basic test");
		request.body(obj);
		
		Response rs = request.post("/users");
		System.out.println(rs.asPrettyString());
		
		//https://chatgpt.com/c/69024863-cf20-8324-8309-561c7cfe380b  -> reference for line usage and need of Parameterless constructor
		
	//	PojoRestAssured obj2 = rs.as(PojoRestAssured.class);
		PojoRestAssured obj2 = rs.jsonPath().getObject("json", PojoRestAssured.class);
		System.out.println(obj2.getId());
	}

}
