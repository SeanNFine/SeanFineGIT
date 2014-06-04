package testMain;

import java.util.Scanner;

/**
 * Created by Sean on 6/4/2014.
 */
public class primeCheck {
    public static void main(String[]args) {

        Scanner scan=new Scanner(System.in);
        System.out.print("Please enter a number to check for prime: ");
        String input=scan.next();
        int primeCheck=0;
        try {
            primeCheck = Integer.parseInt(input.trim());

        } catch(NumberFormatException nfe){
            //If the entered value is not an integer, return a message to send back to the user
            System.out.println("Please enter a valid integer number that's greater than 0");
            nfe.printStackTrace();
        }
        boolean isPrime=primeCheck(primeCheck);
        System.out.print("The number "+primeCheck+" is "+(isPrime?"":"not ")+"prime");
    }

    public static boolean primeCheck(int number){
        System.out.println("Mod 2 is "+number%2);
        if(number!=0 && number%2==0) return false;
        System.out.println("Checking for other values");
        for(int i=3;i*i<=number;i+=2){
            if(number%i==0){
                System.out.println("Multiplies by "+i);
                return false;
            }
        }
        return true;

    }
}
