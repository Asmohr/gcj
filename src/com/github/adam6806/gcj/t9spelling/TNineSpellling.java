package com.github.adam6806.gcj.t9spelling;

import java.io.File;
import java.util.HashMap;
import java.util.Scanner;

/**
 * Created by Adam on 4/21/2015.
 */
public class TNineSpellling {
    private final String PROJECT_NAME = "t9spelling";
    private final String FILE_NAME = "C-large-practice";
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

    public HashMap<Character, String> getKeyPadMap() {
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

    public File getInputFile() {
        return INPUT_FILE;
    }

    public File getOutputFile() {
        return OUTPUT_FILE;
    }
}
