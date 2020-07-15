package de.watchmywatch.model.WatchManagment;

import de.watchmywatch.model.WatchManagment.Validator.BraceletValidator;
import de.watchmywatch.model.WatchManagment.Validator.Validatable;
import de.watchmywatch.model.WatchManagment.Validator.Validator;
import de.watchmywatch.model.WatchManagment.Validator.WatchpartValidator;
import io.swagger.annotations.ApiModelProperty;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import java.util.logging.Logger;

/**
 * class which represents a bracelet(Armband)
 */
@Entity
public class Bracelet extends Watchpart implements Validatable
{
    private transient Logger logger = Logger.getLogger(Logger.GLOBAL_LOGGER_NAME);

    @ApiModelProperty(notes = "The size of the bracelet.")
    private double size;

    @ApiModelProperty(notes = "The connectionType which will be used to connect to the watch.")
    @Enumerated(EnumType.STRING)
    private ConnectionType connection;

    /**
     * creates an object of bracelet
     * @param manufacturer object of the manufacturer
     * @param manufacturerPartID ID which was given by the manufacturer itself
     * @param material material which the part consists of
     * @param price price of the part itself
     * @param connection connectionType
     * @author Tom Käppler
     */
    public Bracelet(String name, Manufacturer manufacturer, String manufacturerPartID,
                    Material material, double price, int amountAvailable,
                    double size, ConnectionType connection)
    {
        super(name, manufacturer, manufacturerPartID, material, price, amountAvailable);
        this.size = size;
        this.connection = connection;
    }

    protected Bracelet(){}

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
        if(size < 0){
            logger.warning("bracelet size smaller 0");
        }
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
            logger.info("bracelet is valid");
            return true;
        }
        else
        {
            logger.warning("bracelet is not valid");
            return false;
        }
    }
}