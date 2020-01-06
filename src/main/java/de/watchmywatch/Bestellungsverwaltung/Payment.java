package de.watchmywatch.Bestellungsverwaltung;

import java.math.BigDecimal;
import java.util.Date;

public class Payment
{
    private String id;
    private Date paid;
    // TODO: total hier entfernen, und aus Order nutzen
    private BigDecimal total;
    private PaymentMethod paymentMethod;
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

    public PaymentMethod getPaymentMethod()
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

    public void setPaymentMethod(PaymentMethod paymentMethod)
    {
        this.paymentMethod = paymentMethod;
    }

    public void setTotal(BigDecimal total)
    {
        this.total = total;
    }
}
