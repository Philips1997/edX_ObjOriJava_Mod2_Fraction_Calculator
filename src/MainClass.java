/*************************************************************
 * edX - Microsoft DEV277x Object Oriented Programming in Java
 * Module 2 Project - FRACTION CALCULATOR
 * Author: Xiaomeng Wang
 * 3/1/2018
 * Class FractionCalculator
 * User enters operand and two fractions on separate lines
 * Program returns result
 * Allowed operations are addition, subtraction, multiplication, division
 * and equals, which checks if fractions are equal.
 *************************************************************/

import java.util.*;

public class MainClass {
    public static final Scanner input = new Scanner(System.in);

    public static void main(String args[]) {
        System.out.println("This program is fraction calculator");
        System.out.println("It will add, subtract, multiply and divide fractions until you type Q to quit");
        System.out.println("-------------------------------------------------------------------------------");

        while (true) {
            String operation = getOperation();
            Fraction fracA = getFraction();
            Fraction fracB = getFraction();
            if (operation.equals("+")) {
                Fraction sumFrac = fracA.add(fracB);
                sumFrac.toLowestTermsPrint();
            } else if (operation.equals("-")) {
                Fraction diffFrac = fracA.subtract(fracB);
                diffFrac.toLowestTermsPrint();
            } else if (operation.equals("*")) {
                Fraction prodFrac = fracA.multiply(fracB);
                prodFrac.toLowestTermsPrint();
            } else if (operation.equals("/")) {
                Fraction divFrac = fracA.divide(fracB);
                divFrac.toLowestTermsPrint();
            } else if (operation.equals("=")) {
                boolean eqFrac = fracA.equals(fracB);
                if (eqFrac) {
                    System.out.println("These two fractions are equal to each other.");
                } else {
                    System.out.println("These two fractions are equal to each other.");
                }
            }
        }

    }

    public static String getOperation() {
        System.out.print("Please enter an operation (+, -, *, /, =, or Q to quit): ");
        String operation = input.next();
        while (!((operation.equals("+")) || (operation.equals("-")) || (operation.equals("*")) ||
                (operation.equals("/")) || (operation.equals("=")) || (operation.equals("Q")))) {
            System.out.print("Please enter an operation (+, -, *, /, =, or Q to quit): ");
            operation = input.next();
        }
        if (operation.equals("Q")) {
            System.exit(0);
        } else {
            return operation;
        }
        return operation;
    }

    public static boolean validFraction(String input) {
        boolean validity = false;
        if (input.contains("/")) {
            String[] fracInput = input.split("/");
            if (fracInput.length == 2) {
                if ((validInteger(fracInput[0])) && ((validInteger(fracInput[0])))) {
                    validity = true;
                } else {
                    validity = false;
                }
            } else {
                validity = false;
            }
        } else if (input.length() == 0) {
            validity = true;
        } else {
            validity = validInteger(input);
        }
        return validity;
    }

    public static boolean validInteger(String input) {
        try {
            Integer.parseInt(input);
        } catch (NumberFormatException e) {
            return false;
        }
        return true;
    }

    public static Fraction getFraction() {
        System.out.print("Please enter a fraction (a/b) or integer (a): ");
        String inputFrac = input.next();
        Fraction myFrac = new Fraction(0,1);
        while (!validFraction(inputFrac)) {
            System.out.print("Invalid fraction. Please enter (a/b) or (a), where a and b are integers and b is not a zero: ");
            inputFrac = input.next();
        }
            if (inputFrac.contains("/")) {
                String[] numDen = inputFrac.split("/");
                int num = Integer.parseInt(numDen[0]);
                int den = Integer.parseInt(numDen[1]);
                myFrac = new Fraction(num, den);
                return myFrac;
            } else if (inputFrac.length() == 0) {
                myFrac = new Fraction(0);
                return myFrac;
            } else {
                myFrac = new Fraction(Integer.parseInt(inputFrac));
                return myFrac;
            }
        }
    }