package de.watchmywatch.OrderManagment;

import java.time.LocalDateTime;
import java.util.logging.Logger;

// TODO: ADD Parent Constructor in Child
/**
 * Class which represents a Payment
 * @author Michael Hopp
 */
@Entity
public class Payment
{
    Logger logger = Logger.getLogger(Logger.GLOBAL_LOGGER_NAME);

    @Temporal( TemporalType.DATETIME )
    private LocalDateTime datePaid;         // Date at which Payment was executed. Acts as Flag for paid or unpaid Orders.

    // TODO: Enum in Datenbank
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
