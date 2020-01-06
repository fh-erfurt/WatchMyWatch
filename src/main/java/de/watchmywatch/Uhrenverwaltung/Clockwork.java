package de.watchmywatch.Uhrenverwaltung;

import java.math.BigDecimal;

public class Clockwork extends Watchpart
{
    private double diameter;

    public Clockwork(int manufacturerID, String manufacturerPartID,
                     Material material, int amountAvailable,
                     BigDecimal price, double diameter)
    {
        super(manufacturerID, manufacturerPartID, material, amountAvailable, PartType.CLOCKWORK, price);
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
