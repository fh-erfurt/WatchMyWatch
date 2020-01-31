package de.watchmywatch.Uhrenverwaltung;

import de.watchmywatch.Uhrenverwaltung.Validator.BraceletValidator;
import de.watchmywatch.Uhrenverwaltung.Validator.Validatable;
import de.watchmywatch.Uhrenverwaltung.Validator.Validator;
import de.watchmywatch.Uhrenverwaltung.Validator.WatchpartValidator;

import java.util.logging.Logger;

/**
 * class which represents a bracelet(Armband)
 */
public class Bracelet extends Watchpart implements Validatable
{
    Logger logger = Logger.getLogger(Logger.GLOBAL_LOGGER_NAME);

    private double size;
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