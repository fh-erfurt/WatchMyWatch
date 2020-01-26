package de.watchmywatch.Uhrenverwaltung;

import de.watchmywatch.Uhrenverwaltung.Validator.CasingValidator;
import de.watchmywatch.Uhrenverwaltung.Validator.Validatable;
import de.watchmywatch.Uhrenverwaltung.Validator.Validator;
import de.watchmywatch.Uhrenverwaltung.Validator.WatchpartValidator;

public class Casing extends Watchpart implements Validatable
{
    private double outerDiameter;
    private double innerDiameter;
    private ConnectionType connection;

    public Casing(Manufacturer manufacturer, String manufacturerPartID,
                  Material material, int amountAvailable, double price,
                  double outerDiameter, double innerDiameter, ConnectionType connection)
    {
        super(manufacturer, manufacturerPartID, material, amountAvailable, price);
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
        //validator for casing
        Validator casingValidator = new CasingValidator();
        //validate for watchpart
        Validator watchpartValidator = new WatchpartValidator();

        //check if either the casing or the watchpart are valid
        if (casingValidator.validate(this) && watchpartValidator.validate(this))
        {
            //log validation
            return true;
        }
        else
        {
            return false;
        }
    }
}
