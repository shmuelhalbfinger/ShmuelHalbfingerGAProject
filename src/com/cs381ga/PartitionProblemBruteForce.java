package com.cs381ga;

/*
This class represents the brute force algorithm for the partition problem. IT only contains a method for solving the
problem, since
 */
public class PartitionProblemBruteForce extends PartitionProblem {

    //Method for finding a partition using a brute force algorithm
    public boolean partitionBruteForce(int[] set) {
        for (int i = 0; i < Math.pow(2, set.length)/2; i++) {
            String binary = decimalToBinary(i, set.length);
            System.out.println("Partition check for bitstring: " + binary + "= " + binaryToDecimal(binary));
            if (partitionExists(binary, set)) {
                System.out.println("Partition exists");
                return true;
            }
        }
        System.out.println("No partition exists");
        return false;
    }
}
