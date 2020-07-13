package de.watchmywatch.model.WatchManagment;

import de.watchmywatch.model.WatchManagment.Validator.CasingValidator;
import de.watchmywatch.model.WatchManagment.Validator.Validatable;
import de.watchmywatch.model.WatchManagment.Validator.Validator;
import de.watchmywatch.model.WatchManagment.Validator.WatchpartValidator;
import io.swagger.annotations.ApiModelProperty;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import java.util.logging.Logger;

/**
 * class which represents a casing(Gehäuse)
 */
@Entity
public class Casing extends Watchpart implements Validatable
{
    private transient Logger logger = Logger.getLogger(Logger.GLOBAL_LOGGER_NAME);

    @ApiModelProperty(notes = "The outerDiameter of the casing.")
    private double outerDiameter;
    @ApiModelProperty(notes = "The innerDiameter of the casing (space for the clockwork)")
    private double innerDiameter;

    @ApiModelProperty(notes = "The connectionType which will be used to connect to the watch.")
    @Enumerated(EnumType.STRING)
    private ConnectionType connection;

    /**
     * creates an object of casing
     * @param manufacturer object of the manufacturer
     * @param manufacturerPartID ID which was given by the manufacturer itself
     * @param material material which the part consists of
     * @param price price of the part itself
     * @param outerDiameter outerDiameter of the casing
     * @param innerDiameter innerDiameter of the casing where the clockwork should fit
     * @param connection connectionType
     * @author Tom Käppler
     */
    public Casing(Manufacturer manufacturer, String manufacturerPartID,
                  Material material, double price, int amountAvailable,
                  double outerDiameter, double innerDiameter, ConnectionType connection)
    {
        super(manufacturer, manufacturerPartID, material, price, amountAvailable);
        this.outerDiameter = outerDiameter;
        this.innerDiameter = innerDiameter;
        this.connection = connection;
    }

    protected Casing(){}

    public double getOuterDiameter()
    {
        return outerDiameter;
    }

    public void setOuterDiameter(double outerDiameter)
    {
        if(outerDiameter < 0 || outerDiameter < innerDiameter){
            logger.warning("outerDiameter is smaller zero or smaller then innerDiameter");
        }
        this.outerDiameter = outerDiameter;
    }

    public double getInnerDiameter()
    {
        return innerDiameter;
    }

    public void setInnerDiameter(double innerDiameter)
    {
        if(innerDiameter < 0 || innerDiameter > outerDiameter){
            logger.warning("innerDiameter is smaller zero or bigger then outerDiameter");
        }
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
            logger.info("casing is valid");
            return true;
        }
        else
        {
            logger.warning("casing is not valid");
            return false;
        }
    }
}
