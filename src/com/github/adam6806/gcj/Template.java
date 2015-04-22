package com.github.adam6806.gcj;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.Scanner;

/**
 * Created by Adam on 4/21/2015.
 */
public class Template {
    private static final String PROJECT_NAME = "template";
    private static final String FILE_NAME = "A-large-practice";
    private static final File INPUT_FILE = new File("src\\com\\github\\adam6806\\gcj\\" + PROJECT_NAME + "\\" + FILE_NAME + ".in");
    private static final File OUTPUT_FILE = new File("src\\com\\github\\adam6806\\gcj\\" + PROJECT_NAME + "\\" + FILE_NAME + ".out");

    public static String getResult(int numCases, Scanner scanner) {
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 1; i <= numCases; i++) {
            stringBuilder.append("Case #" + i + ": " + doAlgorithm(scanner) + "\n");
        }
        return stringBuilder.toString();
    }

    public static String doAlgorithm(Scanner scanner) {

        return "";
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
