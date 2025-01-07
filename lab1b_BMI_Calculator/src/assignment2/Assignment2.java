/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package assignment2;

/**
 *
 * @author Jerome Semos: MC303 Lab assessment 2 solution
 *
 */
import java.util.Scanner;

public class Assignment2 {

    public static void main(String[] args) {
        //local variable declarations go here
        final int N = 10;
        double highestBmi = 0.0, lowestBmi = 200; //initalised to highest BMI possible recorded in real world
        int totalLow = 0, totalNormal = 0, totalHigh = 0;
        double totalBmi = 0.0, averageBmi = 0.0;

        //display welcome message and spacing before requiring user input of height & weight
        System.out.println("Welcome to Jerome's Body Mass Index (BMI) calculator application created in Java & netbeans IDE.");
        System.out.println("To use this application please enter the height (metres) and weight (kilograms) of 10 people");
        System.out.println("************************************************************************************************");

        //loop to input an individual's height and weight and calculate and display BMI, calculate summary values
        Scanner input = new Scanner(System.in);  //create a Scanner to obtain input from the command window

        //for loop used to enter 10 people height and weight.
        for (int a = 1; a <= N; ++a) {

            System.out.printf("Person number %d%s%n", a, " out of 10");

            System.out.printf("Enter your height in metres (m): "); //prompt to enter weight in KG
            double height = input.nextDouble();                        //read weight input from user

            System.out.printf("Enter your weight in kilograms (kgs): "); //prompt to enter height in metres
            double weight = input.nextDouble();                     //read height input from user

            BMICalculator bmiCalculator = new BMICalculator();   //calling the class and creating instance of bmiCalculator

            double bmi = bmiCalculator.value(weight, height);  //assign bmi to method of calculating BMI in BMICalculator class

            String classification8 = bmiCalculator.classification8(bmi);  //assign classfication8 to method selecting BMI 8 classfication

            //print each person's BMI & BMI classification per input from Java scanner 
            System.out.printf("BMI of person %d%s%.2f%s%n%n", a, " is ", bmi, classification8);

            //if loop for calculating the highest BMI of 10 people
            if (bmi > highestBmi) {
                highestBmi = bmi;
            }

            //if loop for calculating the average BMI of 10 people
            totalBmi = totalBmi + bmi;
            averageBmi = totalBmi / N;

            //if loop for calculaing the lowest BMI of 10 people
            if (bmi < lowestBmi) {
                lowestBmi = bmi;
            }

            //Switch to count BMI of categories of normal, low and high classification 3          
            String classification3 = bmiCalculator.classification3(bmi);
            switch (classification3) {
                case "Low":
                    totalLow = totalLow + 1;
                    break;
                case "Normal":
                    totalNormal = totalNormal + 1;
                    break;
                case "High":
                    totalHigh = totalHigh + 1;
                    break;
            }
        }

        //calculate and display summary of BMI program
        System.out.println("Display of summary");
        System.out.println("***************************************************");

        System.out.printf("The lowest BMI: %.2f%n", lowestBmi);
        System.out.printf("The highest BMI: %.2f%n", highestBmi);
        System.out.printf("The average BMI: %.2f%n", averageBmi);

        System.out.println("Number with low BMI: " + totalLow);
        System.out.println("Number with normal BMI: " + totalNormal);
        System.out.println("Number with high BMI: " + totalHigh);

        //display custom exit message
        System.out.println("***************************************************");
        System.out.println("Thank you for using Jerome's BMI calculator application.");

    }
}