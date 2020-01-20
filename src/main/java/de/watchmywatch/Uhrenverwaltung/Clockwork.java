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

    public boolean valiate(){
        if (!super.validate())
        {
            //TODO give info to logger
            return false;
        }
        if (this.diameter <= 0)
        {
            //TODO give info to logger
            return false;
        }

        return true;
    }
}
