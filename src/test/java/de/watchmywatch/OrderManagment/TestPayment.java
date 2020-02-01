package de.watchmywatch.OrderManagment;

import org.junit.jupiter.api.Test;


import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * Class which tests the functionality of Payment and LocalDateTime in its context
 * @author Michael Hopp
 */
public class TestPayment
{
    // create some reusable objects
    private LocalDateTime paid = LocalDateTime.now();
    private PaymentMethod paypal = PaymentMethod.PAYPAL;
    private String details = "TestDetails";

    // Testing different Constructors...
    @Test
    public void should_create_payment_with_given_method()
    {
        //Given
        Payment payment = new Payment(paypal, details);
        // When

        //Then
        assertEquals(PaymentMethod.PAYPAL, payment.getPaymentMethod());
    }

    @Test
    public void should_create_payment_with_given_details()
    {
        //Given
        Payment payment = new Payment(paypal, details);
        // When

        //Then
        assertEquals(details, payment.getDetails());
    }

    @Test
    public void should_create_payment_with_date_paid()
    {
        //Given
        Payment payment = new Payment(paid, paypal, details);
        // When

        //Then
        assertEquals(paid, payment.getDatePaid());
    }

    // Testing getters and setters...
    @Test
    public void should_set_payment_date()
    {
        //Given
        Payment payment = new Payment(paid, paypal, details);
        LocalDateTime date = LocalDateTime.of(2000, 01, 01, 12, 00);
        // When
        payment.setDatePaid(date);
        //Then
        assertEquals(date, payment.getDatePaid());
    }
}
