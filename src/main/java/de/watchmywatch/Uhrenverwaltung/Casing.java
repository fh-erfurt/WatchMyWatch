package de.watchmywatch.Uhrenverwaltung;

import java.math.BigDecimal;

public class Casing extends Watchpart
{
    private double outerDiameter;
    private double innerDiameter;
    private ConnectionType connection;

    public Casing(int manufacturerID, String manufacturerPartID,
                  Material material, int amountAvailable, PartType partType,
                  BigDecimal price, double outerDiameter, double innerDiameter, ConnectionType connection)
    {
        super(manufacturerID, manufacturerPartID, material, amountAvailable, partType, price);
        this.outerDiameter = outerDiameter;
        this.innerDiameter = innerDiameter;
        this.connection = connection;
    }

    public double getOuterDiameter()
    {
        return outerDiameter;
    }

    public void setOuterDiameter(double outerDiameter)
    {
        this.outerDiameter = outerDiameter;
    }

    public double getInnerDiameter()
    {
        return innerDiameter;
    }

    public void setInnerDiameter(double innerDiameter)
    {
        this.innerDiameter = innerDiameter;
    }

    public ConnectionType getCasingConnection()
    {
        return connection;
    }

    public void setCasingConnection(String casingConnection)
    {
        this.connection = connection;
    }
}
