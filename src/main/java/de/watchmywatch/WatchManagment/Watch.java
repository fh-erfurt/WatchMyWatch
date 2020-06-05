package de.watchmywatch.WatchManagment;


import de.watchmywatch.Exceptions.WatchNameNotValidException;
import de.watchmywatch.Helper.DatabaseEntity;
import de.watchmywatch.WatchManagment.Validator.*;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import java.util.logging.Logger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * class which represents a watch
 */
@Entity
public class Watch extends DatabaseEntity implements Validatable
{
    Logger logger = Logger.getLogger(Logger.GLOBAL_LOGGER_NAME);

    private String name;
    private double price;
    private String particularity;
    //parts in the following order: Bracelet, Casing, Clockwork (if adding manually)
    @ManyToOne
    private Bracelet bracelet;
    @ManyToOne
    private Casing casing;
    @ManyToOne
    private Clockwork clockwork;

    //contains the maximum Fee we would charge
    private static double maxFee = 200.00;
    //the percentage which is added as surcharge
    private static double surchargePercentage = 0.1;


    /**
     * creates a watch object with the parts being null
     * they have to be set later with the set-Methods
     *
     * @param name name of the watch
     * @param particularity (Einzigartigkeit)
     * @author Tom Käppler
     */
    public Watch(String name, String particularity) throws WatchNameNotValidException
    {
        checkWatchName(name);
        this.name = name;
        this.price = 0;
        this.particularity = particularity;
        this.bracelet = null;
        this.casing = null;
        this.clockwork = null;
    }

    /**
     * creates a watch object
     *
     * @param name name of the watch
     * @param particularity particularity of the watch
     * @param bracelet bracelet attached to the watch
     * @param casing casing of the watch
     * @param clockwork clockwork of the watch
     * @author Tom Käppler
     */
    public Watch(String name, String particularity, Bracelet bracelet, Casing casing, Clockwork clockwork) throws WatchNameNotValidException
    {
        checkWatchName(name);
        this.name = name;
        this.particularity = particularity;
        this.bracelet = bracelet;
        this.casing = casing;
        this.clockwork = clockwork;
        this.price = this.bracelet.getPrice() + this.casing.getPrice() + this.clockwork.getPrice();
    }

    protected Watch(){}

    /**
     * checks the watchName for unacceptable characters/length/emptiness
     *
     * @param name name which should be checked
     * @author Tom Käppler
     */
    private void checkWatchName(String name) throws WatchNameNotValidException
    {
        Pattern pattern = Pattern.compile("^[0-9a-zA-ZäÄöÖüÜß]*$");
        Matcher matcher = pattern.matcher(name);

        if (!matcher.find())
        {
            logger.warning("watch name contains invalid characters");
            throw new WatchNameNotValidException("Name contains invalid characters");
        }
        else if (name.trim().isEmpty())
        {
            logger.warning("watch name should not be empty");
            throw new WatchNameNotValidException("Name should not be empty");
        }
        else if (name.length() > 140)
        {
            logger.warning("watch name should not be longer than 140 characters");
            throw new WatchNameNotValidException("Name should not be longer than 140 characters");
        }
    }

    public String getName()
    {
        return name;
    }

    public void setName(String name) throws WatchNameNotValidException
    {
        checkWatchName(name);
        this.name = name;
    }

    /**
     * @return returns the calculated price with our fees
     * @author Tom Käppler
     */
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

    /**
     * @return returns the price without fees
     * @author Tom Käppler
     */
    public double getPriceWithoutFee()
    {
        return this.price;
    }

    public void setPrice(double price)
    {
        if (price <= 0)
        {
            logger.warning("price should not be lower/equal 0");
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
            this.price += bracelet.getPrice();
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
            this.price += casing.getPrice();
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
            this.price += clockwork.getPrice();
        }
        else
        {
            logger.warning("clockwork is not valid -> was not set");
        }

    }

    /**
     * @return true - if watch is valid / false - if watch is not valid
     * @author Tom Käppler
     */
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