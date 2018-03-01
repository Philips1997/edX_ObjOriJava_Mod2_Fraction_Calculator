/*************************************************************
 * edX - Microsoft DEV277x Object Oriented Programming in Java
 * Module 2 Project - FRACTION CALCULATOR
 * Author: Xiaomeng Wang
 * 3/1/2018
 * Class FRACTION
 *************************************************************/

import java.util.*;
public class Fraction {
    private int Numerator; // two private instance variables to hold the numerator and denominator as ints
    private int Denominator;

    public Fraction (int myNumerator, int myDenominator){
        if (myDenominator != 0) {
            this.Denominator = Math.abs(myDenominator);
        } else {
            throw new IllegalArgumentException("Division by zero");
        }

        if ((myDenominator * myNumerator) > 0) {
            this.Numerator = Math.abs(myNumerator);
        } else {
            this.Numerator = -1 * (Math.abs(myNumerator));
        }
    }

    public Fraction (int myNumerator){
        this (myNumerator, 1);
    }

    public Fraction (){
        this (0,1);
    }

    public int getNumerator () {
        return Numerator;
    }

    public int getDenominator () {
        return Denominator;
    }

    public String toString () {
        return Numerator + "/" + Denominator;
    }

    public double toDouble () {
        double doubleFraction = (double) Numerator/Denominator;
        return  doubleFraction;
    }

    public Fraction add (Fraction other) { // return the sum of this and other fraction
        int GCD = gcd(this.Denominator, other.Denominator);
        int commonDenominator = (this.Denominator/GCD) * other.Denominator;
        int thisNumerator = this.Numerator * other.Denominator / GCD;
        int otherNumerator = other.Numerator * this.Denominator / GCD;
        int sumNumerator = thisNumerator + otherNumerator;
        Fraction sumFraction = new Fraction (sumNumerator, commonDenominator);
        return sumFraction;
    }

    public Fraction subtract(Fraction other) { // return the difference between this and other fraction
        int GCD = gcd(this.Denominator, other.Denominator);
        int commonDenominator = (this.Denominator/GCD) * other.Denominator;
        int thisNumerator = this.Numerator * other.Denominator / GCD;
        int otherNumerator = other.Numerator * this.Denominator / GCD;
        int diffNumerator = thisNumerator - otherNumerator;
        Fraction diffFraction = new Fraction (diffNumerator, commonDenominator);
        return diffFraction;
    }

    public Fraction multiply (Fraction other) {
        int prodNumerator = this.Numerator * other.Numerator;
        int prodDenominator = this.Denominator * other.Denominator;
        Fraction prodFraction = new Fraction(prodNumerator, prodDenominator);
        return prodFraction;
    }

    public Fraction divide (Fraction other) {
        int divNumerator = this.Numerator * other.Denominator;
        int divDenominator = this.Denominator * other.Numerator;
        Fraction divFraction = new Fraction(divNumerator, divDenominator);
        return divFraction;
    }

    public boolean equals (Object other) { // determine whehter two fractions are equal
        if (other instanceof Fraction) {
            Fraction otherFraction = (Fraction) other;
            this.toLowestTerms();
            otherFraction.toLowestTerms();
            if ((this.Numerator == otherFraction.Numerator) && (this.Denominator == otherFraction.Denominator)) {
                boolean equalFraction = true;
                return equalFraction;
            } else {
                boolean equalFraction = false;
                return equalFraction;
            }
        } else {
            throw new InputMismatchException("Fraction expected");
        }
    }

    public void toLowestTerms () { // determine the lowest term of fraction
        int GCD = gcd(this.Numerator, this.Denominator);
        this.Numerator /= GCD;
        this.Denominator /= GCD;
    }

    public void toLowestTermsPrint () { // determine the lowest term of fraction
        int GCD = gcd(this.Numerator, this.Denominator);
        this.Numerator /= GCD;
        this.Denominator /= GCD;
        System.out.println(this.toString());
    }

    public int gcd (int num, int den) { // Determine the greatest common divisor of numerator and denominator
        if (den == 0){
            return Math.abs(num);
        }
        return gcd(den, num % den); // By Euclidean
    }
}
