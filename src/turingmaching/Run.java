/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package turingmaching;

import java.util.ArrayList;
import java.util.Arrays;

/**
 *
 * @author Mahmoud
 */
public class Run {

    private int numberofstates;
    private String[] alphabet;
    private String[] transitions;
    private int initialstate;
    private String tape;
    private int headposition;
    private int flag;
    private String finalTape;
    ArrayList<String> states = new ArrayList<String>();
    
    public Run(int numberofstates, String[] alphabet,String[] transitions,int initialstate,String tape,int headposition){
        this.numberofstates = numberofstates;
        this.alphabet = alphabet;
        this.transitions = transitions;
        this.initialstate = initialstate;
        this.tape = tape;
        this.headposition = headposition;
        flag = 0;
        finalTape = "";
    }
    
    public void output()
    {
        
        for (int i = 0; i < numberofstates ; i++)
        {
            String temp = "S" + i;
            states.add(temp);
        }
        
        char initialAlphabet = this.tape.charAt(this.headposition);
        compute(this.initialstate,initialAlphabet,this.headposition);
    }
    
    private void compute(int currentState, char currentAlphabet, int headpos)
    {
        System.out.println("tape = " +this.tape + " Current State = " + currentState + " Current Alphabet = " + currentAlphabet + " Head Position = " + (headpos+1));
        for(int i = 0; i < this.transitions.length ; i++)
            {
                /*System.out.println(this.transitions[i].charAt(0));
                System.out.println(currentState);
                System.out.println(this.transitions[i].charAt(2));
                System.out.println(currentAlphabet);*/
                if(currentState == (this.transitions[i].charAt(0)-'0') && currentAlphabet == this.transitions[i].charAt(2))
                {
                    int nextState = this.transitions[i].charAt(4)-48;
                    
                    if (headpos < 0)
                    {
                        System.out.println("Error!!!");
                    }
                    else if (headpos == 0)
                    {
                        this.tape = this.transitions[i].charAt(6) + this.tape.substring(1);
                    }
                    else if(headpos != 0)
                    {
                        String x1 = this.tape.substring(0,headpos);
                        char x2 = this.transitions[i].charAt(6);
                        String x3 = this.tape.substring(headpos+1);
                        System.out.println("X1 = "+x1+ " X2 = "+x2+" x3 = "+x3);
                        this.tape = x1 + x2 + x3;
                    }
                    
                    if(this.transitions[i].charAt(8) == 'R')
                    {
                        headpos++;
                        if (headpos == (this.tape.length()))
                        {
                            this.tape = this.tape + "#";
                        }
                        compute(nextState,this.tape.charAt(headpos),headpos);
                    }
                    else if(this.transitions[i].charAt(8) == 'L')
                    {
                        headpos--;
                        compute(nextState,this.tape.charAt(headpos),headpos);
                    }
                    else if (this.transitions[i].charAt(8) == 'Y')
                    {
                        System.out.println("ACCEPT");
                    }
                    else if (this.transitions[i].charAt(8) == 'N')
                    {
                        System.out.println("REJECT");
                    }
                }
            
        }
    }
    
    public void print(){
        for(int i = 0; i<states.size();i++)
        {
            System.out.print(states.get(i) + " ");
        }
        System.out.println("");
        System.out.println("Alphabet: " + Arrays.toString(this.alphabet));
        for(int i = 0; i<this.transitions.length;i++)
        {
            System.out.println(this.transitions[i]);
        }
        System.out.println("Initial State = " + this.initialstate);
        System.out.println("Tape = " + this.tape);
        System.out.println("Head Position = " + this.headposition);
    }
    
}
