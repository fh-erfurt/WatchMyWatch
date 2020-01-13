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

    public ConnectionType getCasingConnection()
    {
        return connection;
    }

    public void setCasingConnection(String casingConnection)
    {
        this.connection = connection;
    }
}
