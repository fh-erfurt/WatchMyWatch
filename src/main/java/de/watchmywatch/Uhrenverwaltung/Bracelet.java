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

    public double getSize()
    {
        return size;
    }

    public ConnectionType getConnection()
    {
        return connection;
    }

    public void setSize(double size)
    {
        this.size = size;
    }

    public void setConnection(ConnectionType connection)
    {
        this.connection = connection;
    }

    public boolean validate()
    {
        if (!super.validate())
        {
            //TODO give info to logger
            return false;
        }
        if (this.size <= 0)
        {
            //TODO give info to logger
            return false;
        }
        if (this.connection == null)
        {
            //TODO give info to logger
            return false;
        }
        return true;
    }
}