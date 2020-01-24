package de.watchmywatch.Uhrenverwaltung.Validator;

import de.watchmywatch.Uhrenverwaltung.Watch;

public class WatchValidator implements Validator
{
    @Override
    public boolean validate(Validatable validatable)
    {
        if (validatable instanceof Watch)
        {
            Watch watch = (Watch) validatable;

            if (watch.getPriceWithoutFee() <= 0)
            {
                //TODO give info to logger
                return false;
            }
            if (watch.getName() == null)
            {
                //TODO give info to logger
                return false;
            }
            if (watch.getBracelet() == null)
            {
                //TODO give info to logger
                return false;
            } else
            {
                if (!watch.getBracelet().validate())
                {
                    return false;
                }
            }
            if (watch.getCasing() == null)
            {
                //TODO give info to logger
                return false;
            } else
            {
                if (!watch.getCasing().validate())
                {
                    return false;
                }
            }
            if (watch.getClockwork() == null)
            {
                //TODO give info to logger
                return false;
            } else
            {
                if (!watch.getClockwork().validate())
                {
                    return false;
                }
            }
            //connections dont match each other
            if (watch.getBracelet().getConnection() != watch.getCasing().getConnection())
            {
                //TODO give info to logger
                return false;
            }
            //diameters dont match each other
            if (watch.getCasing().getInnerDiameter() != watch.getClockwork().getDiameter())
            {
                //TODO give info to logger
                return false;
            }
        }
        return true;
    }
}
