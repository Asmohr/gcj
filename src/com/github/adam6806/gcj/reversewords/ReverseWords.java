package com.github.adam6806.gcj.reversewords;

import java.io.File;
import java.util.Scanner;

/**
 * Created by Adam on 4/21/2015.
 */
public class ReverseWords {
    private final String PROJECT_NAME = "reversewords";
    private final String FILE_NAME = "B-large-practice";
    private final File INPUT_FILE = new File("src\\com\\github\\adam6806\\gcj\\" + PROJECT_NAME + "\\" + FILE_NAME + ".in");
    private final File OUTPUT_FILE = new File("src\\com\\github\\adam6806\\gcj\\" + PROJECT_NAME + "\\" + FILE_NAME + ".out");

    public String getResult(int numCases, Scanner scanner) {
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 1; i <= numCases; i++) {
            stringBuilder.append("Case #" + i + ": " + doAlgorithm(scanner) + "\n");
        }
        return stringBuilder.toString();
    }

    public String doAlgorithm(Scanner scanner) {
        String[] words = scanner.nextLine().split(" ");
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = words.length-1; i >= 0; i--) {
            stringBuilder.append(words[i] + " ");
        }
        return stringBuilder.toString();
    }

    public File getInputFile() {
        return INPUT_FILE;
    }

    public File getOutputFile() {
        return OUTPUT_FILE;
    }
}
