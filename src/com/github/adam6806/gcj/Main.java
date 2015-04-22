package com.github.adam6806.gcj;

import com.github.adam6806.gcj.minimumscalarproject.MinimumScalarProject;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.Scanner;

public class Main {

    public static MinimumScalarProject algorithm = new MinimumScalarProject();

    public static void main(String[] args) {

        try {
            Scanner scanner = new Scanner(new FileReader(algorithm.getInputFile()));
            PrintWriter printWriter = new PrintWriter(new FileWriter(algorithm.getOutputFile()));
            int numOfCases = Integer.parseInt(scanner.nextLine());
            String answer = algorithm.getResult(numOfCases, scanner);
            printWriter.write(answer);
            scanner.close();
            printWriter.flush();
            printWriter.close();
        } catch (java.io.IOException e) {
            e.printStackTrace();
        }
    }
}
