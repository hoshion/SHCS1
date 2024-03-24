package ua.hoshion;

public class Thread_F2 extends Thread {
    @Override
    public void run() {
        System.out.println("T2 is started");

        // Initializing variables
        int[][] MG, MH, MK;

        // Entering data
        if (Lab1.N < 4) {
            MG = Data.readMatrixFromKeyboard("MG");
            MH = Data.readMatrixFromKeyboard("MH");
            MK = Data.readMatrixFromKeyboard("MK");
        } else {
            MG = Data.readMatrixFromFile("MG");
            MH = Data.readMatrixFromFile("MH");
            MK = Data.readMatrixFromFile("MK");
        }

        // Making calculations
        int[][] MG_MH = Data.multiplyMatrices(MG, MH);
        int[][] TMK = Data.transposeMatrix(MK);
        int[][] MG_MH_TMK = Data.multiplyMatrices(MG_MH, TMK);

        // Show result
        if (Lab1.N < 4) {
            Data.printResultMatrix("T2", MG_MH_TMK);
        } else {
            Data.saveMatrixToFile("T2.txt", MG_MH_TMK);
        }

        System.out.println("T2 is finished");
    }
}
