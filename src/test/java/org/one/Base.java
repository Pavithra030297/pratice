package org.one;

import io.restassured.RestAssured;
import static io.restassured.RestAssured.*;

import org.base.PayLoad;
import static org.hamcrest.Matchers.*;
public class Base  {
	
	public static void main(String[] args) {
		
		//mention the base uri
		RestAssured.baseURI="https://rahulshettyacademy.com";
		
		String response=given().log().all().queryParam("key","qaclick123").header("content-Type", "application/json").body(PayLoad.addplace()).
		when().post("/maps/api/place/add/json").
		then().log().all().assertThat().statusCode(200).body("scope",equalTo("APP")).header("server",equalTo("Apache/2.4.52(Ubuntu)")).
		extract().response().asString(); 
		
		System.out.println(response);
	}

}
//what is payload
//payload is a input data we will pass as a request in a body 