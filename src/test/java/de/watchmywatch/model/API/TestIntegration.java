package de.watchmywatch.model.API;

import de.watchmywatch.model.AccountManagment.User;
import de.watchmywatch.model.Exceptions.ShoppingcartEmptyException;
import de.watchmywatch.model.Helper.Address;
import de.watchmywatch.model.OrderManagment.Order;
import de.watchmywatch.model.OrderManagment.Shoppingcart;
import de.watchmywatch.model.WatchManagment.*;
import org.junit.Test;
import org.junit.jupiter.api.BeforeEach;

import java.time.LocalDate;

import static io.restassured.RestAssured.*;
import static org.junit.jupiter.api.Assertions.*;

public class TestIntegration {

    // create some reusable objects
    Address address1;
    User user1;
    Manufacturer manufacturer1;
    Bracelet bracelet1;
    Casing casing1;
    Clockwork clockwork1;
    Watch watch1;
    Watch watch2;
    Shoppingcart shoppingcart1;
    Order order1;

    @BeforeEach
    void setUp() {
        address1 = new Address("street 2", "city", "state", "012345");
        user1 = new User("Test", "User", "user@mail.com", "password",
                "01716181447", address1, LocalDate.of(1998, 9, 23),
                address1, shoppingcart1);
        manufacturer1 = new Manufacturer("Apple", "mail@mail.com", "01716181447", address1);
        bracelet1 = new Bracelet("Bracelet No.1", manufacturer1, "part1", Material.ALUMINIUM,
                50, 50, 1, ConnectionType.BAND);
        casing1 = new Casing("Casing No.1", manufacturer1, "part2", Material.ALUMINIUM,
                50, 100, 2, 2, ConnectionType.BAND);
        clockwork1 = new Clockwork("Clockwork No.1", manufacturer1, "part3", Material.ALUMINIUM,
                50, 2, 2);
        watch1 = new Watch("WatchName", "Flexing", bracelet1, casing1, clockwork1);
        watch2 = new Watch("Watch2Name", "Flexing2", bracelet1, casing1, clockwork1);
        shoppingcart1 = createNotEmptyShoppingcart(watch1);
        try {
            order1 = new Order(address1, shoppingcart1);
        } catch (ShoppingcartEmptyException e) {
            e.printStackTrace();
        }
    }

    /**
     * Creates Shoppingcart, which won't throw ShoppingcartEmptyException.
     *
     * @param watch Watch that will be added to returned Shoppingcart
     * @return Shoppingcart object which is not empty
     */

    private Shoppingcart createNotEmptyShoppingcart(Watch watch) {
        Shoppingcart shoppingcart = new Shoppingcart();
        shoppingcart.addWatch(watch);
        return shoppingcart;
    }

    @Test
    public void apiHappyPath() {

        //Create a address, manufacturer, bracelet, casing, clockwork, watch via API
        address1 = new Address("street 2", "city", "state", "012345");
        Address responseAddress = given().port(8086).contentType("application/json")
                .body(address1)
                .when()
                .post("/api/addresses")
                .then()
                .extract()
                .response().getBody().as(Address.class);

        manufacturer1 = new Manufacturer("Apple", "mail@mail.com", "01716181447", responseAddress);
        Manufacturer responseManufacturer = given().port(8086)
                .param("name", manufacturer1.getName())
                .param("contactEmail", manufacturer1.getContactEmail())
                .param("contactPhone", manufacturer1.getContactPhone())
                .param("addressId", manufacturer1.getAddress().getId())
                .when()
                .post("/api/manufacturers")
                .then()
                .extract()
                .response().getBody().as(Manufacturer.class);

        bracelet1 = new Bracelet("Bracelet No.1", responseManufacturer, "part1", Material.ALUMINIUM,
                50, 50, 1, ConnectionType.BAND);
        Bracelet responseBracelet = given().port(8086)
                .param("name", bracelet1.getName())
                .param("manufacturerId", bracelet1.getManufacturer().getId())
                .param("amountAvailable", bracelet1.getAmountAvailable())
                .param("manufacturerPartId", bracelet1.getManufacturerPartID())
                .param("material", bracelet1.getMaterial())
                .param("price", bracelet1.getPrice())
                .param("size", bracelet1.getSize())
                .param("connection", bracelet1.getConnection())
                .when()
                .post("/api/bracelets")
                .then()
                .extract()
                .response().getBody().as(Bracelet.class);

        casing1 = new Casing("Casing No.1", responseManufacturer, "part2", Material.ALUMINIUM,
                50, 100, 4, 3, ConnectionType.BAND);
        Casing responseCasing = given().port(8086)
                .param("name", casing1.getName())
                .param("manufacturerId", casing1.getManufacturer().getId())
                .param("amountAvailable", casing1.getAmountAvailable())
                .param("manufacturerPartId", casing1.getManufacturerPartID())
                .param("material", casing1.getMaterial())
                .param("price", casing1.getPrice())
                .param("innerDiameter", casing1.getInnerDiameter())
                .param("outerDiameter", casing1.getOuterDiameter())
                .param("connection", casing1.getConnection())
                .when()
                .post("/api/casings")
                .then()
                .extract()
                .response().getBody().as(Casing.class);

        clockwork1 = new Clockwork("Clockwork No.1", responseManufacturer, "part3", Material.ALUMINIUM,
                50, 2, 2);
        Clockwork responseClockwork = given().port(8086)
                .param("name", clockwork1.getName())
                .param("manufacturerId", clockwork1.getManufacturer().getId())
                .param("amountAvailable", clockwork1.getAmountAvailable())
                .param("manufacturerPartId", clockwork1.getManufacturerPartID())
                .param("material", clockwork1.getMaterial())
                .param("price", clockwork1.getPrice())
                .param("diameter", clockwork1.getDiameter())
                .when()
                .post("/api/clockworks")
                .then()
                .extract()
                .response().getBody().as(Clockwork.class);

        watch1 = new Watch("WatchName", "Flexing", responseBracelet, responseCasing, responseClockwork);
        Watch responseWatch = given().port(8086)
                .param("name", watch1.getName())
                .param("particularity", watch1.getParticularity())
                .param("braceletId", watch1.getBracelet().getId())
                .param("casingId", watch1.getCasing().getId())
                .param("clockworkId", watch1.getClockwork().getId())
                .when()
                .post("/api/watches")
                .then()
                .extract()
                .response().getBody().as(Watch.class);

        //When
        user1 = new User("Test", "User", "user@mail.com", "password",
                "01716181447", responseAddress, LocalDate.of(1998, 9, 23),
                responseAddress, null);
        // User creates new Account
        User responseUser = given().port(8086).contentType("application/json")
                .body(user1)
                .when()
                .post("/api/users")
                .then()
                .extract()
                .response().getBody().as(User.class);

        // User puts new Watch into his*her shoppingcart
        given().port(8086).contentType("application/json")
                .when()
                .post("/api/shoppingcarts/"+responseUser.getShoppingCart().getId()+"/addWatch/"+responseWatch.getId());

        // Refresh user
        User refreshedResponseUser = given().port(8086).contentType("application/json")
                .when()
                .get("/api/users/"+responseUser.getId())
                .then()
                .extract()
                .response().getBody().as(User.class);

        Order responseOrder = given().port(8086)
                .param("addressId", responseAddress.getId())
                .param("shoppingcartId", responseUser.getShoppingCart().getId())
                .when()
                .post("/api/orders")
                .then()
                .extract()
                .response().getBody().as(Order.class);

        given().port(8086).contentType("application/json")
                .when().delete("/api/users/" + refreshedResponseUser.getId());

        //The Order was created and was not paid for
        assertFalse(responseOrder.wasAlreadyPaid());
    }
}
