package de.watchmywatch.managerClasses;

import de.watchmywatch.classes.Bracelet;
import de.watchmywatch.classes.ConnectionType;
import de.watchmywatch.classes.Material;
import de.watchmywatch.classes.PartType;

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
