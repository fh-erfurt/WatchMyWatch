package de.watchmywatch.Uhrenverwaltung;

import de.watchmywatch.Accounterwaltung.Person;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestManagerWatchpart
{
    //TODO fix tests
    /*@Test
    public void should_create_three_watchparts_add_them_into_the_map()
    {
        //Given
        ManagerWatchpart manager = new ManagerWatchpart();
        //When
        Bracelet watchpart1 = new Bracelet(1, "1", Material.ALUMINIUM, 1, new BigDecimal(2.5), 1.0, ConnectionType.BAND);
        Casing watchpart2 = new Casing(1, "1", Material.ALUMINIUM, 1, new BigDecimal(2), 2, 2, ConnectionType.BAND);
        Clockwork watchpart3 = new Clockwork(1, "1", Material.ALUMINIUM, 1, new BigDecimal(2), 2);

        manager.addWatchpart(watchpart1);
        manager.addWatchpart(watchpart2);
        manager.addWatchpart(watchpart3);
        //Then
        assertEquals(3, manager.amountOfWatchparts());
        manager.reset();
    }

    @Test
    public void should_create_three_watchparts_add_them_into_the_map_and_remove_them_again()
    {
        //Given
        ManagerWatchpart manager = new ManagerWatchpart();
        //When
        Bracelet watchpart1 = new Bracelet(1, "1", Material.ALUMINIUM, 1, new BigDecimal(2.5), 1.0, ConnectionType.BAND);
        Casing watchpart2 = new Casing(1, "1", Material.ALUMINIUM, 1, new BigDecimal(2), 2, 2, ConnectionType.BAND);
        Clockwork watchpart3 = new Clockwork(1, "1", Material.ALUMINIUM, 1, new BigDecimal(2), 2);

        manager.addWatchpart(watchpart1);
        manager.addWatchpart(watchpart2);
        manager.addWatchpart(watchpart3);

        manager.removeWatchpartByID(1);
        manager.removeWatchpartByID(2);
        manager.removeWatchpartByID(3);
        //Then
        assertEquals(0, manager.amountOfWatchparts());
        manager.reset();
    }

    @Test
    public void should_create_one_bracelet_add_them_into_the_map_and_retrieve_it()
    {
        //Given
        ManagerWatchpart manager = new ManagerWatchpart();
        //When
        Bracelet watchpart1 = new Bracelet(1, "1", Material.ALUMINIUM, 1, new BigDecimal(2.5), 1.0, ConnectionType.BAND);
        manager.addWatchpart(watchpart1);

        Watchpart parent = manager.getWatchpartByID(1);
        if (parent instanceof Bracelet)
        {
            Bracelet imSureItsChildNow = (Bracelet) parent;
            //Then
            assertEquals(watchpart1.getPrice(), imSureItsChildNow.getPrice());
        } else
        {
            assertEquals(1, 2);
        }
        manager.reset();
    }*/
}
