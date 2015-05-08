package com.github.Asmohr.gcj.haircut;

import com.github.adam6806.gcj.*;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.math.BigInteger;
import java.net.URL;
import java.util.Scanner;

/**
 * Created by Adam on 4/21/2015.
 */
public class Haircut {
    private static final String FILE_NAME_LETTER = "B";
    private static final String FILE_NAME_SIZE = "small";
    private static final String FILE_NAME = FILE_NAME_LETTER + "-" + FILE_NAME_SIZE;
    private static final URL FILE_PATH = Haircut.class.getResource(FILE_NAME + "-practice.in");
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
        String test = scanner.nextLine();
        int[] stats =Helper.convertToIntArray(test.split(" "));
        int[] barberTimesOriginal = Helper.convertToIntArray(scanner.nextLine().split(" "));
        int[] barberTimes = new int[stats[0]];
        int numBarbers = stats[0];
        BigInteger position = BigInteger.valueOf(stats[1]);
        int barberUsed = 0;
        while(position.compareTo(BigInteger.ZERO) == 1){
            for (int i = 0; i < numBarbers; i++) {
                if(barberTimes[i] == 0){
                    position = position.subtract(BigInteger.ONE);
                    if(position.compareTo(BigInteger.ZERO) == 0){
                        barberUsed = i+1;
                        break;
                    }
                    barberTimes[i] = barberTimesOriginal[i];
                }
                else{
                    barberTimes[i]--;
                }
            }
        }
        
        
        
        return barberUsed + "";
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
