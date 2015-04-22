package com.github.adam6806.gcj;

import java.io.File;
import java.util.Scanner;

/**
 * Created by Adam on 4/21/2015.
 */
public class Template {
    private static final String PROJECT_NAME = "template";
    private static final File INPUT_FILE = new File("src\\com\\github\\adam6806\\gcj\\"+PROJECT_NAME+"\\A-small-practice.in");
    private static final File OUTPUT_FILE = new File("src\\com\\github\\adam6806\\gcj\\"+PROJECT_NAME+"\\A-small-practice.out");

    public static String getResult(int numCases, Scanner scanner) {
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 1; i <= numCases; i++) {
            stringBuilder.append("Case #" + i + ": " + doAlgorithm(scanner) + "\n");
        }
        return stringBuilder.toString();
    }

    public static String doAlgorithm(Scanner scanner) {
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < 3; i++) {
            stringBuilder.append(scanner.nextLine() + "\n");
        }
        return stringBuilder.toString();
    }

    public static File getInputFile() {
        return INPUT_FILE;
    }

    public static File getOutputFile() {
        return OUTPUT_FILE;
    }
}
