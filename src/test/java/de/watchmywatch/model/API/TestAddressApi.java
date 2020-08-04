package de.watchmywatch.model.API;

import de.watchmywatch.model.Helper.Address;
import org.junit.Test;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

public class TestAddressApi {

    @Test
    public void whenRequestGet_thenOK() {
        given().port(8086)
                .when().request("GET", "/api/addresses")
                .then().statusCode(200);
    }

    @Test
    public void whenRequestGetWithId_thenOK() {
        given().port(8086).when().request("GET", "/api/addresses/1")
                .then().statusCode(200);
    }

    @Test
    public void whenPost_thenCreatedAndCorrect() {
        Address address = new Address("streetName", "cityName", "stateName", "zipName");
        given().port(8086).contentType("application/json").body(address)
                .when().post("/api/addresses")
                .then()
                .statusCode(201)
                .body("street", equalTo(address.getStreet()))
                .body("city", equalTo(address.getCity()))
                .body("state", equalTo(address.getState()))
                .body("zip", equalTo(address.getZip()));
    }

    @Test
    public void whenPut_thenCorrect() {
        Address address = new Address("streetName", "cityName", "stateName", "zipName");
        given().port(8086)
                .contentType("application/json")
                .body(address)
                .when()
                .put("/api/addresses/1")
                .then()
                .statusCode(200)
                .body("street", equalTo(address.getStreet()))
                .body("city", equalTo(address.getCity()))
                .body("state", equalTo(address.getState()))
                .body("zip", equalTo(address.getZip()));
    }

    @Test
    public void whenDelete_thenCorrect() {
        given().port(8086).contentType("application/json")
                .when().delete("/api/addresses/10")
                .then().statusCode(204);
    }
}
