package com.in28minutes.rest.webservices.restfulwebservices.restassured;

import com.in28minutes.rest.webservices.restfulwebservices.todo.TodoDTO;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import java.util.List;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

public class RestAssuredApiTests {
    String token = "";
    String username = "woofwoof";
    String password = "woofwoof";
    int createdTodoId = 0;

    @BeforeSuite
    public void setUp() {
        baseURI = "http://localhost:5001";

        String requestBody = "{"
                + "\"username\" : \"" + username + "\","
                + "\"password\" : \"" + password + "\""
                + "}";

        Response response = given()
                .contentType("application/json")
                .body(requestBody)
                .when()
                .post("/authenticate");
        token = response.jsonPath().getString("token");
    }

    @Test
    public void testCreateUser() {
        String requestBody = "{\"username\":\"newTestUser\", \"password\":\"newTestUserPassword\"}";

        given()
                .contentType("application/json")
                .body(requestBody)
                .when()
                .post("/createuser/")
                .then()
                .statusCode(200)
                .body(equalTo("User created successfully"));
    }

    @Test
    public void testGetUser() {
        given()
                .contentType("application/json")
                .header("Authorization", "Bearer " + token)
                .when()
                .get("/user/" + username)
                .then()
                .statusCode(200);
    }

    @Test
    public void testRetrieveTodos() {
        Response response = given()
                .contentType("application/json")
                .header("Authorization", "Bearer " + token)
                //.body(requestBody)
                .when()
                .get("/users/" + username + "/todos");
        response
                .then()
                .statusCode(200);
        JsonPath jsonPath = response.jsonPath();
        List<TodoDTO> todoDTOList = jsonPath.getList("$", TodoDTO.class);
        assertThat(todoDTOList, not(empty()));
    }

    @Test
    public void testRetrieveTodo() {
        Response response = given()
                .contentType("application/json")
                .header("Authorization", "Bearer " + token)
                //.body(requestBody)
                .when()
                .get("/users/" + username + "/todos/352");
        response
                .then()
                .statusCode(200);
        JsonPath jsonPath = response.jsonPath();
        TodoDTO todoDTO = jsonPath.getObject("$", TodoDTO.class);
        assertThat(todoDTO.getDescription(), allOf(notNullValue(), not(emptyString())));
        assertThat(todoDTO.getTargetDate(), notNullValue());
    }

    @Test
    public void testCreateTodo() {
        String requestBody = "{"
                + "\"id\": null,"
                + "\"description\": \"Sample Todo\","
                + "\"targetDate\": \"2023-09-15\","
                + "\"done\": false"
                + "}";
        Response response = given()
                .contentType("application/json")
                .header("Authorization", "Bearer " + token)
                .body(requestBody)
                .when()
                .post("users/" + username + "/todos");
        response.then()
                .statusCode(200);

        JsonPath jsonPath = response.jsonPath();
        TodoDTO todoDTO = jsonPath.getObject("$", TodoDTO.class);
        assertThat(todoDTO.getDescription(), equalTo("Sample Todo"));
        assertThat(todoDTO.getTargetDate().toString(), equalTo("2023-09-15"));
        createdTodoId = todoDTO.getId();
    }

    @Test
    public void testUpdateTodo() {
        String requestBody = "{"
                + "\"id\": null,"
                + "\"description\": \"Sample Todo Updated\","
                + "\"targetDate\": \"2040-09-15\","
                + "\"done\": false"
                + "}";
        Response response = given()
                .contentType("application/json")
                .header("Authorization", "Bearer " + token)
                .body(requestBody)
                .when()
                .put("users/" + username + "/todos/" + createdTodoId);
        response.then()
                .statusCode(200);

        JsonPath jsonPath = response.jsonPath();
        TodoDTO todoDTO = jsonPath.getObject("$", TodoDTO.class);
        assertThat(todoDTO.getDescription(), equalTo("Sample Todo Updated"));
        assertThat(todoDTO.getTargetDate().toString(), equalTo("2040-09-15"));
    }

    @Test
    public void testDeleteTodo() {
        given()
                .contentType("application/json")
                .header("Authorization", "Bearer " + token)
                .when()
                .delete("users/" + username + "/todos/" + createdTodoId)
                .then()
                .statusCode(204);
    }
}
