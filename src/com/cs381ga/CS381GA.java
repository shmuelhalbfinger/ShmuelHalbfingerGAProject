package com.cs381ga;

public class CS381GA {
    public static void main(String[] args) {
        PartitionProblemBruteForce phase1 = new PartitionProblemBruteForce();
        int [] test = {52,48,65,43,71,70,43,67,54,61};
        phase1.findPartition(test);
    }
}
