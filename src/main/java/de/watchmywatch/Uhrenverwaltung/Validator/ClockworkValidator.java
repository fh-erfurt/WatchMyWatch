package de.watchmywatch.Uhrenverwaltung.Validator;

import de.watchmywatch.Uhrenverwaltung.Clockwork;

public class ClockworkValidator implements Validator
{
    @Override
    public boolean validate(Validatable validatable)
    {
        if(validatable == null){
            return false;
        }
        if (validatable instanceof Clockwork)
        {
            Clockwork clockwork = (Clockwork) validatable;
            if (clockwork.getDiameter() <= 0)
            {
                //TODO give info to logger
                return false;
            }
        }else{
            //TODO log output
        }
        return true;
    }
}
