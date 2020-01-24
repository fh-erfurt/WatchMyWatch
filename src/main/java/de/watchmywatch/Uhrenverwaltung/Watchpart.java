package de.watchmywatch.Uhrenverwaltung;

import de.watchmywatch.Uhrenverwaltung.Validator.Validatable;

public abstract class Watchpart implements Validatable
{
    private Manufacturer manufacturer;
    //contains the ID which was given by the original manufacturer so we could order it directly when we are out of stock
    private String manufacturerPartID;
    //contains the main material of which the part consists
    private Material material;
    //contains the stock we currently have
    private int amountAvailable;
    private PartType partType;
    //contains price which the part alone costs
    private double price;

    protected Watchpart(Manufacturer manufacturer, String manufacturerPartID,
                        Material material, int amountAvailable, PartType partType,
                        double price)
    {
        this.manufacturer = manufacturer;
        this.manufacturerPartID = manufacturerPartID;
        this.material = material;
        this.amountAvailable = amountAvailable;
        this.partType = partType;
        this.price = price;
    }

    public Manufacturer getManufacturer()
    {
        return manufacturer;
    }

    public void setManufacturer(Manufacturer manufacturer)
    {
        this.manufacturer = manufacturer;
    }

    public String getManufacturerPartID()
    {
        return manufacturerPartID;
    }

    public void setManufacturerPartID(String manufacturerPartId)
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

    public double getPrice()
    {
        return price;
    }

    public void setPrice(double price)
    {
        this.price = price;
    }
}
