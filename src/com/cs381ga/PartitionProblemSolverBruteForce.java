package com.cs381ga;

import java.io.*;

/*
This class represents the brute force algorithm for the partition problem. IT only contains a method for solving the
problem, since
 */
public class PartitionProblemSolverBruteForce extends PartitionProblemSolver {

    //Method for finding a partition using a brute force algorithm
    //Method will take in an inputFile name to get the input for the set
    //Method will take in an outputFile name to write the output
    //Method will take in a set size to instantiate an array to represent the set
    public void solve(String inputFile, String outputFile, int setSize) throws IOException {
        int[] set = new int[setSize];

        BufferedReader reader = new BufferedReader(new FileReader(inputFile));

        String line = reader.readLine();
        int index = 0;
        while (line != null) {
            set[index] = Integer.parseInt(line);
            line = reader.readLine();
            index++;
        }
        reader.close();

        File output = new File(outputFile);

        FileWriter writer = new FileWriter(outputFile);
        writer.write("Output of Partition Problem with input from " + inputFile + "\n");
        writer.write("Bitstrings will be used to represent partitioning of element of the set into two subsets, set 0 and set 1\n");
        writer.write("The sums of the subsets are calculated and compared\n\n");
        //These values will be used to keep track of a minimum difference in subset sums.
        //Therefore, if there is no exact solution for a given set, there will be an optimization
        int minDifference = Integer.MAX_VALUE;
        StringBuilder minDifferenceBitString = new StringBuilder();

        for (int i = 0; i < Math.pow(2, set.length) / 2; i++) {
            String binary = decimalToBinary(i, set.length);
            writer.write("Partition check #" + binaryToDecimal(binary) + ". Bitstring: " + binary + "\n");
            if (partitionExists(binary, set)) {
                writer.write("Partition exists!");
                writer.close();
                return;
            } else {
                writer.write("Partition doesn't exist.\n");
                int difference = subsetSumDifference(binary, set);
                writer.write("Difference in subset sums: " + difference + "\n\n");
                if (difference < minDifference) {
                    minDifference = difference;
                    minDifferenceBitString = new StringBuilder(binary);
                }
            }
        }
        writer.write("No partition exists\n");
        writer.write("Minimum difference:\n Bitstring: " + minDifferenceBitString + ".\nDifference: " + minDifference + "\n");
        writer.close();
    }
}
