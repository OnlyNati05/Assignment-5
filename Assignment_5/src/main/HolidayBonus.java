/*
* Class: CMSC203
* Instructor: Ahmed Tarek
* Description: This is the Holiday Bonus Class
* Due: 11/15/2025
* Platform/compiler: Eclipsr
* I pledge that I have completed the programming
* assignment independently. I have not copied the code
* from a student or any source. I have not given my code
* to any student.
Print your Name here: Natnael Abebe */

package main;

public class HolidayBonus {

    private static final double HIGH_BONUS = 5000.0;
    private static final double LOW_BONUS = 1000.0;
    private static final double OTHER_BONUS = 2000.0;

    public static double[] calculateHolidayBonus(double[][] data) {
        double[] bonuses = new double[data.length];

        for (int i = 0; i < data.length; i++) {
            for (int j = 0; j < data[i].length; j++) {
                double value = data[i][j];
                if (value == TwoDimRaggedArrayUtility.getHighestInColumn(data, j)) {
                    bonuses[i] += HIGH_BONUS;
                } else if (value == TwoDimRaggedArrayUtility.getLowestInColumn(data, j)) {
                    bonuses[i] += LOW_BONUS;
                } else {
                    bonuses[i] += OTHER_BONUS;
                }
            }
        }
        return bonuses;
    }

    public static double calculateTotalHolidayBonus(double[][] data) {
        double[] bonuses = calculateHolidayBonus(data);
        double total = 0;
        for (double bonus : bonuses) {
            total += bonus;
        }
        return total;
    }
}

