package com.cs381ga;

import java.io.IOException;
import java.util.Scanner;

public class CS381GA {
    public static void main(String[] args) {
        PartitionProblemSolverBruteForce partitionProblemSolverBruteForce = new PartitionProblemSolverBruteForce();
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the path and name of your input file");
        String inputFile = scanner.nextLine();
        System.out.println("Enter the path and name of the file to which you would like to write the output");
        String outputFile = scanner.nextLine();
        try {
            partitionProblemSolverBruteForce.solve(inputFile, outputFile, 23);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
