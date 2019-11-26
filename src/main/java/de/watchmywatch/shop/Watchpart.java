package de.watchmywatch.shop;

import de.watchmywatch.shop.ConnectionType;
import de.watchmywatch.shop.PartType;
import de.watchmywatch.shop.Material;

import java.math.BigDecimal;

public abstract class Watchpart
{
    private int id;
    private int manufacturerID;
    private String manufacturerPartId;
    private Material material;
    private int amountAvailable;
    private PartType partType;
    private BigDecimal price;
    private static int idCounter = 0;

    public Watchpart()
    {
        id = idCounter;
        ++idCounter;

    }

    public int getId()
    {
        return id;
    }

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

    public void setId(int id)
    {
        this.id = id;
    }

    public void setManufacturer(int manufacturerID)
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
