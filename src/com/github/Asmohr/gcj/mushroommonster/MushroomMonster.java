package com.github.Asmohr.gcj.mushroommonster;

import com.github.adam6806.gcj.*;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.net.URL;
import java.util.Scanner;

/**
 * Created by Adam on 4/21/2015.
 */
public class MushroomMonster {
    private static final String FILE_NAME_LETTER = "A";
    private static final String FILE_NAME_SIZE = "large";
    private static final String FILE_NAME = FILE_NAME_LETTER + "-" + FILE_NAME_SIZE;
    private static final URL FILE_PATH = MushroomMonster.class.getResource(FILE_NAME + "-practice.in");
    private static final File INPUT_FILE = new File(FILE_PATH.getPath());
    private static final File OUTPUT_FILE = new File(FILE_PATH.getPath() + ".out");

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
        Integer length = Integer.parseInt(scanner.nextLine());
        String testCase = scanner.nextLine();
        int[] splitCases =Helper.convertToIntArray(testCase.split(" "));
        int total1 = 0;
        int total2 = 0;
        int biggestDiff = 0;
        for (int i = 0; i < length-1; i++) {
            if(splitCases[i+1]<splitCases[i]){
                total1+=splitCases[i]-splitCases[i+1];
                if(splitCases[i]-splitCases[i+1] > biggestDiff){
                    biggestDiff = splitCases[i]-splitCases[i+1];
                }
            }
        }
        for (int i = 0; i < length-1; i++) {
            if((splitCases[i]-biggestDiff)<0){
                total2+=splitCases[i];
            }
            else{
                total2+=biggestDiff;
            }
        }
        return total1 + " " + total2;
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
