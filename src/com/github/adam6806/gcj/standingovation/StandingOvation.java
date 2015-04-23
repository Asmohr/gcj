package com.github.adam6806.gcj.standingovation;

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
public class StandingOvation {

    private static final String FILE_NAME_LETTER = "A";
    private static final String FILE_NAME_SIZE = "large";
    private static final String FILE_NAME = FILE_NAME_LETTER + "-" + FILE_NAME_SIZE;
    private static final URL FILE_PATH = StandingOvation.class.getResource(FILE_NAME + "-practice.in");
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

        String[] input = scanner.nextLine().split(" ");
        char[] line = input[1].toCharArray();
        int numStanding = 0;
        int reqStanding;
        int peopleAtLevel;
        int friendsToBring = 0;
        for (int i = 0; i < line.length; i++) {
            reqStanding = i;
            peopleAtLevel = line[i] - 48;
            if (numStanding < reqStanding && peopleAtLevel > 0) {
                int newFriends = reqStanding - numStanding;
                friendsToBring += newFriends;
                numStanding += newFriends;
            }
            numStanding += peopleAtLevel;
        }

        return friendsToBring + "";
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
