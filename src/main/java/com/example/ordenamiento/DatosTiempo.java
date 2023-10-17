package com.example.ordenamiento;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;


public class DatosTiempo implements Comparable<DatosTiempo> {

    private String name;
    private int size;
    private int limit;
    private double segundos;
    private double minutos;
    private double horas;

    // Constructor
    public DatosTiempo(String name,int size, int limit, double segundos, double minutos, double horas) {

        this.name = name;
        this.size = size;
        this.limit = limit;
        this.segundos = segundos;
        this.minutos = minutos;
        this.horas = horas;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public int getLimit() {
        return limit;
    }

    public void setLimit(int limit) {
        this.limit = limit;
    }

    public double getSegundos() {
        return segundos;
    }

    public void setSegundos(double segundos) {
        this.segundos = segundos;
    }

    public double getMinutos() {
        return minutos;
    }

    public void setMinutos(double minutos) {
        this.minutos = minutos;
    }

    public double getHoras() {
        return horas;
    }

    public void setHoras(double horas) {
        this.horas = horas;
    }

    public static DatosTiempo fromString(String data) {
        String[] lines = data.split("\n");
        if (lines.length >= 6) {

            String name = lines[0].substring(lines[0].indexOf(":") + 1).trim();
            int size = Integer.parseInt(lines[1].substring(lines[1].indexOf(":") + 1).trim());
            int limit = Integer.parseInt(lines[2].substring(lines[2].indexOf(":") + 1).trim());
            double segundos = Double.parseDouble(lines[3].substring(lines[3].indexOf(":") + 1).trim());
            double minutos = Double.parseDouble(lines[4].substring(lines[4].indexOf(":") + 1).trim());
            double horas = Double.parseDouble(lines[5].substring(lines[5].indexOf(":") + 1).trim());
            return new DatosTiempo(name, size, limit, segundos, minutos, horas);
        } else {
            // Manejar un formato de cadena incorrecto o incompleto aquí
            // En lugar de devolver null, podrías arrojar una excepción o manejar el error de otra manera.
            return null;
        }
    }

    // para mostrar los datos sin ordenar
    public static List<DatosTiempo> readDatosTiemposFromFile(String filePath) {
        List<DatosTiempo> datosTiemposList = new ArrayList<>();

        try {
            // Leer el contenido del archivo
            String fileContent = Files.readString(Path.of(filePath));

            // Dividir el contenido en objetos usando las líneas de guiones
            String[] objetos = fileContent.split("--------------------");

            // Crear instancias de DatosTiempo a partir de cada objeto
            for (String objeto : objetos) {
                objeto = objeto.trim(); // Eliminar espacios en blanco al principio y al final
                if (!objeto.isEmpty()) {
                    DatosTiempo datosTiempo = DatosTiempo.fromString(objeto);
                    datosTiemposList.add(datosTiempo);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return datosTiemposList;
    }


    // para mostrar los datos organizados de mayor a menor

    @Override
    public int compareTo(DatosTiempo otro) {
        // Comparar por el tiempo en segundos
        return Double.compare(otro.getSegundos(), this.getSegundos());
    }

    // ...

    // Método para ordenar la lista de DatosTiempo de mayor a menor
    public static void ordenarPorSegundosDescendente(List<DatosTiempo> listaDatosTiempo) {
        listaDatosTiempo.sort(Comparator.naturalOrder());
    }



}

