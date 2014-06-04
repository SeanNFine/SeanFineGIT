package testMain;

import java.util.Scanner;
/**
 * Created by Sean on 6/4/2014.
 */
public class Fibonacci {
    //Testing Out creating a Fibonacci Sequence
    public static void main(String[]args) {
        //Returns values up to the degree provided
        Scanner scan=new Scanner(System.in);
        System.out.print("Please enter a degree: ");
        String input=scan.next();
        int degree=0;
        int xValue=0;
        int yValue=1;
        try {
            degree = Integer.parseInt(input.trim());
            if(degree<=0){
                throw new NumberFormatException();
            }
        } catch(NumberFormatException nfe){
            //If the entered value is not an integer, return a message to send back to the user
            System.out.println("Please enter a valid integer number that's greater than 0");
            nfe.printStackTrace();
        }

        System.out.println("Degree is: "+degree);
        //Now lets do the Fibonacci sequence

        long start=System.nanoTime();
        int zValue=0;
        if(degree>2) {
            for (int i = 2; i < degree; i++) {
                zValue = xValue + yValue;
                xValue = yValue;
                yValue = zValue;
            }
        } else {
            zValue=degree-1;
        }
        long diff=System.nanoTime()-start;
        System.out.println("Value at Degree "+degree+" is "+zValue+" and it took "+diff+" milliseconds");

        //Recursion Approach - slower, more memory intensive
        start=System.nanoTime();
        int recFiboValue=fibonacciRecursion(0,1,degree,3);
        diff=System.nanoTime()-start;
        System.out.println("Recursion value at degree "+degree+ " is "+recFiboValue+" and it took "+diff+" milliseconds");
    }

    public static int fibonacciRecursion(int x, int y, int deg, int current){
        if(deg==current){
            return x+y;
        } else{
            return fibonacciRecursion(y, x+y, deg, current+1);
        }
    }

}
