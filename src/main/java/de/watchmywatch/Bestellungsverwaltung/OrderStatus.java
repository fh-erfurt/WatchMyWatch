package de.watchmywatch.Bestellungsverwaltung;

/**
 * @author Michael Hopp
 */
public enum OrderStatus
{
    PENDING,    // Starting Status for each new Order until further steps in Workflow are reached.
    COMPLETE,
    CANCELLED,
    DELAYED     // Order could not be completed yet. For Example: Missing Informations, Desired Products not in Stock, ...
}
