package de.watchmywatch.Uhrenverwaltung.Validator;

import de.watchmywatch.Uhrenverwaltung.Clockwork;

import java.util.logging.Logger;

/**
 * Validator class for clockworks
 * implements the Validator interface
 * @author Tom Käppler
 */
public class ClockworkValidator implements Validator
{
    Logger logger = Logger.getLogger(Logger.GLOBAL_LOGGER_NAME);

    @Override
    public boolean validate(Validatable validatable)
    {
        if (validatable == null)
        {
            logger.warning("object is null");
            return false;
        }
        if (validatable instanceof Clockwork)
        {
            Clockwork clockwork = (Clockwork) validatable;
            if (clockwork.getDiameter() <= 0)
            {
                logger.warning("diameter cant be smaller/equal 0");
                return false;
            }
        }
        else
        {
            logger.warning("object is not a clockwork");
            return false;
        }
        logger.info("clockwork is valid");
        return true;
    }
}
