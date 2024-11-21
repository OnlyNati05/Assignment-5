package main;

import org.junit.Test;
import org.junit.Before;
import static org.junit.Assert.*;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class TwoDimRaggedArrayUtilityTestStudent {

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
    public void testReadFileAndWriteToFile() throws IOException {
        File file = new File("test.txt");
        try (FileWriter writer = new FileWriter(file)) {
            writer.write("1.5 2.0 3.0\n4.5 5.5\n6.0 7.0 8.0 9.0");
        }
        double[][] result = TwoDimRaggedArrayUtility.readFile(file);
        assertArrayEquals(testArray, result);

        File outputFile = new File("output.txt");
        TwoDimRaggedArrayUtility.writeToFile(testArray, outputFile);
        double[][] writtenResult = TwoDimRaggedArrayUtility.readFile(outputFile);
        assertArrayEquals(testArray, writtenResult);

        file.delete();
        outputFile.delete();
    }

    @Test
    public void testGetTotal() {
        assertEquals(46.5, TwoDimRaggedArrayUtility.getTotal(testArray), 0.001);
    }

    @Test
    public void testGetAverage() {
        assertEquals(5.8125, TwoDimRaggedArrayUtility.getAverage(testArray), 0.001);
    }

    @Test
    public void testGetHighestInArray() {
        assertEquals(9.0, TwoDimRaggedArrayUtility.getHighestInArray(testArray), 0.001);
    }

    @Test
    public void testGetLowestInArray() {
        assertEquals(1.5, TwoDimRaggedArrayUtility.getLowestInArray(testArray), 0.001);
    }
}

