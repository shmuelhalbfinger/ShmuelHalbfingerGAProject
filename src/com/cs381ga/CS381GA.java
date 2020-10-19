package com.cs381ga;

import java.io.IOException;

public class CS381GA {
    public static void main(String[] args) {
        PartitionProblemSolverBruteForce partitionProblemSolverBruteForce = new PartitionProblemSolverBruteForce();
        try {
            partitionProblemSolverBruteForce.solve("Cs381GaInput.txt",
                    "Cs381GaOutputBruteForce.txt", 23);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
