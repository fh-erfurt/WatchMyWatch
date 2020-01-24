package de.watchmywatch.Uhrenverwaltung;

import de.watchmywatch.Uhrenverwaltung.Validator.ClockworkValidator;
import de.watchmywatch.Uhrenverwaltung.Validator.Validatable;
import de.watchmywatch.Uhrenverwaltung.Validator.Validator;
import de.watchmywatch.Uhrenverwaltung.Validator.WatchpartValidator;

public class Clockwork extends Watchpart implements Validatable
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

    public boolean validate()
    {
        //validator for clockwork
        Validator clockworkValidator = new ClockworkValidator();
        //validate for watchpart
        Validator watchpartValidator = new WatchpartValidator();

        //check if either the casing or the watchpart are valid
        if (clockworkValidator.validate(this) && watchpartValidator.validate(this))
        {
            //log validation
            return true;
        }
        else
        {
            //log failure
            return false;
        }
    }
}
