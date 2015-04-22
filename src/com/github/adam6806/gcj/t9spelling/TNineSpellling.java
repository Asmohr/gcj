package com.github.adam6806.gcj.t9spelling;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.net.URL;
import java.util.HashMap;
import java.util.Scanner;

/**
 * Created by Adam on 4/21/2015.
 */
public class TNineSpellling {
    private static final String FILE_NAME = "C-large-practice.in";
    private static final URL FILE_PATH = TNineSpellling.class.getResource(FILE_NAME);
    private static final File INPUT_FILE = new File(FILE_PATH.getPath());
    private static final File OUTPUT_FILE = new File(FILE_PATH.getPath() + ".out");

    public static String getResult(int numCases, Scanner scanner) {
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 1; i <= numCases; i++) {
            stringBuilder.append("Case #" + i + ": " + doAlgorithm(scanner) + "\n");
        }
        return stringBuilder.toString();
    }

    public static String doAlgorithm(Scanner scanner) {
        char[] words = scanner.nextLine().toCharArray();
        StringBuilder stringBuilder = new StringBuilder();
        HashMap<Character, String> keyMap = getKeyPadMap();
        char lastNumber = '!';
        for (int i = 0; i < words.length; i++) {
            char c = words[i];
            String num = keyMap.get(c);
            char numFirstChar = num.charAt(0);
            if(lastNumber == numFirstChar) {
                lastNumber = numFirstChar;
                num = " " + num;
            } else {
                lastNumber = numFirstChar;
            }

            stringBuilder.append(num);
        }
        return stringBuilder.toString();
    }

    public static HashMap<Character, String> getKeyPadMap() {
        HashMap<Character, String> keyMap = new HashMap<Character, String>();
        keyMap.put('a', "2");
        keyMap.put('b', "22");
        keyMap.put('c', "222");
        keyMap.put('d', "3");
        keyMap.put('e', "33");
        keyMap.put('f', "333");
        keyMap.put('g', "4");
        keyMap.put('h', "44");
        keyMap.put('i', "444");
        keyMap.put('j', "5");
        keyMap.put('k', "55");
        keyMap.put('l', "555");
        keyMap.put('m', "6");
        keyMap.put('n', "66");
        keyMap.put('o', "666");
        keyMap.put('p', "7");
        keyMap.put('q', "77");
        keyMap.put('r', "777");
        keyMap.put('s', "7777");
        keyMap.put('t', "8");
        keyMap.put('u', "88");
        keyMap.put('v', "888");
        keyMap.put('w', "9");
        keyMap.put('x', "99");
        keyMap.put('y', "999");
        keyMap.put('z', "9999");
        keyMap.put(' ', "0");
        return keyMap;
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
