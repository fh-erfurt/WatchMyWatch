package de.watchmywatch.shop;

import java.util.Date;

public class Payment
{
    private String id;
    private Date paid;
    //TODO why not Decimal?
    private real total;
    private Enum paymentMethod;
    private String details;
}
