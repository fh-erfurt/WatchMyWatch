package de.watchmywatch.Uhrenverwaltung.Validator;

import de.watchmywatch.Uhrenverwaltung.Watch;

import java.util.logging.Logger;

public class WatchValidator implements Validator
{
    Logger logger = Logger.getLogger(Logger.GLOBAL_LOGGER_NAME);

    @Override
    public boolean validate(Validatable validatable)
    {
        if (validatable instanceof Watch)
        {
            Watch watch = (Watch) validatable;

            if (watch.getPriceWithoutFee() <= 0)
            {
                logger.warning("price cant be lower/equal 0");
                return false;
            }
            if (watch.getName() == null)
            {
                logger.warning("name cant be null");
                return false;
            }
            if (watch.getBracelet() == null)
            {
                logger.warning("bracelet cant be null");
                return false;
            } else
            {
                if (!watch.getBracelet().validate())
                {
                    logger.warning("bracelet is not valid");
                    return false;
                }
            }
            if (watch.getCasing() == null)
            {
                logger.warning("casing cant be null");
                return false;
            } else
            {
                if (!watch.getCasing().validate())
                {
                    logger.warning("casing is not valid");
                    return false;
                }
            }
            if (watch.getClockwork() == null)
            {
                logger.warning("clockwork cant be null");
                return false;
            } else
            {
                if (!watch.getClockwork().validate())
                {
                    logger.warning("clockwork is not valid");
                    return false;
                }
            }
            //connections dont match each other
            if (watch.getBracelet().getConnection() != watch.getCasing().getConnection())
            {
                logger.warning("braceletConnection does not match casingConnection");
                return false;
            }
            //diameters dont match each other
            if (watch.getCasing().getInnerDiameter() < watch.getClockwork().getDiameter())
            {
                logger.warning("casingInnerDiameter cant be smaller clockworkDiameter");
                return false;
            }
        }
        else{
            logger.warning("object is not a watch");
            return false;
        }
        logger.info("watch is valid");
        return true;
    }
}
