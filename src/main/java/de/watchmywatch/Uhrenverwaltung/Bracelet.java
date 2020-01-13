package de.watchmywatch.Uhrenverwaltung;

public class Bracelet extends Watchpart
{
    private double size;
    private ConnectionType connection;

    public Bracelet(Manufacturer manufacturer, String manufacturerPartID,
                    Material material, int amountAvailable, double price,
                    double size, ConnectionType connection)
    {
        super(manufacturer, manufacturerPartID, material, amountAvailable, PartType.BRACELET, price);
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