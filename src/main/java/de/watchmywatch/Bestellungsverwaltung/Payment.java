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

    public String getId()
    {
        return id;
    }

    public BigDecimal getTotal()
    {
        return total;
    }

    public Date getPaid()
    {
        return paid;
    }

    public Enum getPaymentMethod()
    {
        return paymentMethod;
    }

    public String getDetails()
    {
        return details;
    }

    public void setId(String id)
    {
        this.id = id;
    }

    public void setDetails(String details)
    {
        this.details = details;
    }

    public void setPaid(Date paid)
    {
        this.paid = paid;
    }

    public void setPaymentMethod(Enum paymentMethod)
    {
        this.paymentMethod = paymentMethod;
    }

    public void setTotal(BigDecimal total)
    {
        this.total = total;
    }
}
