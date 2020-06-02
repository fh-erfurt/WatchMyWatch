package de.watchmywatch.OrderManagment;
// TODO: How shall enums be implemented into the Database? Where comes the id? No Timestamps needed...
/**
 * Enum which represents different methods for how a Payment shall be executed.
 * @author Michael Hopp
 */
public enum PaymentMethod
    {
    PAYPAL,
    CREDITCARD,
    TRANSFER,
    SEPA
    }
