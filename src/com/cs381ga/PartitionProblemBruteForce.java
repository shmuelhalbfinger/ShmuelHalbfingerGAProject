package com.cs381ga;

/*
This class represents the brute force algorithm for the partition problem. IT only contains a method for solving the
problem, since
 */
public class PartitionProblemBruteForce extends PartitionProblem {

    //Method for finding a partition using a brute force algorithm
    public void findPartition(int[] set) {
        //These values will be used to keep track of a minimum difference in subset sums.
        //Therefore, if there is no exact solution for a given set, there will be an optimization
        int minDifference = Integer.MAX_VALUE;
        StringBuilder minDifferenceBitString = new StringBuilder();

        for (int i = 0; i < Math.pow(2, set.length)/2; i++) {
            String binary = decimalToBinary(i, set.length);
            System.out.println("Partition check for bitstring: " + binary + "= " + binaryToDecimal(binary));
            if (partitionExists(binary, set)) {
                System.out.println("Partition exists");
                return;
            }
            else {
                int temp = subsetSumDifference(binary, set);
                if (temp < minDifference) {
                    minDifference = temp;
                    minDifferenceBitString = new StringBuilder(binary);
                }
            }
        }
        System.out.println("No partition exists");
        System.out.println("The minimum difference in subset sums occurs with bitstring " + minDifferenceBitString + ". The difference is " + minDifference);
    }
}
