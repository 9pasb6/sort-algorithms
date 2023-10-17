package com.example.ordenamiento;

// Java program for implementation of Comb Sort
import java.io.*;
import java.util.Random;

public class CombSort
{
    // To find gap between elements
    public static int getNextGap(int gap)
    {
        // Shrink gap by Shrink factor
        gap = (gap*10)/13;
        if (gap < 1)
            return 1;
        return gap;
    }

    // Function to sort arr[] using Comb Sort
    public static void sort(int arr[])
    {
        int n = arr.length;

        // initialize gap
        int gap = n;

        // Initialize swapped as true to make sure that
        // loop runs
        boolean swapped = true;

        // Keep running while gap is more than 1 and last
        // iteration caused a swap
        while (gap != 1 || swapped == true)
        {
            // Find next gap
            gap = getNextGap(gap);

            // Initialize swapped as false so that we can
            // check if swap happened or not
            swapped = false;

            // Compare all elements with current gap
            for (int i=0; i<n-gap; i++)
            {
                if (arr[i] > arr[i+gap])
                {
                    // Swap arr[i] and arr[i+gap]
                    int temp = arr[i];
                    arr[i] = arr[i+gap];
                    arr[i+gap] = temp;

                    // Set swapped
                    swapped = true;
                }
            }
        }
    }

    public static void printArray(int[] arr, int n)
    {
        for (int i = 0; i < n; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.print("\n");
    }

    // Driver method
    public double combSort (int size, int limit) {
        double miliInicio = System.currentTimeMillis();

        int[] arreglo = new int[size];

        Random generadorAleatorio = new Random();

        for (int i = 0; i < arreglo.length; i++) {
            arreglo[i] = generadorAleatorio.nextInt(limit);  // Asigna un número aleatorio al elemento del arreglo.
        }

        System.out.println("Algoritmo por combsort \n");
        System.out.println("Arreglo sin ordenar");
        printArray(arreglo, arreglo.length);

        // Realizar el ordenamiento de TimSort
        sort(arreglo);

        System.out.println("Arreglo ordenado");
        printArray(arreglo, arreglo.length);

        double miliFin = System.currentTimeMillis();


        double segundos = (miliFin - miliInicio) / 1000;
        double minutos = segundos / 60;
        double horas = minutos / 60;

        System.out.println("\n");
        System.out.println("T(n) en segundos: " + segundos);
        System.out.println("T(n) en minutos: " + minutos);
        System.out.println("T(n) en horas: " + horas);

        return miliFin - miliInicio;
    }
}
/* This code is contributed by Rajat Mishra */

