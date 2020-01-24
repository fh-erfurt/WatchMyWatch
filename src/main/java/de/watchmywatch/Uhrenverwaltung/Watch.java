package de.watchmywatch.Uhrenverwaltung;

import de.watchmywatch.Uhrenverwaltung.Validator.Validatable;
import de.watchmywatch.Uhrenverwaltung.Validator.Validator;
import de.watchmywatch.Uhrenverwaltung.Validator.WatchValidator;

public class Watch implements Validatable
{
    private String name;
    private double price;
    private String particularity;
    //parts in the following order: Bracelet, Casing, Clockwork (if adding manually)
    private Bracelet bracelet;
    private Casing casing;
    private Clockwork clockwork;

    //contains the maximum Fee we would charge
    private static double maxFee = 200.00;
    //the percentage which is added as surcharge
    private static double surchargePercentage = 0.1;

    //Watchparts will be null->must be set by addWatchpart Method
    public Watch(String name, double price, String particularity)
    {
        this.name = name;
        this.price = price;
        this.particularity = particularity;
        this.bracelet = null;
        this.casing = null;
        this.clockwork = null;
    }

    public Watch(String name, double price, String particularity, Bracelet bracelet, Casing casing, Clockwork clockwork)
    {
        this.name = name;
        this.price = price;
        this.particularity = particularity;
        this.bracelet = bracelet;
        this.casing = casing;
        this.clockwork = clockwork;
    }

    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public double getPriceWithFee()
    {
        if (this.price < 2000.00)
        {
            return this.price + this.price * 0.1;
        }
        else
        {
            return this.price + 200.00;
        }
    }

    public double getPriceWithoutFee()
    {
        return this.price;
    }

    public void setPrice(double price)
    {
        this.price = price;
    }

    public String getParticularity()
    {
        return particularity;
    }

    public void setParticularity(String particularity)
    {
        this.particularity = particularity;
    }

    public Bracelet getBracelet()
    {
        return bracelet;
    }

    public Casing getCasing()
    {
        return casing;
    }

    public Clockwork getClockwork()
    {
        return clockwork;
    }

    public void setBracelet(Bracelet bracelet)
    {
        this.bracelet = bracelet;
    }

    public void setCasing(Casing casing)
    {
        this.casing = casing;
    }

    public void setClockwork(Clockwork clockwork)
    {
        this.clockwork = clockwork;
    }

    //validates a watch, returns true if valid and false if not valid
    public boolean validate()
    {
        Validator watchValidator = new WatchValidator();
        if (watchValidator.validate(this)
                && this.getCasing().validate()
                && this.getClockwork().validate()
                && this.getBracelet().validate())
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