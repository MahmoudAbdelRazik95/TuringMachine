/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package turingmaching;

import java.util.Arrays;
import java.util.Scanner;

/**
 *
 * @author Mahmoud
 */
public class TuringMaching {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        
        System.out.println("Enter the number of states: ");
        int numberofstates = s.nextInt();
        
        System.out.println("Enter the number of alphabets: ");
        int numberofalphabet = s.nextInt();
        
        String[] array = new String[numberofalphabet];
        for(int i=0; i<numberofalphabet; i++)
        {
            System.out.println("Enter alphabet "+((i)+1)+": ");
            array[i] = s.next();
        }
        String[] transitions = new String[numberofstates * numberofalphabet];
        for(int i=0; i< transitions.length; i++)
        {
            System.out.println("Enter transition "+((i)+1)+": ");
            String input = s.next();
            if (input.length() == 9)
            {
                if (input.charAt(1) == ',' && input.charAt(3) == ',' && input.charAt(5) == ',' && input.charAt(7) == ',')
                {
                   transitions[i] = input;
                }
                else
                {
                    System.out.println("\nPlease enter 5 states seperated by commas!!!\n");
                    i--;
                }
            }
            else
            {
                System.out.println("\nPlease enter 5 states seperated by commas!!!\n");
                i--;
            }
        }
        
        System.out.println("Enter initial configuration: ");
        String input2 = s.next();
        int initialState = 0;
        String tape = "";
        if (input2.charAt(1) == ',')
        {  
            String[] temp = input2.split(",");
            initialState = Integer.parseInt(temp[0]);
            tape = temp[1];
        }
        else
        {
            initialState = Integer.parseInt(input2.substring(0,1));
            tape = input2.substring(1);
        }
        
        System.out.println("Enter position of the head: ");
        int head = (s.nextInt()-1);
        Run run = new Run(numberofstates,array,transitions,initialState,tape,head);
        run.output();
        //run.print();
    }
    
}
