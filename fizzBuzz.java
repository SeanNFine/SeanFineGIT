package testMain;

import java.util.Scanner;

/**
 * Created by Sean on 6/4/2014.
 */
public class fizzBuzz {
    //For every 3rd number, print fizz
    //For every 5th number, print buzz
    //For every value that matches, print "FizzBuzz"
    //Otherwise print plain

    public static void main(String[]args) {
        Scanner scan = new Scanner(System.in);
        System.out.print("Please enter a length to check for Fizz or Buzz: ");
        String input = scan.next();
        int length = 0;
        try {
            length = Integer.parseInt(input.trim());

        } catch (NumberFormatException nfe) {
            //If the entered value is not an integer, return a message to send back to the user
            System.out.println("Please enter a valid integer number that's greater than 0");
            nfe.printStackTrace();
        }
        for (int i = 0; i <=length;i++){
            if((i%3==0 || i%5==0) && i!=0){
                if(i%3==0) System.out.print("Fizz ");
                if(i%5==0) System.out.print("Buzz ");
                System.out.println();
            } else {
                System.out.println("Plain");
            }

        }
    }
}
