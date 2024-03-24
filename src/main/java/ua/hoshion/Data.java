package ua.hoshion;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Data {

    public static int[][] readMatrixFromKeyboard(String name) {
        Scanner scanner = new Scanner(System.in);
        int[][] matrix = new int[Lab1.N][Lab1.N];
        System.out.println("Enter the elements of the matrix " + name + ": ");
        for (int i = 0; i < Lab1.N; i++) {
            for (int j = 0; j < Lab1.N; j++) {
                matrix[i][j] = scanner.nextInt();
            }
        }
        return matrix;
    }

    public static int[] readVectorFromKeyboard(String name) {
        Scanner scanner = new Scanner(System.in);
        int[] vector = new int[Lab1.N];
        System.out.println("Enter the elements of the vector " + name + ": ");
        for (int i = 0; i < Lab1.N; i++) {
            vector[i] = scanner.nextInt();
        }
        return vector;
    }

    public static int[][] multiplyMatrices(int[][] matrix1, int[][] matrix2) {
        int[][] resultMatrix = new int[Lab1.N][Lab1.N];

        for (int i = 0; i < matrix1.length; i++) {
            for (int j = 0; j < matrix2[0].length; j++) {
                for (int k = 0; k < matrix1[0].length; k++) {
                    resultMatrix[i][j] += matrix1[i][k] * matrix2[k][j];
                }
            }
        }

        return resultMatrix;
    }

    public static int[] multiplyMatrixVector(int[][] matrix, int[] vector) {
        int[] resultVector = new int[Lab1.N];
        for (int i = 0; i < matrix.length; i++) {
            int sum = 0;
            for (int j = 0; j < matrix[i].length; j++) {
                sum += matrix[i][j] * vector[j];
            }
            resultVector[i] = sum;
        }
        return resultVector;
    }

    public static int[] multiplyVectorMatrix(int[][] matrix, int[] vector) {
        int[] resultVector = new int[Lab1.N];
        for (int i = 0; i < matrix[0].length; i++) {
            int sum = 0;
            for (int j = 0; j < vector.length; j++) {
                sum += vector[j] * matrix[j][i];
            }
            resultVector[i] = sum;
        }
        return resultVector;
    }

    public static int[] multiplyVectorVector(int[] vector1, int[] vector2) {
        int[] resultVector = new int[Lab1.N];
        for (int i = 0; i < vector1.length; i++) {
            resultVector[i] = vector1[i] * vector2[i];
        }
        return resultVector;
    }

    public static int[][] addMatrices(int[][] matrix1, int[][] matrix2) {
        int[][] resultMatrix = new int[Lab1.N][Lab1.N];
        for (int i = 0; i < matrix1.length; i++) {
            for (int j = 0; j < matrix1[0].length; j++) {
                resultMatrix[i][j] = matrix1[i][j] + matrix2[i][j];
            }
        }
        return resultMatrix;
    }

    public static int[] addVectors(int[] vector1, int[] vector2) {
        int[] resultVector = new int[Lab1.N];
        for (int i = 0; i < vector1.length; i++) {
            resultVector[i] = vector1[i] + vector2[i];
        }
        return resultVector;
    }

    public static int[] addMatrixVector(int[][] matrix1, int[] vector1) {
        int[] resultVector = new int[Lab1.N];
        for (int i = 0; i < matrix1.length; i++) {
            int sum = 0;
            for (int j = 0; j < vector1.length; j++) {
                sum += matrix1[i][j] + vector1[j];
            }
            resultVector[i] = sum;
        }
        return resultVector;
    }

    public static int[] addVectorMatrix(int[] vector1, int[][] matrix1) {
        int[] resultVector = new int[Lab1.N];
        for (int i = 0; i < matrix1[0].length; i++) {
            int sum = 0;
            for (int j = 0; j < vector1.length; j++) {
                sum += vector1[j] + matrix1[j][i];
            }
            resultVector[i] = sum;
        }
        return resultVector;
    }

    public static void printResultVector(String threadName, int[] vector) {
        System.out.print("Result vector for " + threadName + ": ");
        for (int value : vector) {
            System.out.print(value + " ");
        }
        System.out.println();
    }

    public static void printResultMatrix(String threadName, int[][] matrix) {
        System.out.println("Result matrix for " + threadName + ": ");
        for (int[] ints : matrix) {
            for (int j = 0; j < matrix[0].length; j++) {
                System.out.print(ints[j] + " ");
            }
            System.out.println();
        }
    }

    public static int[][] transposeMatrix(int[][] matrix) {
        int[][] resultMatrix = new int[Lab1.N][Lab1.N];
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix.length; j++) {
                resultMatrix[i][j] = matrix[j][i];
            }
        }
        return resultMatrix;
    }

    public static int[] readNumbersFromFile(int amount) {
        try {
            String fileName = "file.txt";
            List<Integer> numberList = new ArrayList<>();
            BufferedReader reader = new BufferedReader(new FileReader(fileName));
            String line;
            while ((line = reader.readLine()) != null) {
                String[] tokens = line.trim().split("\\s+");
                for (String token : tokens) {
                    numberList.add(Integer.parseInt(token));
                }
            }
            reader.close();

            // Convert list to array
            int[] numbers = new int[amount];
            for (int i = 0; i < numbers.length; i++) {
                numbers[i] = numberList.get(i);
            }
            return numbers;
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

    public static int[][] readMatrixFromFile(String name) {
        int[][] matrix = new int[Lab1.N][Lab1.N];
        System.out.println("Reading file for matrix " + name);
        for (int i = 0; i < Lab1.N; i++) {
            matrix[i] = readNumbersFromFile(Lab1.N);
        }
        return matrix;
    }

    public static int[] readVectorFromFile(String name) {
        System.out.println("Reading file for vector " + name);
        return readNumbersFromFile(Lab1.N);
    }

    public static void saveVectorToFile(String fileName, int[] vector) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileName))) {
            for (int i = 0; i < vector.length; i++) {
                writer.write(Integer.toString(vector[i]));
                writer.newLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void saveMatrixToFile(String fileName, int[][] matrix) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileName))) {
            for (int i = 0; i < matrix.length; i++) {
                for (int j = 0; j < matrix[i].length; j++) {
                    writer.write(Integer.toString(matrix[i][j]));
                    writer.write(" ");
                }
                writer.newLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
