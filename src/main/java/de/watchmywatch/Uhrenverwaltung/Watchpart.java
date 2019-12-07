package de.watchmywatch.Uhrenverwaltung;

import de.watchmywatch.Uhrenverwaltung.Material;
import de.watchmywatch.Uhrenverwaltung.PartType;

import java.math.BigDecimal;

public abstract class Watchpart
{

    private int id;
    private int manufacturerID;
    //contains the ID which was given by the original manufacturer so we could order it directly when we are out of stock
    private String manufacturerPartID;
    //contains the main material of which the part consists
    private Material material;
    //contains the stock we currently have
    private int amountAvailable;
    private PartType partType;
    //contains price which the part alone costs
    private BigDecimal price;
    protected static int idCounter = 0;

    protected Watchpart(int manufacturerID, String manufacturerPartID,
                        Material material, int amountAvailable, PartType partType,
                        BigDecimal price)
    {
        this.id = idCounter;
        ++idCounter;

        this.manufacturerID = manufacturerID;
        this.manufacturerPartID = manufacturerPartID;
        this.material = material;
        this.amountAvailable = amountAvailable;
        this.partType = partType;
        this.price = price;
    }

    public int getID()
    {
        return id;
    }

    public void setID(int id)
    {
        this.id = id;
    }

    public int getManufacturerID()
    {
        return manufacturerID;
    }

    public void setManufacturerID(int manufacturerID)
    {
        this.manufacturerID = manufacturerID;
    }

    public String getManufacturerPartId()
    {
        return manufacturerPartID;
    }

    public void setManufacturerPartId(String manufacturerPartId)
    {
        this.manufacturerPartID = manufacturerPartId;
    }

    public Material getMaterial()
    {
        return material;
    }

    public void setMaterial(Material material)
    {
        this.material = material;
    }

    public int getAmountAvailable()
    {
        return amountAvailable;
    }

    public void setAmountAvailable(int amountAvailable)
    {
        this.amountAvailable = amountAvailable;
    }

    public PartType getPartType()
    {
        return partType;
    }

    public void setPartType(PartType partType)
    {
        this.partType = partType;
    }

    public BigDecimal getPrice()
    {
        return price;
    }

    public void setPrice(BigDecimal price)
    {
        this.price = price;
    }
}
