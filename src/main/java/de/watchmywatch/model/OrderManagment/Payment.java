package de.watchmywatch.model.OrderManagment;

import de.watchmywatch.model.Helper.DatabaseEntity;

import javax.persistence.*;
import java.util.Date;
import java.util.logging.Logger;

/**
 * Class which represents a Payment
 * @author Michael Hopp
 */
@Entity
public class Payment extends DatabaseEntity
{
    private transient Logger logger = Logger.getLogger(Logger.GLOBAL_LOGGER_NAME);

    @Temporal( TemporalType.TIMESTAMP )
    private Date datePaid;         // Date at which Payment was executed. Acts as Flag for paid or unpaid Orders.

    @Enumerated(EnumType.STRING)
    private PaymentMethod paymentMethod;

    private String details;                 // Usage, Extra information, ...

    /**
     * Creates an empty Payment-Object which has to be initialized by set-Methods after reaching influencing steps in the payment process.
     * @author Michael Hopp
     */
    public Payment()
    {
        this.datePaid = null;
        this.paymentMethod = null;
        this.details = null;
    }

    /**
     * Creates Payment-Object with given Payment Method. Can be used when default Payment Method of an Account is set.
     * @param paymentMethod Payment Method. For example PayPal or Transfer.
     * @author Michael Hopp
     */
    public Payment(PaymentMethod paymentMethod) {
        this.datePaid = null;
        this.paymentMethod = paymentMethod;
        this.details = null;
    }

    /**
     * @param paymentMethod Payment Method. For example PayPal or Transfer.
     * @param details       Details for Payment. Usage or extra information.
     * @author Michael Hopp
     */
    public Payment(PaymentMethod paymentMethod, String details) {
        this.datePaid = null;
        this.paymentMethod = paymentMethod;
        this.details = details;
    }

    /**
     * Creates a completed/paid Payment.
     * @param paymentMethod Payment Method. For example PayPal or Transfer.
     * @param details       Details for Payment. Usage or extra information.
     * @param paid          Date at which Payment was executed.
     * @author Michael Hopp
     */
    public Payment(Date paid, PaymentMethod paymentMethod, String details) {
        this.datePaid = paid;
        this.paymentMethod = paymentMethod;
        this.details = details;
    }

    public Date getDatePaid()
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

    public void setDatePaid(Date paid)
    {
        this.datePaid = paid;
    }

    public void setPaymentMethod(PaymentMethod paymentMethod)
    {
        this.paymentMethod = paymentMethod;
    }
}
