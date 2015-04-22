package com.github.adam6806.gcj.storecredit;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.Scanner;

/**
 * Created by Adam on 4/21/2015.
 */
public class StoreCredit {
    private static final String PROJECT_NAME = "storecredit";
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

    private static int[] convertToInt(String[] prices) {
        int[] intPrices = new int[prices.length];
        for (int i = 0; i < prices.length; i++) {
            intPrices[i] = Integer.parseInt(prices[i]);
        }
        return intPrices;
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
