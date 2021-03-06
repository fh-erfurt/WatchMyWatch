package de.watchmywatch.model.WatchManagment.Validator;

import de.watchmywatch.model.WatchManagment.Watchpart;

import java.util.logging.Logger;

/**
 * Validator class for watchparts
 * implements the Validator interface
 * @author Tom Käppler
 */
public class WatchpartValidator implements Validator
{
    Logger logger = Logger.getLogger(Logger.GLOBAL_LOGGER_NAME);

    @Override
    public boolean validate(Validatable validatable)
    {
        if(validatable == null){
            logger.warning("object is null");
            return false;
        }
        if (validatable instanceof Watchpart)
        {
            Watchpart watchpart = (Watchpart) validatable;

            if (watchpart.getManufacturerPartID() == null)
            {
                logger.warning("manufacturerPartID cant be null");
                return false;
            }
            if (watchpart.getMaterial() == null)
            {
                logger.warning("material cant be null");
                return false;
            }
            if (watchpart.getPrice() <= 0)
            {
                logger.warning("price cant be lower/equal 0");
                return false;
            }
        } else
        {
            logger.warning("object is not a watchpart");
            return false;
        }
        logger.info("watchpart is valid");
        return true;
    }
}
