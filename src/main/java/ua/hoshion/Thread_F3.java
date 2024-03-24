package ua.hoshion;

public class Thread_F3 extends Thread {
    @Override
    public void run() {
        System.out.println("T3 is started");

        // Initializing variables
        int[] V, R, P;
        int[][] MO, MP, MS;

        // Entering data
        if (Lab1.N < 4) {
            V = Data.readVectorFromKeyboard("V");
            MO = Data.readMatrixFromKeyboard("MO");
            R = Data.readVectorFromKeyboard("R");
            MP = Data.readMatrixFromKeyboard("MP");
            P = Data.readVectorFromKeyboard("P");
            MS = Data.readMatrixFromKeyboard("MS");
        } else {
            V = Data.readVectorFromFile("V");
            MO = Data.readMatrixFromFile("MO");
            R = Data.readVectorFromFile("R");
            MP = Data.readMatrixFromFile("MP");
            P = Data.readVectorFromFile("P");
            MS = Data.readMatrixFromFile("MS");
        }

        // Making calculations
        int[] V_MO = Data.multiplyVectorMatrix(MO, V);
        int[] R_MP = Data.multiplyVectorMatrix(MP, R);
        int[][] MO_MS = Data.multiplyMatrices(MO, MS);
        int[] P_MO_MS = Data.multiplyVectorMatrix(MO_MS, P);
        int[] V_MO_R_MP = Data.addVectors(V_MO, R_MP);
        int[] V_MO_R_MP_P_MO_MS = Data.addVectors(V_MO_R_MP, P_MO_MS);

        // Show result
        if (Lab1.N < 4) {
            Data.printResultVector("T3", V_MO_R_MP_P_MO_MS);
        } else {
            Data.saveVectorToFile("T3.txt", V_MO_R_MP_P_MO_MS);
        }

        System.out.println("T3 is finished");
    }
}
