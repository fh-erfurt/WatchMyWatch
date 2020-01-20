package de.watchmywatch.Uhrenverwaltung;

public class Casing extends Watchpart
{
    private double outerDiameter;
    private double innerDiameter;
    private ConnectionType connection;

    public Casing(Manufacturer manufacturer, String manufacturerPartID,
                  Material material, int amountAvailable, double price,
                  double outerDiameter, double innerDiameter, ConnectionType connection)
    {
        super(manufacturer, manufacturerPartID, material, amountAvailable, PartType.CASING, price);
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

    public ConnectionType getConnection()
    {
        return connection;
    }

    public void setConnection(String casingConnection)
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
        if (this.outerDiameter <= 0)
        {
            //TODO give info to logger
            return false;
        }
        if (this.innerDiameter <= 0)
        {
            //TODO give info to logger
            return false;
        }
        if (this.innerDiameter > this.outerDiameter)
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
