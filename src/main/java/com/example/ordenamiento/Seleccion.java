package com.example.ordenamiento;


import java.util.Random;

public class Seleccion {

    public double seleccionSort (int size, int limit) {
        double miliInicio = System.currentTimeMillis();

        int[] arreglo = new int[size];

        Random generadorAleatorio = new Random();

        for (int i = 0; i < arreglo.length; i++) {
            arreglo[i] = generadorAleatorio.nextInt(limit);  // Asigna un número aleatorio al elemento del arreglo.
        }

        System.out.println("Algoritmo por selección \n");

        System.out.println("Arreglo sin ordenar");
        printArray(arreglo, arreglo.length);

        // Realizar el ordenamiento de TimSort
        seleccion(arreglo);

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

    public static void printArray(int[] arr, int n)
    {
        for (int i = 0; i < n; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.print("\n");
    }
    public static  void seleccion (int arreglo[] )
    {
        int i, j, k, menor;
        i = 0;
        while( i < arreglo.length - 1)
        {
            menor = arreglo [i];
            k = i;
            for( j = i+1; j < arreglo.length; j++)
            {

                if (arreglo [j] < menor )
                {

                    menor = arreglo [j];
                    k = j;

                }

            }
            arreglo [k] = arreglo[i];
            arreglo [i] = menor;
            i++;
        }
    }

}

