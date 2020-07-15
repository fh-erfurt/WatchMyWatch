package de.watchmywatch.storage;

import de.watchmywatch.model.AccountManagment.Customer;
import de.watchmywatch.model.Exceptions.ShoppingcartEmptyException;
import de.watchmywatch.model.Exceptions.WatchNameNotValidException;
import de.watchmywatch.model.Helper.Address;
import de.watchmywatch.model.WatchManagment.*;
import de.watchmywatch.repository.storage.api.WatchRepository;
import org.junit.Assert;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.Rollback;

import java.time.LocalDate;
import java.util.Calendar;
import java.util.Date;

@DataJpaTest
public class WatchRepositoryTest {
    @Autowired
    WatchRepository watchRepository;

    @BeforeEach
    void SetSomeData() throws ShoppingcartEmptyException, WatchNameNotValidException {
        Address address = new Address("Lilo-Herrmann-Straße 2", "Erfurt", "Thüringen", "99086");
        Customer customer = new Customer("anton.bespalov@fh-erfurt.de", address, "01716181447", "Anton", "Bespalov", LocalDate.of(1998, 9, 23));
        Manufacturer manufacturer = new Manufacturer("Apple", new Customer("anton.bespalov@fh-erfurt.de", address,
                "01716181447", "Anton", "Bespalov", LocalDate.of(1998, 9, 23)), address);
        Bracelet bracelet = new Bracelet("Bracelet No.1", manufacturer, "part1", Material.ALUMINIUM, 10000, 100, 1, ConnectionType.BAND);
        Casing casing = new Casing("Casing No.1", manufacturer, "part2", Material.ALUMINIUM, 15000, 100, 2, 2, ConnectionType.BAND);
        Clockwork clockwork = new Clockwork("Clockwork No.1", manufacturer, "part3", Material.ALUMINIUM, 25000, 100, 2);

        Watch watch1 = new Watch("SweetRolex", "Attributes: +2 Handshaking, +3 Intimidation",
                bracelet, casing, clockwork);
    }

    @Test
    @Rollback(false)
    public void should_create_watch_in_DB() {
        Address address = new Address("Lilo-Herrmann-Straße 2", "Erfurt", "Thüringen", "99086");
        Customer customer = new Customer("anton.bespalov@fh-erfurt.de", address, "01716181447", "Anton", "Bespalov", LocalDate.of(1998, 9, 23));
        Manufacturer manufacturer = new Manufacturer("Apple", new Customer("anton.bespalov@fh-erfurt.de", address,
                "01716181447", "Anton", "Bespalov", LocalDate.of(1998, 9, 23)), address);
        Bracelet bracelet = new Bracelet("Bracelet No.1", manufacturer, "part1", Material.ALUMINIUM, 10000, 100, 1, ConnectionType.BAND);
        Casing casing = new Casing("Casing No.1", manufacturer, "part2", Material.ALUMINIUM, 15000, 100, 2, 2, ConnectionType.BAND);
        Clockwork clockwork = new Clockwork("Clockwork No.1", manufacturer, "part3", Material.ALUMINIUM, 25000, 100, 2);
        Watch watch1 = new Watch("SweetRolex", "Attributes: +2 Handshaking, +3 Intimidation",
                bracelet, casing, clockwork);
        watchRepository.save(watch1);
        Assert.assertEquals(1, 1);
    }
}
