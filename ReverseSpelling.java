package testMain;

import java.util.Scanner;

/**
 * Created by Sean on 6/4/2014.
 */
public class ReverseSpelling {
    public static void main(String[]args) {

        Scanner scan=new Scanner(System.in);
        System.out.print("Please enter a Word to be Reversed: ");
        String word=scan.next();
        //Less Garbage Collection Route. However, has a o(n) time length
        long start=System.nanoTime();

        StringBuffer sb=new StringBuffer();
        for(int i=word.length()-1; i>=0;i--){
            sb.append(word.charAt(i));
        }
        long diff=System.nanoTime()-start;
        System.out.println("String Buffer word is " +sb.toString()+" and took "+diff+" milliseconds.");

        //Route with o(n/2) length - Seems to be SUPER inefficient
        start=System.nanoTime();
        char[] revChars=new char[word.length()];
        int wordLength=Math.floorDiv(word.length(), 2);
        System.out.println("Word's half length is "+wordLength);
        for(int i=0;i<wordLength;i++){
            char firstChar=word.charAt(i);
            char lastChar=word.charAt(word.length()-1-i);
            revChars[i]=lastChar;
            revChars[word.length()-1-i]=firstChar;
        }
        if(word.length()%2!=0){
            int middleD=(int)Math.ceil(word.length()/2);
            revChars[middleD]=word.charAt(middleD);
        }
        diff=System.nanoTime()-start;
        System.out.println("String is "+new String(revChars)+" and took "+diff+" milliseconds");

        //Simple route - Definately the simplest way
        start=System.nanoTime();
        String revWord=new StringBuilder(word).reverse().toString();
        diff=System.nanoTime()-start;
        System.out.println("Simple Reverse Word is "+revWord+" and took "+diff+" milliseconds");
    }
}
