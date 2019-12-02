package de.watchmywatch.Bestellungsverwaltung;

import java.math.BigDecimal;
import java.util.Date;

public class Payment
{
    private String id;
    private Date paid;
    private BigDecimal total;
    private Enum paymentMethod;
    private String details;
}
