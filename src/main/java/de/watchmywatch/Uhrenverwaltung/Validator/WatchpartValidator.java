package de.watchmywatch.Uhrenverwaltung.Validator;

import de.watchmywatch.Uhrenverwaltung.Watchpart;

public class WatchpartValidator implements Validator
{
    @Override
    public boolean validate(Validatable validatable)
    {
        if(validatable == null){
            return false;
        }
        if (validatable instanceof Watchpart)
        {
            Watchpart watchpart = (Watchpart) validatable;

            if (watchpart.getManufacturerPartID() == null)
            {
                //TODO give info to logger
                return false;
            }
            if (watchpart.getMaterial() == null)
            {
                //TODO give info to logger
                return false;
            }
            if (watchpart.getAmountAvailable() < 0)
            {
                //TODO give info to logger
                return false;
            }
            if (watchpart.getPartType() == null)
            {
                //TODO give info to logger
                return false;
            }
            if (watchpart.getPrice() <= 0)
            {
                //TODO give info to logger
                return false;
            }
        } else
        {
            //Logger: not a casing
        }
        //no problems occurred so return with true
        return true;
    }
}
