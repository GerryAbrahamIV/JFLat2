package com.company;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws IOException {
        Integer loop1;
        Boolean exit = false;
        Scanner input = new Scanner(System.in);

        while (!exit) {
            System.out.println("1. generate file txt dari data karyawan\n" +
                    "2. generate file txt dari data training\n" +
                    "3. generate file txt dari keduanya\n" +
                    "0. exit");
            loop1 = input.nextInt();
            exit = loop1.equals(0);
            if (!exit) {
                switch (loop1){
                    case 1:
                        generateFile("Lat2_Karyawan");
                        break;
                    case 2:
                        generateFile("Lat2_Training");
                        break;
                    case 3:
                        generateFile("Lat2_Karyawan");
                        generateFile("Lat2_Training");
                        break;
                }
            }
        }
    }

    private static void generateFile(String fileName) throws IOException {
        try {
            BufferedReader reader = new BufferedReader(new FileReader("C:\\Testings\\" + fileName + ".csv"));

            StringBuilder textLines = new StringBuilder();
            String line = null;
            while ((line = reader.readLine()) != null) {
                textLines.append(line).append("\n");
            }
            textLines.delete(textLines.length() - 1, textLines.length());

            File myObj = new File("C:\\Testings\\" + fileName + ".txt");
            if (myObj.createNewFile()) {
                System.out.println("File created: " + myObj.getName());
            }

            FileWriter myWriter = new FileWriter("C:\\Testings\\" + fileName + ".txt");
            myWriter.write(textLines.toString());
            myWriter.close();
            System.out.println("File berhasil di generate direktori C:/Testings/"+ fileName + ".txt");
        }
        catch (Exception e){
            System.out.println(e.getMessage());
        }
    }
}
