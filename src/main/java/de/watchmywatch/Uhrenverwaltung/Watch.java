package de.watchmywatch.Uhrenverwaltung;

import de.watchmywatch.Exceptions.NameException;
import de.watchmywatch.Uhrenverwaltung.Validator.*;

import java.util.logging.Logger;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Watch implements Validatable
{
    Logger logger = Logger.getLogger(Logger.GLOBAL_LOGGER_NAME);


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
    public Watch(String name, double price, String particularity) throws NameException
    {
        checkName(name);
        this.name = name;
        this.price = price;
        this.particularity = particularity;
        this.bracelet = null;
        this.casing = null;
        this.clockwork = null;
    }

    public Watch(String name, double price, String particularity, Bracelet bracelet, Casing casing, Clockwork clockwork) throws NameException
    {
        checkName(name);
        this.name = name;
        this.price = price;
        this.particularity = particularity;
        this.bracelet = bracelet;
        this.casing = casing;
        this.clockwork = clockwork;
    }

    public void checkName(String name) throws NameException
    {
        Pattern pattern = Pattern.compile("^[a-zA-ZäÄöÖüÜß]*$");
        Matcher matcher = pattern.matcher(name);

        if (!matcher.find())
        {
            logger.warning("watch name contains invalid characters");
            throw new NameException("Name contains invalid characters");
        }
        else if (name.trim().isEmpty())
        {
            logger.warning("watch name should not be empty");
            throw new NameException("Name should not be empty");
        }
        else if (name.length() > 140)
        {
            logger.warning("watch name should not be longer than 140 characters");
            throw new NameException("Name should not be longer than 140 characters");
        }
    }

    public String getName()
    {
        return name;
    }

    public void setName(String name) throws NameException
    {
        checkName(name);
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
        if (price <= 0)
        {
            logger.warning("price should not be lower/equal zero");
        }
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
        Validator braceletValidator = new BraceletValidator();
        if (braceletValidator.validate(bracelet))
        {
            this.bracelet = bracelet;
        }
        else
        {
            logger.warning("bracelet is not valid -> was not set");
        }
    }

    public void setCasing(Casing casing)
    {
        Validator casingValidator = new CasingValidator();
        if (casingValidator.validate(casing))
        {
            this.casing = casing;
        }
        else
        {
            logger.warning("casing is not valid -> was not set");
        }
    }

    public void setClockwork(Clockwork clockwork)
    {
        Validator clockworkValidator = new ClockworkValidator();
        if (clockworkValidator.validate(clockwork))
        {
            this.clockwork = clockwork;
        }
        else
        {
            logger.warning("clockwork is not valid -> was not set");
        }

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
            logger.info("watch validation was successful");
            return true;
        }
        else
        {
            logger.info("watch validation was not successful");
            return false;
        }
    }
}