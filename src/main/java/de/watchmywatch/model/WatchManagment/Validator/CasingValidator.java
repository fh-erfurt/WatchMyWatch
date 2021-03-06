package de.watchmywatch.model.WatchManagment.Validator;

import de.watchmywatch.model.WatchManagment.Casing;

import java.util.logging.Logger;

/**
 * Validator class for casings
 * implements the Validator interface
 * @author Tom Käppler
 */
public class CasingValidator implements Validator
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
        if (validatable instanceof Casing)
        {
            Casing casing = (Casing) validatable;

            if (casing.getPrice() <= 0)
            {
                logger.warning("casing price cant be smaller/equal 0");
                return false;
            }
            if (casing.getInnerDiameter() <= 0)
            {
                logger.warning("casing inner diameter cant be smaller/equal 0");
                return false;
            }
            if (casing.getInnerDiameter() > casing.getOuterDiameter())
            {
                logger.warning("casing inner diameter cant be bigger than outer diameter");
                return false;
            }
            if (casing.getConnection() == null)
            {
                logger.warning(casing.getConnection().toString());
                logger.warning("casing connection cant be null");
                return false;
            }
        }
        else
        {
            logger.warning("casing is not a casing");
            return false;
        }
        logger.info("casing was valid");
        return true;
    }
}
