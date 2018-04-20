/*
 ISYS 320
 Name: Mansour Albaibi
 Date: 21-4-2018
*/

import java.util.Scanner;

public class P1_FindMinAndMax {

 public static void main(String[] args) {
        Scanner console = new Scanner( System.in );
        
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        
        // YOUR CODE STARTS HERE
        int number = 0;
        System.out.println("Type a number (or -1 to stop):");

        for(int counter = 0; number!=-1;counter++) {
            number = console.nextInt();
            if(number!=-1)
            if(number < min)
                min = number;
            else if(number > max)
                max = number;
        }


        // YOUR CODE ENDS HERE
        
        System.out.println( "Maximum was " + max );
        System.out.println( "Minimum was " + min );
    }

}