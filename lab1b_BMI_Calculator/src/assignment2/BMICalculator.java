/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package assignment2;

/**
 *
 * @author Jerome Semos
 */
public class BMICalculator {

    public BMICalculator() {
        //no code required
    }
    
    //method to calculate and return BMI 
    public double value(double weight, double height) {        
        double bmi = weight / (height * height);

        return bmi; //return BMI
    }

    public String classification8(double bmi) {

        String classification8;

        //Loop to test BMI against the 8 categories of BMI and return correct bmi classification
        if (bmi < 15.9) 
        {
            classification8 = " which is very severely underweight";
        } else if (bmi >= 16 && bmi < 16.9) {
            classification8 = " which is severely underweight";
        } else if (bmi >= 17 && bmi < 18.4) {
            classification8 = " which is underweight";
        } else if (bmi >= 18.5 && bmi < 24.9) {
            classification8 = " which is normal (Healthy)";
        } else if (bmi >= 25 && bmi < 29.9) {
            classification8 = " which is overweight (Pre-Obese)";
        } else if (bmi >= 30 && bmi < 34.9) {
            classification8 = " which is moderately obese (Obese Class I)";
        } else if (bmi >= 35 && bmi < 39.9) {
            classification8 = " which is severely obese (obeses Class II)";
        } else {
            classification8 = " which is very servely obese (obeses Class III)";
        }

        return classification8; //return the corrent category from the 8 categories (Wikipedia) classifcation of BMI
    }

    public String classification3(double bmi) {

        String classification3;
        
        //Loop to test BMI against the 3 categories of BMI and return correct classification
        if (bmi <= 18.5) {
            classification3 = "Low";
        } else if (bmi > 18.5 && bmi <= 25) {
            classification3 = "Normal";
        } else {
            classification3 = "High";
        }

        return classification3; //return the 3 categories (high, normal, low) classification of BMI 
    }
}