package de.watchmywatch.Bestellungsverwaltung;

import org.junit.jupiter.api.Test;


import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestPayment
{
    // create some reusable objects
    LocalDateTime paid = LocalDateTime.now();
    PaymentMethod paypal = PaymentMethod.PAYPAL;
    String details = "TestDetails";

    @Test
    public void should_create_payment_with_given_method()
    {
        //Given
        Payment payment = new Payment(paypal,details);
        // When

        //Then
        assertEquals( PaymentMethod.PAYPAL , payment.getPaymentMethod());
    }

    @Test
    public void should_create_payment_with_given_details()
    {
        //Given
        Payment payment = new Payment(paypal,details);
        // When

        //Then
        assertEquals( details, payment.getDetails());
    }

    @Test
    public void should_create_payment_with_date_paid()
    {
        //Given
        Payment payment = new Payment(paid,paypal,details);
        // When

        //Then
        assertEquals( paid, payment.getDatePaid());
    }

    @Test
    public void should_set_payment_date()
    {
        //Given
        Payment payment = new Payment(paid,paypal,details);
        LocalDateTime date = LocalDateTime.of(2000,01,01,12,00);
        // When
        payment.setDatePaid(date);
        //Then
        assertEquals( date, payment.getDatePaid());
    }

    @Test
    public void should_change_payment_method()
    {
        //Given
        Payment payment = new Payment(paypal,details);
        PaymentMethod method = PaymentMethod.CREDITCARD;
        // When
        payment.setPaymentMethod(method);
        //Then
        assertEquals( PaymentMethod.CREDITCARD , payment.getPaymentMethod());
    }

    @Test
    public void should_change_payment_details()
    {
        //Given
        Payment payment = new Payment(paypal,details);
        String newDetails = "New Details";
        // When
        payment.setDetails(newDetails);
        //Then
        assertEquals( newDetails , payment.getDetails());
    }
}
