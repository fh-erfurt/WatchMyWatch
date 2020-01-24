package de.watchmywatch.Uhrenverwaltung.Validator;

import de.watchmywatch.Uhrenverwaltung.Bracelet;

public class BraceletValidator implements Validator
{
    @Override
    public boolean validate(Validatable validatable)
    {
        if(validatable == null){
            return false;
        }
        if (validatable instanceof Bracelet)
        {
            Bracelet bracelet = (Bracelet) validatable;
            if (bracelet.getSize() <= 0)
            {
                //TODO give info to logger
                return false;
            }
            if (bracelet.getConnection() == null)
            {
                //TODO give info to logger
                return false;
            }
        }
        return true;
    }
}
