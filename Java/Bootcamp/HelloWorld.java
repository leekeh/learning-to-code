/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nl.qquest.hello_world;

/**
 *
 * @author l.beunders
 */
public class HelloWorld {
    public static void main (String[] args) {
        System.out.println("Hello world\n hi");
        int numb = 8;
        System.out.println(numb);
        numb ++;
        System.out.println(numb);
        String stringOne = "Dit is een string.";
        String stringTwo = "Dit is ook een string";
        System.out.println(stringOne + "\n" + stringTwo);
        stringTwo = stringOne;
        System.out.println(stringTwo);
        
        //Opdracht 2B
        int number = 9;
        String word = "Hi";
        double behindComma = 10.3;
        char one = 'a';
        boolean bool = true;
        //Opdracht 3
        double varOne = 3.7;
        double varTwo = 1.8;
        double varThree = varOne + varTwo;
        System.out.println(varOne + " + " + varTwo + " = " + varThree);
        // Opdracht 4A
        String stringA = "aap";
        String stringB = "noot";
        String stringC = stringA + stringB;
        System.out.println(stringC);
        System.out.println(stringC + "(mooi hè)");
        System.out.println(stringC + 42); //int wordt automatisch omgezet naar String
        // Opdracht 4B
        System.out.println("We are uncovering better ways of developing");
        System.out.println("software by doing it and helping others do it.");
        System.out.println("Through this work we have come to value:");
        System.out.println("\n\t\"Individuals and interactions over processes and tools\"");
        System.out.println("\t\"Working software over comprehensive documentation\"");
        System.out.println("\t\"Customer collaboration over contract negotiation\"");
        System.out.println("\t\"Responding to change over following a plan\"");
        System.out.println("\nThat is, while there is value in the items on");
        System.out.println("the right, we value the items on the left more.");
        // Opdracht 5A
        System.out.println("auto: 55.0");
        System.out.println("fiets: " + time(35, 25.5));
        

    }
    public static double time(double speed, double distance) {
        return (distance/speed)*60;
    }

    
}
