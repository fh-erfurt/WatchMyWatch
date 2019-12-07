package de.watchmywatch.Uhrenverwaltung;

import de.watchmywatch.Uhrenverwaltung.Material;
import de.watchmywatch.Uhrenverwaltung.PartType;

import java.math.BigDecimal;

public abstract class Watchpart
{
    //TODO remove id as it will be managed by the map in the ManagerClass
    //private int id;
    private int manufacturerID;
    //contains the ID which was given by the original manufacturer so we could order it directly when we are out of stock
    private String manufacturerPartId;
    //contains the main material of which the part consists
    private Material material;
    //contains the stock we currently have
    private int amountAvailable;
    private PartType partType;
    //contains price which the part alone costs
    private BigDecimal price;

    //remove idCounter because same reason as for id
    //protected static int idCounter = 0;

    public int getManufacturerID()
    {
        return manufacturerID;
    }

    public String getManufacturerPartId()
    {
        return manufacturerPartId;
    }

    public Material getMaterial()
    {
        return material;
    }

    public int getAmountAvailable()
    {
        return amountAvailable;
    }

    public PartType getPartType()
    {
        return partType;
    }

    public BigDecimal getPrice()
    {
        return price;
    }

    public void setManufacturerID(int manufacturerID)
    {
        this.manufacturerID = manufacturerID;
    }

    public void setManufacturerPartId(String manufacturerPartId)
    {
        this.manufacturerPartId = manufacturerPartId;
    }

    public void setMaterial(Material material)
    {
        this.material = material;
    }

    public void setAmountAvailable(int amountAvailable)
    {
        this.amountAvailable = amountAvailable;
    }

    public void setPartType(PartType partType)
    {
        this.partType = partType;
    }

    public void setPrice(BigDecimal price)
    {
        this.price = price;
    }
}
