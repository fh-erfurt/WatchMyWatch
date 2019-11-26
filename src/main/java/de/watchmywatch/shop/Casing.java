package de.watchmywatch.shop;

public class Casing extends Watchpart
{
    private double outerDiameter;
    private double innerDiameter;
    private ConnectionType connection;

    public double getOuterDiameter()
    {
        return outerDiameter;
    }

    public double getInnerDiameter()
    {
        return innerDiameter;
    }

    public ConnectionType getCasingConnection()
    {
        return connection;
    }

    public void setOuterDiameter(double outerDiameter)
    {
        this.outerDiameter = outerDiameter;
    }

    public void setInnerDiameter(double innerDiameter)
    {
        this.innerDiameter = innerDiameter;
    }

    public void setCasingConnection(String casingConnection)
    {
        this.connection = connection;
    }
}
