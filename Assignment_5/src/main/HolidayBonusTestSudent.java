package main;

import org.junit.Test;
import static org.junit.Assert.*;

import org.junit.Before;

public class HolidayBonusTestSudent {

    private double[][] testArray;

    @Before
    public void setUp() {
        testArray = new double[][]{
            {1.5, 2.0, 3.0},
            {4.5, 5.5},
            {6.0, 7.0, 8.0, 9.0}
        };
    }

    @Test
    public void testCalculateHolidayBonus() {
        double[] expectedBonuses = {1000.0, 500.0, 1500.0}; // Adjusted based on bonus logic.
        double[] actualBonuses = HolidayBonus.calculateHolidayBonus(testArray);
        assertArrayEquals(expectedBonuses, actualBonuses, 0.001);
    }

    @Test
    public void testCalculateTotalHolidayBonus() {
        double totalBonus = HolidayBonus.calculateTotalHolidayBonus(testArray);
        assertEquals(3000.0, totalBonus, 0.001); // Adjusted based on bonus logic.
    }
}

