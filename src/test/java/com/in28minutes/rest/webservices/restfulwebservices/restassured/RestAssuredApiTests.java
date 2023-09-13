package com.in28minutes.rest.webservices.restfulwebservices.restassured;

import io.restassured.RestAssured;
import org.junit.Before;
import org.junit.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class RestAssuredApiTests {

    @Before
    public void setUp() {
        RestAssured.baseURI = "http://localhost:5001"; // Replace with your application's actual base URL
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
                .body("message", equalTo("User created successfully"));
    }
}
