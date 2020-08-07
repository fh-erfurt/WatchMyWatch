package de.watchmywatch.model.API;

import de.watchmywatch.model.AccountManagment.User;
import de.watchmywatch.model.Helper.Address;

import de.watchmywatch.model.OrderManagment.Shoppingcart;
import de.watchmywatch.repository.storage.WatchDetails;
import org.junit.Test;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

import java.time.LocalDate;

import static io.restassured.RestAssured.*;
public class TestWatchApi {

    @Test
    public void whenRequestGet_thenOK() {
        given().port(8086)
                .when().request("GET", "/api/watches")
                .then().statusCode(200);
    }

    @Test
    public void whenRequestGetWithId_thenOK() {
        given().port(8086).when().request("GET", "/api/watches/1")
                .then().statusCode(200);
    }

    @Test
    public void whenPost_thenCreatedAndCorrect() {
        WatchDetails watch1 = new WatchDetails("WatchName", "Flexing", 1, 1, 1);
        given().port(8086)
                .param("name", watch1.getName())
                .param("particularity", watch1.getParticularity())
                .param("braceletId", watch1.getBraceletId())
                .param("casingId", watch1.getCasingId())
                .param("clockworkId", watch1.getClockworkId())
                .when()
                .post("/api/watches")
                .then()
                .statusCode(201)
                .body("name", equalTo(watch1.getName()))
                .body("bracelet.id", equalTo(watch1.getBraceletId()))
                .body("casing.id", equalTo(watch1.getCasingId()))
                .body("clockwork.id", equalTo(watch1.getClockworkId()));
    }

    @Test
    public void whenPut_thenCorrect() {
        WatchDetails watch1 = new WatchDetails("WatchName", "Flexing", 1, 1, 1);
        given().port(8086)
                .param("name", watch1.getName())
                .param("particularity", watch1.getParticularity())
                .param("braceletId", watch1.getBraceletId())
                .param("casingId", watch1.getCasingId())
                .param("clockworkId", watch1.getClockworkId())
                .when()
                .put("/api/watches/1")
                .then()
                .statusCode(200)
                .body("name", equalTo(watch1.getName()))
                .body("bracelet.id", equalTo(watch1.getBraceletId()))
                .body("casing.id", equalTo(watch1.getCasingId()))
                .body("clockwork.id", equalTo(watch1.getClockworkId()));
    }

    @Test
    public void whenDelete_thenCorrect() {
        given().port(8086).contentType("application/json")
                .when().delete("/api/watches/2")
                .then().statusCode(204);
    }
}
