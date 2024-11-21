package main;

import java.io.*;
import java.util.*;

public class TwoDimRaggedArrayUtility {

    public static double[][] readFile(File file) throws FileNotFoundException {
        List<double[]> list = new ArrayList<>();
        Scanner scanner = new Scanner(file);

        while (scanner.hasNextLine()) {
            String[] line = scanner.nextLine().trim().split(" ");
            double[] row = Arrays.stream(line).mapToDouble(Double::parseDouble).toArray();
            list.add(row);
        }
        scanner.close();
        return list.toArray(new double[list.size()][]);
    }

    public static void writeToFile(double[][] data, File file) throws FileNotFoundException {
        PrintWriter writer = new PrintWriter(file);
        for (double[] row : data) {
            for (double value : row) {
                writer.print(value + " ");
            }
            writer.println();
        }
        writer.close();
    }

    public static double getTotal(double[][] data) {
        double total = 0;
        for (double[] row : data) {
            for (double value : row) {
                total += value;
            }
        }
        return total;
    }

    public static double getAverage(double[][] data) {
        int count = 0;
        double total = 0;
        for (double[] row : data) {
            count += row.length;
            for (double value : row) {
                total += value;
            }
        }
        return total / count;
    }

    public static double getRowTotal(double[][] data, int rowIndex) {
        double total = 0;
        for (double value : data[rowIndex]) {
            total += value;
        }
        return total;
    }

    public static double getColumnTotal(double[][] data, int columnIndex) {
        double total = 0;
        for (double[] row : data) {
            if (columnIndex < row.length) {
                total += row[columnIndex];
            }
        }
        return total;
    }

    public static double getHighestInRow(double[][] data, int rowIndex) {
        return Arrays.stream(data[rowIndex]).max().orElse(Double.NEGATIVE_INFINITY);
    }

    public static int getHighestInRowIndex(double[][] data, int rowIndex) {
        double max = getHighestInRow(data, rowIndex);
        for (int i = 0; i < data[rowIndex].length; i++) {
            if (data[rowIndex][i] == max) {
                return i;
            }
        }
        return -1;
    }

    public static double getLowestInRow(double[][] data, int rowIndex) {
        return Arrays.stream(data[rowIndex]).min().orElse(Double.POSITIVE_INFINITY);
    }

    public static int getLowestInRowIndex(double[][] data, int rowIndex) {
        double min = getLowestInRow(data, rowIndex);
        for (int i = 0; i < data[rowIndex].length; i++) {
            if (data[rowIndex][i] == min) {
                return i;
            }
        }
        return -1;
    }

    public static double getHighestInColumn(double[][] data, int columnIndex) {
        double max = Double.NEGATIVE_INFINITY;
        for (double[] row : data) {
            if (columnIndex < row.length) {
                max = Math.max(max, row[columnIndex]);
            }
        }
        return max;
    }

    public static int getHighestInColumnIndex(double[][] data, int columnIndex) {
        double max = getHighestInColumn(data, columnIndex);
        for (int i = 0; i < data.length; i++) {
            if (columnIndex < data[i].length && data[i][columnIndex] == max) {
                return i;
            }
        }
        return -1;
    }

    public static double getLowestInColumn(double[][] data, int columnIndex) {
        double min = Double.POSITIVE_INFINITY;
        for (double[] row : data) {
            if (columnIndex < row.length) {
                min = Math.min(min, row[columnIndex]);
            }
        }
        return min;
    }

    public static int getLowestInColumnIndex(double[][] data, int columnIndex) {
        double min = getLowestInColumn(data, columnIndex);
        for (int i = 0; i < data.length; i++) {
            if (columnIndex < data[i].length && data[i][columnIndex] == min) {
                return i;
            }
        }
        return -1;
    }

    public static double getHighestInArray(double[][] data) {
        double max = Double.NEGATIVE_INFINITY;
        for (double[] row : data) {
            for (double value : row) {
                max = Math.max(max, value);
            }
        }
        return max;
    }

    public static double getLowestInArray(double[][] data) {
        double min = Double.POSITIVE_INFINITY;
        for (double[] row : data) {
            for (double value : row) {
                min = Math.min(min, value);
            }
        }
        return min;
    }
}

