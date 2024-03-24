package ua.hoshion;

public class Thread_F1 extends Thread {
    @Override
    public void run() {
        System.out.println("T1 is started");

        // Initializing variables
        int[] A, B, C;
        int[][] MA, ME;

        // Entering data
        if (Lab1.N <= 4) {
            A = Data.readVectorFromKeyboard("A");
            C = Data.readVectorFromKeyboard("C");
            MA = Data.readMatrixFromKeyboard("MA");
            ME = Data.readMatrixFromKeyboard("ME");
            B = Data.readVectorFromKeyboard("B");
        } else {
            A = Data.readVectorFromFile("A");
            C = Data.readVectorFromFile("C");
            MA = Data.readMatrixFromFile("MA");
            ME = Data.readMatrixFromFile("ME");
            B = Data.readVectorFromFile("B");
        }

        // Making calculations
        int[][] MA_ME = Data.multiplyMatrices(MA, ME);
        int[] C_MA_ME = Data.multiplyVectorMatrix(MA_ME, C);
        int[] A_C_MA_ME = Data.addVectors(A, C_MA_ME);
        int[] A_C_MA_ME_B = Data.addVectors(A_C_MA_ME, B);

        // Show result
        if (Lab1.N < 4) {
            Data.printResultVector("T1", A_C_MA_ME_B);
        } else {
            Data.saveVectorToFile("T1.txt", A_C_MA_ME_B);
        }

        System.out.println("T1 is finished");
    }
}
