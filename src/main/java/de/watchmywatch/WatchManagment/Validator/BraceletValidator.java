package de.watchmywatch.WatchManagment.Validator;

import de.watchmywatch.WatchManagment.Bracelet;

import java.util.logging.Logger;

/**
 * Validator class for bracelets
 * implements the Validator interface
 * @author Tom Käppler
 */
public class BraceletValidator implements Validator
{
    Logger logger = Logger.getLogger(Logger.GLOBAL_LOGGER_NAME);

    @Override

    public boolean validate(Validatable validatable)
    {
        if (validatable == null)
        {
            logger.warning("object was null");
            return false;
        }
        if (validatable instanceof Bracelet)
        {
            Bracelet bracelet = (Bracelet) validatable;
            if (bracelet.getSize() <= 0)
            {
                logger.warning("bracelet size cant be smaller/equal 0");
                return false;
            }
            if (bracelet.getConnection() == null)
            {
                logger.warning("bracelet connection cant be null");
                return false;
            }
        }
        else
        {
            logger.warning("object is not a bracelet");
            return false;
        }
        logger.info("bracelet was valid");
        return true;
    }
}
