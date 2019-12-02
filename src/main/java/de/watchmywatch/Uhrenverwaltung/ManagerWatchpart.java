package de.watchmywatch.Uhrenverwaltung;

import de.watchmywatch.Uhrenverwaltung.Bracelet;
import de.watchmywatch.Uhrenverwaltung.ConnectionType;
import de.watchmywatch.Uhrenverwaltung.Material;
import de.watchmywatch.Uhrenverwaltung.PartType;

import java.math.BigDecimal;

public class ManagerWatchpart
{
    public static void main(String args[])
    {
        BigDecimal pri = new BigDecimal(4);
        Bracelet bracelet = new Bracelet(1, "Test", Material.ALUMINIUM, 1, PartType.BRACELET, pri, 1, ConnectionType.W31);
        System.out.print(bracelet.getManufacturerPartId());
    }
}
