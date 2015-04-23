package com.github.adam6806.gcj.ominousomino;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

/**
 * Created by Adam on 4/21/2015.
 */
public class OminousOmino {
    private static final String FILE_NAME_LETTER = "D";
    private static final String FILE_NAME_SIZE = "small";
    private static final String FILE_NAME = FILE_NAME_LETTER + "-" + FILE_NAME_SIZE;
    private static final URL FILE_PATH = OminousOmino.class.getResource(FILE_NAME + "-practice.in");
    private static final File INPUT_FILE = new File(FILE_PATH.getPath());
    private static final File OUTPUT_FILE = new File(FILE_PATH.getPath() + ".out");
    private static final String GABRIEL = "GABRIEL";
    private static final String RICHARD = "RICHARD";

    public static String getResult(int numCases, Scanner scanner) {
        StringBuilder stringBuilder = new StringBuilder();
        System.out.println("Input file: " + FILE_NAME);
        for (int i = 1; i <= numCases; i++) {
            String result = "Case #" + i + ": " + doAlgorithm(scanner) + "\n";
            System.out.print(result);
            stringBuilder.append(result);
        }
        return stringBuilder.toString();
    }

    public static String doAlgorithm(Scanner scanner) {
        String line = scanner.nextLine();
        String[] array = line.split(" ");
        System.out.println(line);
        int k = Integer.parseInt(array[0]);
        int n = Integer.parseInt(array[1]);
        int m = Integer.parseInt(array[2]);
        String result = "";
        //Normalize where n>=m always
        if(m>n) {
            int x = n;
            n = m;
            m = x;
        }
        if(k==1) {
            result = GABRIEL;
        } else if(m==1) {
            if((n==1 && k>=2) || (n==3 && k>=2) || (n>3 && k>=3)) {
                result = RICHARD;
            } else {
                result = GABRIEL;
            }
        } else {
            Set<Integer> richardWinsIndexes = new HashSet();
            for (int i = 2; i < k; i++) {
                if(m>i) {
                    if(m%i!=0) richardWinsIndexes.add(i);
                } else {
                    if(i%m!=0) richardWinsIndexes.add(i);
                }
                if(n>i) {
                    if(n%i!=0) richardWinsIndexes.add(i);
                } else {
                    if(i%n!=0) richardWinsIndexes.add(i);
                }
            }
            if(richardWinsIndexes.contains(k)) {
                result = RICHARD;
            } else {
                result = GABRIEL;
            }
        }
        return result;
    }

    public static File getInputFile() {
        return INPUT_FILE;
    }

    public static File getOutputFile() {
        return OUTPUT_FILE;
    }

    public static void main(String[] args) {

        try {
            Scanner scanner = new Scanner(new FileReader(getInputFile()));
            PrintWriter printWriter = new PrintWriter(new FileWriter(getOutputFile()));
            int numOfCases = Integer.parseInt(scanner.nextLine());
            String answer = getResult(numOfCases, scanner);
            printWriter.write(answer);
            scanner.close();
            printWriter.flush();
            printWriter.close();
        } catch (java.io.IOException e) {
            e.printStackTrace();
        }
    }
}
