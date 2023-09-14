package com.in28minutes.rest.webservices.restfulwebservices.restassured;

import static io.restassured.RestAssured.*;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.testng.TestNG;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;
import org.testng.Assert;
import static org.hamcrest.Matchers.*;

import static io.restassured.RestAssured.given;

public class RestAssuredApiTests {

    @BeforeSuite
    public void setUp() {
        baseURI = "http://localhost:5001";
    }

    @Test
    public void testCreateUser() {
        String requestBody = "{\"username\":\"newUser\", \"password\":\"newUserPassword\"}";

        given()
                .contentType("application/json")
                .body(requestBody)
                .when()
                .post("/createuser/")
                .then()
                .statusCode(200)
                .body(equalTo("User created successfully"));
    }
}
