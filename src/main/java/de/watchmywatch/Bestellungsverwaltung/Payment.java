package de.watchmywatch.Bestellungsverwaltung;

import java.time.LocalDateTime;
import java.util.logging.Logger;

/**
 * @author Michael Hopp
 */
public class Payment
{
    Logger logger = Logger.getLogger(Logger.GLOBAL_LOGGER_NAME);

    private LocalDateTime datePaid;
    private PaymentMethod paymentMethod;
    private String details;     // Verwendungszweck, Buchungsgrund o.Ä.

    public Payment()
    {
        this.datePaid = null;
        this.paymentMethod = null;
        this.details = null;
    }
    public Payment(PaymentMethod paymentMethod) {
        this.datePaid = null;
        this.paymentMethod = paymentMethod;
        this.details = null;
    }
    public Payment(PaymentMethod paymentMethod, String details) {
        this.datePaid = null;
        this.paymentMethod = paymentMethod;
        this.details = details;
    }
    public Payment(LocalDateTime paid, PaymentMethod paymentMethod, String details) {
        this.datePaid = paid;
        this.paymentMethod = paymentMethod;
        this.details = details;
    }

    public LocalDateTime getDatePaid()
    {
        return datePaid;
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

    public void setDatePaid(LocalDateTime paid)
    {
        this.datePaid = paid;
    }

    public void setPaymentMethod(PaymentMethod paymentMethod)
    {
        this.paymentMethod = paymentMethod;
    }
}
