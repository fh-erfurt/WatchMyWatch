package de.watchmywatch.Uhrenverwaltung;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

public class ManagerWatch
{
    private static Map<Integer, Watch> watchMap = new HashMap<Integer, Watch>();
    private static int idCounter = 1;

    public boolean addWatch(){return false};
    public boolean removeWatch(){return false};
    public BigDecimal getPriceWithExtraCost(){return new BigDecimal(1);};
    public BigDecimal getPriceWithoutExtraCost(){return new BigDecimal(1);};
}
