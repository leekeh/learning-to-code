
import static java.lang.Double.max;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.concurrent.ThreadLocalRandom;
import javax.swing.JOptionPane;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 */
public class Main {
    public static void main (String[] args) {
        Scanner scanner = new Scanner (System.in);
        while (true) {
            startupPage();
            String answer = scanner.nextLine();
            if (answer.toLowerCase().equals("quit") || answer.toUpperCase().equals("Q")) {
                System.out.println("Thank you for playing!");
                break;
            }
            char[][] key = chooseDifficulty();
            char[][] display = new char[key.length][key[0].length];
            boolean alive = true;
            while (alive) {
                //printField(key); //only for debugging purposes
                printField(display);
                System.out.println("\n Enter the coordinates (in the format such as A5) \n or enter F to place a flag \n" );
                System.out.println("Enter Q to quit");
                String input = scanner.nextLine();
                if (input.toUpperCase().equals("Q") || input.toLowerCase().equals("quit")) {
                    alive=false;
                    System.out.println("You quit the game");
                    continue;
                }
                if (input.toUpperCase().equals("F")) {
                    System.out.println("Where should the flag go? Format your answer such as 'A5'.\n");
                    System.out.println("Remove a flag by entering its coordinates.\n");
                    String inputflag = scanner.nextLine();
                    int[]coordinates = convertInput(inputflag, display);
                    int y = coordinates[0];
                    int x = coordinates[1];
                    if (coordinates[0] == 99) { //error
                        continue;
                    } 
                    if (display[x][y]=='F') {
                        display[x][y] = 0;
                    } else {
                        if (display[x][y] == 0) {
                            display[x][y] = 'F';
                        } else {
                            errorBox("You can only place a flag on a cell that has not been opened yet. Please try again.");
                            continue;
                        }
                    }
                } else { 
                    //this block checks what is underneath the spot the player chose
                    int[] coordinates = convertInput(input,display);
                    if (coordinates[0] == 99) {
                        continue;
                    }
                    int y = coordinates[0];
                    int x = coordinates[1];
                    display[x][y] = key[x][y];
                    if (display[x][y]=='B') {
                        printField(display);
                        System.out.println("Oh no! You have died...");
                        System.out.println("Press enter to return to the main menu");
                        String cont = scanner.nextLine();  
                        alive = false;
                    }                
                    if (display[x][y]=='0') { //if no nearby bombs, show all empty cells around
                        display = clearEmpty2(display, coordinates, key);
                   }
                }
            }
        }
    }
    
    public static void startupPage (){
        System.out.println("\n\n\n\n\n\n\n");
        System.out.println("        _                                                               ");
        System.out.println("       (_)                                                              ");
        System.out.println(" ____   _  ____    ____   ___  _ _ _   ____   ____  ____    ____   ____ ");
        System.out.println("|    \\ | ||  _ \\  / _  ) /___)| | | | / _  ) / _  )|  _ \\  / _  ) / ___)");
        System.out.println("| | | || || | | |( (/ / |___ || | | |( (/ / ( (/ / | | | |( (/ / | |    ");
        System.out.println("|_|_|_||_||_| |_| \\____)(___/  \\____| \\____) \\____)| ||_/  \\____)|_|    ");
        System.out.println("                                                   |_|                  ");
        System.out.println("\n\nWelcome to minesweeper");
        System.out.println("Press enter to start");
        System.out.println("Type quit to stop");
        
    }
    
    public static char[][] generateField(int height, int width, int mines) {
        char[][] field = new char[height][width];
        int placedmines = 0;
        while (placedmines<mines) { //placement of mines
            int y = ThreadLocalRandom.current().nextInt(0, width);
            int x = ThreadLocalRandom.current().nextInt(0, height);
            if (field[x][y]!='B') {
                field[x][y] = 'B';
                placedmines++;
            }
        }
        for (int i=0; i<width; i++) { //fills out the rest of the field with numbers
            for (int j=0; j<height; j++) {
                if (field[j][i] != 'B') {
                    int counter = 0;
                    int[] horCheck = {i-1, i, i+1};
                    int[] verCheck = {j-1, j, j+1}; 
                    for (int hor : horCheck){ //this section counts the bombs around field[j][i]
                        for (int ver : verCheck) {
                            if (0<=hor && hor<width && 0<=ver && ver<height) {
                                if (field[ver][hor]=='B') {
                                    counter++;
                                }
                            }
                        }
                    }
                field[j][i] = (char) (counter+48); //convert int to char    
                }
            }
        }
        return field;
    }
    
    public static void printField(char[][] field) {
        System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
        int vertKey = 1;
        System.out.print("     ");
        for (char horiKey = 'A'; horiKey<'A'+field[0].length; horiKey++ ) {
            System.out.print(" |" + horiKey + "| ");
        }
        System.out.println(" ]");
        for (char[] line : field) {
            if (String.valueOf(vertKey).length()==1) {
                System.out.print(" " + vertKey + " [ ");
            } else {
                System.out.print(vertKey + " [ ");
            }
            vertKey++;
                for (char item : line) {
                    if (item==0) {
                        System.out.print(" | | ");
                    } else {
                     System.out.print(" |" + item + "| ");                        
                    }
                }
                System.out.println(" ]");
            }
    }
    
    public static int[] convertInput(String input, char[][] field){
        int[] error = {99, 99};
        if (input.length() > 3 || input.length()<2) {
            errorBox("Your input was too short or too long. Please enter a letter and a number only, such as 'A5'.");
            return error;
        }
        char letter = input.charAt(0);
        if (!checkLetter(letter)){
            errorBox("You did not put a letter at the first position. Please enter a letter and a number only, such as 'A5'. ");
            return error;
        }
        letter = String.valueOf(letter).toUpperCase().charAt(0); //make sure the letter is capitalized
        String number = input.substring(1);
        if (!checkNumber(number)) {
            errorBox("You did not put a number at the second position. Please enter a letter and a number only, such as 'A5'. ");
            return error;
        }
        int x =  letter - 65; 
        int y = Integer.valueOf(number)-1; //one less to fit with array index starting at 0
        int xMax = field[0].length ;
        int yMax = field.length ;
        if (x>xMax  || y>yMax || x<0 || y<0 ){
            errorBox("Something went wrong with the coordinates. Please make sure that they are on the map.");
            return error;
        }
        int[] coordinates = {x,y};
        return coordinates;
    }
    
    public static boolean checkLetter(char letter) {
        return (letter >= 65 && letter <= 90 ) || (letter >= 97 && letter <= 122);
    }
    
    public static boolean checkNumber(String number) {
        try {
            int intValue = Integer.parseInt(number);
            return true;
        } catch (NumberFormatException e) {
        }
        return false;
        }
    
  
    public static char[][] clearEmpty (char[][] field, int[]coordinates, char[][]key) { //this method shows all surrounding zeroes and bordering fields
        int x = coordinates[1];
        int y = coordinates[0];
        int[] yrange = {y-1, y, y+1};
        int[] xrange = {x-1, x, x+1};
        int yMax = field[0].length;
        int xMax = field.length;
        ArrayList<int[]> foundZeroes = new ArrayList<int[]>();
        for (int ve : yrange){
            for (int ho : xrange) {
                if (0<=ve && ve<yMax && 0<=ho && ho<xMax) {
                    field[ho][ve]=key[ho][ve]; //show all items around the starting position
                    if (field[ho][ve]=='0') { //continue to show surrounding fields if the field has a 0.
                        System.out.println("found at pos " + ho + ve);
                        foundZeroes.add(new int[]{ho, ve}); //make list of all surrounding zeroes.
                       // int[] yrangetwo = {ve-1, ve, ve+1};
                        //int[] xrangetwo = {ho-1, ho, ho+1};
                        //for (int vetwo : yrangetwo){ 
                          //  for (int hotwo : xrangetwo) {
                               // if (0<=vetwo && vetwo<yMax && 0<=hotwo && hotwo<xMax) {
                                  //  if (field[hotwo][vetwo] == 0) { //check if this hasn't been revealed already, to avoid infinite recursion
                                    //    int[] coordinates2 = {ho,ve};
                                    //    field = clearEmpty(field, coordinates2, key);
                                    //    System.out.println("Recursion!");
                                   // }
                               // }
                           // }
                       // }
                    }
                }   
            }

        }
        for (int[] start : foundZeroes) { //this section deals with the spots that were a zero, requiring recursion
            int ho = start[0];
            int ve = start[1];
            int[] yrangetwo = {ve-1, ve, ve+1};
            int[] xrangetwo = {ho-1, ho, ho+1};
            for (int vetwo : yrangetwo){ 
                for (int hotwo : xrangetwo) {
                    if (0<=vetwo && vetwo<yMax && 0<=hotwo && hotwo<xMax) {
                        if (field[hotwo][vetwo] == 0) { //check if this hasn't been revealed already, to avoid infinite recursion
                            int[] coordinates2 = {ho,ve};
                            System.out.println("recursion with ho: " + ho + " ve: " + ve);
                            field = clearEmpty(field, coordinates2, key);
                            System.out.println("Recursion finished");
                        }
                    }
                }
            }    
        }
        
        return field;
    }
    
public static char[][] clearEmpty2 (char[][] field, int[]coordinates, char[][]key) {
    field = showSurroundings(field, coordinates, key);
    //check field now, is one of the coordinates a zeroe and has the surrounding not been shown?
    int x = coordinates[1];
    int y = coordinates[0];
    int[] yrange = {y-1, y, y+1};
    int[] xrange = {x-1, x, x+1};
    int yMax = field[0].length;
    int xMax = field.length;
    for (int ve : yrange){
        System.out.println("ve:" + ve);
        for (int ho : xrange) {
            System.out.println("ho: " + ho);
            if (0<=ve && ve<yMax && 0<=ho && ho<xMax && key[ho][ve]=='0') { // should be all surrounding zeroes
                System.out.println("Check 1 passed for " + ho + ": " + ve);
                if (checkHidden(field, new int[] {ve, ho})) //should only be the zeroes whose surroundings have not been revealed
                    System.out.println("check 2 passed for " + ho + ": " + ve);
                    //return clearEmpty2 (field, new int[] {ve,ho}, key);
                    }
            }
    }
    return field;
}

public static char[][] showSurroundings (char[][] field, int[]coordinates, char[][]key) {
    int x = coordinates[1];
    int y = coordinates[0];
    int[] yrange = {y-1, y, y+1};
    int[] xrange = {x-1, x, x+1};
    int yMax = field[0].length;
    int xMax = field.length;
    for (int ve : yrange){
        for (int ho : xrange) {
            if (0<=ve && ve<yMax && 0<=ho && ho<xMax) {
                field[ho][ve]=key[ho][ve]; //show all items around the starting position
            }
        }
    }
    return field;
}

public static boolean checkHidden (char[][] field, int[]coordinates) {
    int x = coordinates[1];
    int y = coordinates[0];
    int[] yrange = {y-1, y, y+1};
    int[] xrange = {x-1, x, x+1};
    int yMax = field[0].length;
    int xMax = field.length;
    for (int ve : yrange){
        for (int ho : xrange) {
            if (0<=ve && ve<yMax && 0<=ho && ho<xMax && field[ho][ve]==0) {
                System.out.println("This spot is empty! " + ho + ": " + ve);
                return true;
            }
        }
    }
    return false;
}
    
    
    public static char[][] chooseDifficulty(){
        System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\nChoose your difficulty:\n");
        System.out.println("Beginner");
        System.out.println("Easy");
        System.out.println("Medium");
        System.out.println("Hard");
        System.out.println("Custom"); //maximaal 99 hoog, 26 breed
        System.out.println("\n\nInput the first letter of your preferred difficulty\n");
        Scanner scanner = new Scanner (System.in);
        while (true) {
            String input = scanner.nextLine();
            if (input.toUpperCase().equals("B")) {
                System.out.println("Beginner mode is not supported yet. Easy mode selected");
                return  generateField(9,9,10);
            } else if (input.toUpperCase().equals("E")) {
                System.out.println("Easy mode selected");
                return generateField(9,9,10);
            } else if (input.toUpperCase().equals("M")) {
                System.out.println("Medium difficulty selected.");
                return generateField(16,16,40);
            } else if (input.toUpperCase().equals("H")) {
                System.out.println("Hard difficulty selected.");
                return generateField(30,16,99);
            } else if (input.toUpperCase().equals("C")) {
                int x = 0;
                int y = 0;
                int b = 0;
                while (x == 0) {
                    System.out.println("How wide should the field be?");
                    String xinput = scanner.nextLine();
                    if (checkNumber(xinput)) {
                        int xdef = Integer.valueOf(xinput);
                        if (xdef>3 && xdef<27) {
                            x = xdef;
                        } else {
                            errorBox("Please choose a number between 3 and 26 for the width");
                        }                        
                    } else {
                        errorBox("You didn't put in a number. Please try again.");
                    }
                }    
                while (y == 0) {
                    System.out.println("How high should the field be?");
                    String yinput = scanner.nextLine();
                    if (checkNumber(yinput)) {
                        int ydef = Integer.valueOf(yinput);
                        if (ydef>3 && ydef<100) {
                            y = ydef;
                        } else {
                            errorBox("Please choose a number between 3 and 99 for the height");
                        }
                    } else {
                        errorBox("You didn't put in a number. Please try again.");
                    }
                }
                while (b==0) {
                    System.out.println("How many mines should there be?");
                    String binput = scanner.nextLine();
                    if (checkNumber(binput)) {
                        int bdef = Integer.valueOf(binput);
                        if (bdef>0 && bdef<(x*y)) {
                            b = bdef;
                        } else {
                            errorBox("Please choose a number between 1 and the size of the field, which is " + (x*y) + ".");
                        }
                    } else {
                        errorBox("You didn't put in a number. Please try again.");
                    }
                }
                return generateField(y, x, b);
            } else {
                errorBox("Input not recognized. Please make sure to only enter the first letter of the mode you'd like to play.");
            }
        }
    }

    
    public static void errorBox(String message) {
        JOptionPane.showMessageDialog(null, message, "InfoBox: " + "Something went wrong", JOptionPane.INFORMATION_MESSAGE);
    }
    
}
