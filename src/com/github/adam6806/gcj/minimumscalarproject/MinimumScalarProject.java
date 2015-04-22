package com.github.adam6806.gcj.minimumscalarproject;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.math.BigInteger;
import java.net.URL;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

/**
 * Created by Adam on 4/21/2015.
 */
public class MinimumScalarProject {
    private static final String FILE_NAME = "A-large-practice.in";
    private static final URL FILE_PATH = MinimumScalarProject.class.getResource(FILE_NAME);
    private static final File INPUT_FILE = new File(FILE_PATH.getPath());
    private static final File OUTPUT_FILE = new File(FILE_PATH.getPath() + ".out");

    public static String getResult(int numCases, Scanner scanner) {
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 1; i <= numCases; i++) {
            System.out.println("Performing algorithm on Case #" + i);
            stringBuilder.append("Case #" + i + ": " + doAlgorithm(scanner) + "\n");
        }
        return stringBuilder.toString();
    }

    public static String doAlgorithm(Scanner scanner) {
        int vectorLength = Integer.parseInt(scanner.nextLine());
        ArrayList<BigInteger> numArray1 = convertToInt(scanner.nextLine().split(" "));
        Collections.sort(numArray1);
        ArrayList<BigInteger> numArray2 = convertToInt(scanner.nextLine().split(" "));
        Collections.sort(numArray2);
        Collections.reverse(numArray2);
        BigInteger total = BigInteger.valueOf(0);
        for (int i = 0; i < vectorLength; i++) {
            BigInteger num1 = numArray1.get(i);
            BigInteger num2 = numArray2.get(i);
            BigInteger num3 = num1.multiply(num2);
            total = total.add(num3);
        }

        return total.toString();
    }

    private static ArrayList<BigInteger> convertToInt(String[] nums) {
        ArrayList<BigInteger> numList = new ArrayList<BigInteger>();
        for (int i = 0; i < nums.length; i++) {
            numList.add(BigInteger.valueOf(Integer.parseInt(nums[i])));
        }
        return numList;
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
