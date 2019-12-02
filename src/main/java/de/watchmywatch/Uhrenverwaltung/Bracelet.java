package de.watchmywatch.Uhrenverwaltung;

import java.math.BigDecimal;

public class Bracelet extends Watchpart
{
    private double scope;
    private ConnectionType connection;

    public Bracelet(int manufacturerID, String manufacturerPartID,
                    Material material, int amountAvailable, PartType partType,
                    BigDecimal price, double scope, ConnectionType connection)
    {
        setId(idCounter);
        ++idCounter;
        setManufacturerID(manufacturerID);
        setManufacturerPartId(manufacturerPartID);
        setMaterial(material);
        setAmountAvailable(amountAvailable);
        setPartType(partType);
        setPrice(price);

        this.scope = scope;
        this.connection = connection;
    }

    public double getScope()
    {
        return scope;
    }

    public ConnectionType getConnection()
    {
        return connection;
    }

    public void setScope(double scope)
    {
        this.scope = scope;
    }

    public void setConnection(ConnectionType connection)
    {
        this.connection = connection;
    }
}