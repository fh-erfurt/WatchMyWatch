package de.watchmywatch.shop;

import de.watchmywatch.shop.ConnectionType;
import java.math.BigDecimal;

//TODO create Enums for material and partType

//TODO shouldnt this class be abstract as it always hast to be a casing/clockwork/bracelet -> yes it should be
public class Watchpart
{
    private String id;
    private Manufacturer manufacturer;
    private String manufacturerPartId;
    private Enum material;
    private int amountAvailable;
    private Enum partType;
    private BigDecimal price;

    public String getId()
    {
        return id;
    }

    public Manufacturer getManufacturer()
    {
        return manufacturer;
    }

    public String getManufacturerPartId()
    {
        return manufacturerPartId;
    }

    public Enum getMaterial()
    {
        return material;
    }

    public int getAmountAvailable()
    {
        return amountAvailable;
    }

    public Enum getPartType()
    {
        return partType;
    }

    public BigDecimal getPrice()
    {
        return price;
    }

    public void setId(String id)
    {
        this.id = id;
    }

    public void setManufacturer(Manufacturer manufacturer)
    {
        this.manufacturer = manufacturer;
    }

    public void setManufacturerPartId(String manufacturerPartId)
    {
        this.manufacturerPartId = manufacturerPartId;
    }

    public void setMaterial(Enum material)
    {
        this.material = material;
    }

    public void setAmountAvailable(int amountAvailable)
    {
        this.amountAvailable = amountAvailable;
    }

    public void setPartType(Enum partType)
    {
        this.partType = partType;
    }

    public void setPrice(BigDecimal price)
    {
        this.price = price;
    }
}
