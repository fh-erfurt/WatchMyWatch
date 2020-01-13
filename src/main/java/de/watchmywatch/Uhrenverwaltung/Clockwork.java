package de.watchmywatch.Uhrenverwaltung;

public class Clockwork extends Watchpart
{
    private double diameter;

    public Clockwork(Manufacturer manufacturer, String manufacturerPartID,
                     Material material, int amountAvailable,
                     double price, double diameter)
    {
        super(manufacturer, manufacturerPartID, material, amountAvailable, PartType.CLOCKWORK, price);
        this.diameter = diameter;
    }

    public double getDiameter()
    {
        return diameter;
    }

    public void setDiameter(double diameter)
    {
        this.diameter = diameter;
    }
}
