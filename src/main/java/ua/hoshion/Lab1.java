/*
* Лабораторна робота ЛР1 Варіант 21
* F1: E  = A + C*(MA*ME) + B
* F2: MF = (MG*MH)*TRANS(MK)
* F3: S  = V*MO + R*MP + P*(MO*MS)
* Шестеров С. ІМ-12
* Дата 27.02.2024
* */

package ua.hoshion;

public class Lab1 {

    public static int N = 1001;
    public static void main(String[] args) {

        // Waiting 10 seconds for changing cores amount in Task Manager
        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // Saving information about start time of program
        long startTime = System.currentTimeMillis();

        // Initializing threads
        Thread_F1 T1 = new Thread_F1();
        Thread_F2 T2 = new Thread_F2();
        Thread_F3 T3 = new Thread_F3();

        // Starting threads
        T1.start();
        T2.start();
        T3.start();

        // Making main thread wait for other child threads
        try {
            T1.join();
            T2.join();
            T3.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // Saving information about end time of program
        long endTime = System.currentTimeMillis();
        long elapsedTime = endTime - startTime;

        // Showing info about taken time
        System.out.println("Time taken: " + elapsedTime + " nanoseconds");
    }
}