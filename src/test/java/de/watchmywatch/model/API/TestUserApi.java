package de.watchmywatch.model.API;

import de.watchmywatch.model.AccountManagment.User;
import de.watchmywatch.model.Helper.Address;
import de.watchmywatch.model.OrderManagment.Shoppingcart;
import org.junit.Test;

import java.time.LocalDate;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

public class TestUserApi {
    @Test
    public void whenRequestGet_thenOK() {
        given().port(8086)
                .when().request("GET", "/api/users")
                .then().statusCode(200);
    }

    @Test
    public void whenRequestGetWithId_thenOK() {
        given().port(8086).when().request("GET", "/api/users/1")
                .then().statusCode(200);
    }

    @Test
    public void whenPost_thenCreatedAndCorrect() {
        Address address = new Address("streetName", "cityName", "stateName", "zipName");
        User user = new User("Tom", "lastname", "email2@mail.com", "password",
                "12301230123", address, LocalDate.of(1998, 9, 23), address, new Shoppingcart());
        given().port(8086).contentType("application/json").body(user)
                .when().post("/api/users")
                .then()
                .statusCode(201)
                .body("firstname", equalTo(user.getFirstname()))
                .body("lastname", equalTo(user.getLastname()))
                .body("email", equalTo(user.getEmail()))
                .body("phone", equalTo(user.getPhone()));
    }

    @Test
    public void whenPut_thenCorrect() {
        Address address = new Address("streetName", "cityName", "stateName", "zipName");
        User user = new User("updatedFirstName", "updatedLastname", "updated@mail.com", "password",
                "12738126738", address, LocalDate.of(1998, 9, 23), address, new Shoppingcart());
        given().port(8086)
                .contentType("application/json")
                .body(user)
                .when()
                .put("/api/users/1")
                .then()
                .statusCode(200)
                .body("firstname", equalTo(user.getFirstname()))
                .body("lastname", equalTo(user.getLastname()))
                .body("email", equalTo(user.getEmail()))
                .body("phone", equalTo(user.getPhone()));
    }

    @Test
    public void whenDelete_thenCorrect() {
        given().port(8086).contentType("application/json")
                .when().delete("/api/users/36")
                .then().statusCode(204);
    }
}
