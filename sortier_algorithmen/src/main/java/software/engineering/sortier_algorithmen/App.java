package software.engineering.sortier_algorithmen;

import java.util.Arrays;

public class App {
    public static void main(String[] args) {
        int[] daten1 = { 5, 2, 9, 0, 3 };
        int[] daten2 = { 8, 4, 7, 2, 6 };
        int[] daten3 = { 10, 3, 5, 1, 9 };

        System.out.println("Daten1 (unsortiert): " + Arrays.toString(daten1));
        System.out.println("Daten2 (unsortiert): " + Arrays.toString(daten2));
        System.out.println("Daten3 (unsortiert): " + Arrays.toString(daten3));

        Sortierer.bubbleSort(daten1);
        Sortierer.insertionSort(daten2);
        Sortierer.selectionSort(daten3);

        System.out.println("Daten1 (Bubblesort): " + Arrays.toString(daten1));
        System.out.println("Daten2 (InsertionSort): " + Arrays.toString(daten2));
        System.out.println("Daten3 (SelectionSort): " + Arrays.toString(daten3));
    }
}