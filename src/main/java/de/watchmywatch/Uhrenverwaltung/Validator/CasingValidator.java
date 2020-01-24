package de.watchmywatch.Uhrenverwaltung.Validator;

import de.watchmywatch.Uhrenverwaltung.Casing;

public class CasingValidator implements Validator
{
    @Override
    public boolean validate(Validatable validatable)
    {
        if(validatable == null){
            return false;
        }
        if (validatable instanceof Casing)
        {
            Casing casing = (Casing) validatable;

            if (casing.getPrice() <= 0)
            {
                //TODO give info to logger
                return false;
            }
            if (casing.getInnerDiameter() <= 0)
            {
                //TODO give info to logger
                return false;
            }
            if (casing.getInnerDiameter() > casing.getOuterDiameter())
            {
                //TODO give info to logger
                return false;
            }
            if (casing.getConnection() == null)
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
