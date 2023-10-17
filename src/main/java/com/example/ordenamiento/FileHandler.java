package com.example.ordenamiento;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class FileHandler {

        public void writeToFile(String filename, String data) {
            try (BufferedWriter writer = new BufferedWriter(new FileWriter(filename, true))) {
                writer.write(data);
                writer.newLine();
                writer.write("--------------------");
                writer.newLine();
            } catch (IOException e) {
                e.printStackTrace();
                System.out.println("Error al escribir en el archivo: " + e.getMessage());
            }
        }


}
