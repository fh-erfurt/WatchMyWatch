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
    //contains price which the part alone costs
    private double price;

    /**
     * Ist eine Abstrakte Klasse welche Grundlegende Eigenschaften von Uhrenteilen beinhaltet
     * @param manufacturer Objekt eines Herstellers
     * @param manufacturerPartID ID welche von dem Hersteller selbst vergeben wurde
     * @param material Material aus welchen das Teil ist
     * @param amountAvailable Anzahl der Teile im Lager
     * @param price Preis des Teils
     */
    public Watchpart(Manufacturer manufacturer, String manufacturerPartID,
                        Material material, int amountAvailable, double price)
    {
        this.manufacturer = manufacturer;
        this.manufacturerPartID = manufacturerPartID;
        this.material = material;
        this.amountAvailable = amountAvailable;
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

    public double getPrice()
    {
        return price;
    }

    public void setPrice(double price)
    {
        this.price = price;
    }
}
