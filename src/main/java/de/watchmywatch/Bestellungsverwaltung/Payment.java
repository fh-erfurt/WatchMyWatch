package de.watchmywatch.Bestellungsverwaltung;

import java.util.Date;

public class Payment
{
    private Date paid;
    private PaymentMethod paymentMethod;
    private String details;     // Verwendungszweck, Buchungsgrund o.Ä.


    public Date getPaid()
    {
        return paid;
    }

    public PaymentMethod getPaymentMethod()
    {
        return paymentMethod;
    }

    public String getDetails()
    {
        return details;
    }

    public void setDetails(String details)
    {
        this.details = details;
    }

    public void setPaid(Date paid)
    {
        this.paid = paid;
    }

    public void setPaymentMethod(PaymentMethod paymentMethod)
    {
        this.paymentMethod = paymentMethod;
    }

    /*
    TODO: Obsolet? Löschen...
    public double getTotal()
    {
        return total;
    }
    public void setTotal(double total)
    {
        this.total = total;
    }
    */
}
