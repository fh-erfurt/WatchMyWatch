package de.watchmywatch.model.WatchManagment;

import de.watchmywatch.model.WatchManagment.Validator.ClockworkValidator;
import de.watchmywatch.model.WatchManagment.Validator.Validatable;
import de.watchmywatch.model.WatchManagment.Validator.Validator;
import de.watchmywatch.model.WatchManagment.Validator.WatchpartValidator;

import javax.persistence.Entity;
import java.util.logging.Logger;

/**
 * class which represents a clockwork(Uhrenwerk)
 */
@Entity
public class Clockwork extends Watchpart implements Validatable
{
    private transient Logger logger = Logger.getLogger(Logger.GLOBAL_LOGGER_NAME);

    private double diameter;

    /**
     * creates an object of clockwork
     * @param manufacturer object of the manufacturer
     * @param manufacturerPartID ID which was given by the manufacturer itself
     * @param material material which the part consists of
     * @param price price of the part itself
     * @param diameter diameter of the clockwork
     * @author Tom Käppler
     */
    public Clockwork(Manufacturer manufacturer, String manufacturerPartID,
                     Material material, double price, double diameter)
    {
        super(manufacturer, manufacturerPartID, material, price);
        this.diameter = diameter;
    }

    protected Clockwork(){}

    public double getDiameter()
    {
        return diameter;
    }

    public void setDiameter(double diameter)
    {
        if(diameter < 0){
            logger.warning("diameter is smaller zero");
        }
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
            logger.info("clockwork is valid");
            return true;
        }
        else
        {
            logger.warning("clockwork is not valid");
            return false;
        }
    }
}
