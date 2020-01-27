package de.watchmywatch.Uhrenverwaltung;

import de.watchmywatch.Uhrenverwaltung.Validator.BraceletValidator;
import de.watchmywatch.Uhrenverwaltung.Validator.Validatable;
import de.watchmywatch.Uhrenverwaltung.Validator.Validator;
import de.watchmywatch.Uhrenverwaltung.Validator.WatchpartValidator;

public class Bracelet extends Watchpart implements Validatable
{
    private double size;
    private ConnectionType connection;

    public Bracelet(Manufacturer manufacturer, String manufacturerPartID,
                    Material material, double price,
                    double size, ConnectionType connection)
    {
        super(manufacturer, manufacturerPartID, material, price);
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
        //validator for bracelet
        Validator braceletValidator = new BraceletValidator();
        //validate for watchpart
        Validator watchpartValidator = new WatchpartValidator();

        //check if either the casing or the watchpart are valid
        if (braceletValidator.validate(this) && watchpartValidator.validate(this))
        {
            //log validation
            return true;
        }
        else
        {
            // log failure
            return false;
        }
    }
}