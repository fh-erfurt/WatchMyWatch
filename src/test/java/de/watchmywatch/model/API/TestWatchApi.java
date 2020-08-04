package de.watchmywatch.model.API;

import org.junit.Test;

import static  io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

public class TestWatchApi {

    @Test
    public void whenRequestGet_thenOK(){
        given().port(8086).when().request("GET", "/users").then().statusCode(200);
    }
}
