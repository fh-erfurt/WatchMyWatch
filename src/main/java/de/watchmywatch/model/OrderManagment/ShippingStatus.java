package de.watchmywatch.model.OrderManagment;
// TODO: How shall enums be implemented into the Database? Where comes the id? No Timestamps needed... Enum as Entity?
/**
 * Enum which represents the different shipping statuses of an Order
 * @author Michael Hopp
 */
public enum ShippingStatus
{
    PENDING,
    SENT,
    DELIVERED,
    RETURNING,
    RETURNED
}
