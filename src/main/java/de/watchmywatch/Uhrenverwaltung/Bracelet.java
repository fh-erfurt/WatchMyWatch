package de.watchmywatch.Uhrenverwaltung;

import java.math.BigDecimal;

public class Bracelet extends Watchpart
{
    private double size;
    private ConnectionType connection;

    public Bracelet(int manufacturerID, String manufacturerPartID,
                    Material material, int amountAvailable, PartType partType,
                    BigDecimal price, double size, ConnectionType connection)
    {
        super(manufacturerID, manufacturerPartID, material, amountAvailable, partType, price);
        this.size = size;
        this.connection = connection;
    }

    public double getScope()
    {
        return size;
    }

    public ConnectionType getConnection()
    {
        return connection;
    }

    public void setScope(double scope)
    {
        this.size = scope;
    }

    public void setConnection(ConnectionType connection)
    {
        this.connection = connection;
    }
}