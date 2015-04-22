package com.github.adam6806.gcj.storecredit;

import java.io.File;
import java.util.Scanner;

/**
 * Created by Adam on 4/21/2015.
 */
public class StoreCredit {
    private final String PROJECT_NAME = "storecredit";
    private final String FILE_NAME = "A-large-practice";
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
        int credit = Integer.parseInt(scanner.nextLine());
        int numItems = Integer.parseInt(scanner.nextLine());
        String[] strPrices = scanner.nextLine().split(" ");
        int[] prices = convertToInt(strPrices);
        int answer1 = 0;
        int answer2 = 0;
        for (int i = 0; i < numItems; i++) {
            for (int j = 0; j < numItems; j++) {
                if (i != j && credit == prices[i] + prices[j]) {
                    if (i < j) {
                        answer1 = i;
                        answer2 = j;
                    } else {
                        answer1 = j;
                        answer2 = i;
                    }
                    break;
                }
            }
        }
        String answer = (answer1 + 1) + " " + (answer2 + 1);
        return answer;
    }

    private int[] convertToInt(String[] prices) {
        int[] intPrices = new int[prices.length];
        for (int i = 0; i < prices.length; i++) {
            intPrices[i] = Integer.parseInt(prices[i]);
        }
        return intPrices;
    }

    public File getInputFile() {
        return INPUT_FILE;
    }

    public File getOutputFile() {
        return OUTPUT_FILE;
    }
}
