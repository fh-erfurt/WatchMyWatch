package de.watchmywatch.Uhrenverwaltung;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestWatch
{
    @Test
    public void should_check_fee_calculation_for_under_2000euro()
    {
        //Given
        //When
        Watch watch = new Watch("Swatch", 100.00, "Test");
        //Then
        assertEquals(110.00, watch.getPriceWithFee());
    }

    @Test
    public void should_check_fee_calculation_for_over_2000euro()
    {
        //Given
        //When
        Watch watch = new Watch("Swatch", 2500.00, "Test");

        //Then
        assertEquals(2700.00, watch.getPriceWithFee());
    }
}
