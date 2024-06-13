package com.csuglobal.csc372;

import java.util.Scanner;

public class ProductCalculator {

    public static int calculateProduct(int[] numbers, int index) {
        // Base case
        if (index == numbers.length - 1) {
            return numbers[index];
        }
        // Recursive case
        return numbers[index] * calculateProduct(numbers, index + 1);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] numbers = new int[5];
        

        System.out.println("Enter five numbers:");
        for (int i = 0; i < 5; i++) {
            System.out.print("Number " + (i + 1) + ": ");
            numbers[i] = scanner.nextInt();
        }

        int product = calculateProduct(numbers, 0);
        
        System.out.println("The product of the five numbers is: " + product);
    }
}