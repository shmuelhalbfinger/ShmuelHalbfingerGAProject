package com.cs381ga;

public class Cs381Ga {

    public static String decimalToBinary(int decimal, int n) {
        if (decimal < 0) return "Number must be positive. Please enter a positive integer and try again";
        StringBuilder binaryRev = new StringBuilder();
        while (decimal > 0) {
            if (decimal % 2 == 1) binaryRev.append("1");
            else binaryRev.append("0");
            n--;
            decimal /= 2;
        }
        for (int i = 1; i <=n; i++) {
            binaryRev.append("0");
        }
        StringBuilder binary = binaryRev.reverse();
        return binary.toString();
    }

    public static void partitionExhaustiveSearch(int[] set) {
        for (int i = 0; i < Math.pow(2, set.length)/2; i++) {
            String binary = decimalToBinary(i, set.length);
            System.out.println("Partition check for bitstring: " + binary);
            if (partitionExists(binary, set)) {
                System.out.println("Partition exists");
                return;
            }
        }
        System.out.println("No partition exists");
    }

    private static boolean partitionExists(String binary, int[] set) {
        int sumSubset1 = 0;
        int sumSubset2 = 0;
        for (int i = 0; i < binary.length(); i++) {
            if (binary.charAt(i) == '0') sumSubset1 += set[i];
            else if (binary.charAt(i) == '1') sumSubset2 += set[i];
        }
        return sumSubset1 == sumSubset2;

    }

    public static void main(String[] args) {
	int [] set = {4,56,2,3,4,5};
	partitionExhaustiveSearch(set);
    }
}
