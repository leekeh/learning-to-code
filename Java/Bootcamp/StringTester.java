
import javax.swing.JOptionPane;

public class Main {
    public static void main (String [] args) {
        String s;
        while (true) {
            // Vraag de gebruiker om input.
            s = JOptionPane.showInputDialog("Geef een String");
            if (s == null) break;  // Als op cancel gedrukt is: stoppen.
            System.out.println("Uw invoer is \"" + s + "\".");
            System.out.println("Dit is " + lengteInvoer(s) + " tekens lang.");
            System.out.println("De invoer bevat " + anLetters(s) + " letters.");
            char letter = 'a';
            System.out.println("De invoer bevat " + howManyLetter(s, letter) + " keer de letter " + letter + ".");
            int woorden = anWoorden(s);
            if (woorden==1) {
                System.out.println("De invoer bevat 1 woord.");
            } else {
                System.out.println("De invoer bevat " + woorden + " woorden");
            }
            
            if (isPalindroom3(s)) {
                System.out.println("De invoer is een palindroom.");
            } else {
                System.out.println("De invoer is geen palindroom.");
            }

            //if (testSchrikkelJaar(i)) {
            //    System.out.println("De waarde " + i + " is een schrikkeljaar.");
            //} else {
            //    System.out.println("De waarde " + i + " is geen schrikkeljaar.");
            //}
            
            
        }
        System.out.println("Tot ziens!");
    }
    
    public static int lengteInvoer(String input) {
        return input.length();
    }
    
    public static int anLetters(String input) {
        char[] chars = input.toCharArray();
        int sum = 0;
        for (char teken : chars) {
            if (isLetter(teken)) {
                sum++;
            }
        }
        return sum;
    }
    
    public static int howManyLetter(String input, char letter) {
        char[] chars = input.toCharArray();
        int sum = 0;
        for (char teken : chars) {
            if (teken == letter) {
                sum ++;
            }
        }
        return sum;
    }
    
    public static boolean isLetter(char teken) {
        int ascii = teken;
        return ((teken >= 65 && teken <= 90 ) || (teken >= 97 && teken <= 122));
    }
    
    public static int anWoorden(String input) {
        int sum = 0;
        char[] tekens = input.toCharArray();
        boolean inwoord = false;
        for (char teken : tekens) {
            if (isLetter(teken)) {
                if (!inwoord) {
                    sum++; //telt er alleen bij op als je eerst niet in een woord zat
                }
                inwoord=true;
            } else {
                inwoord=false;
            }
        }
        return sum;
    }
    
    public static boolean letterEquals(char a, char b) { //werkt alleen met letters
        return (a == b || a == b + 32 || b == a + 32);
    }
    
    public static boolean isPalindroom(String input) { //oude versie, inefficiënt
        int amount = anLetters(input);
        char[] letters = new char[amount];
        int i = 0;
        for (char teken : input.toCharArray()) { //creëert een lijst van letters;
            if (isLetter(teken)) {
                letters[i] = teken;
                i++;
            }
        }
        
        int b = amount-1 ; //deze teler gaat van achter naar voren
        for (int j = 0; j<(amount/2); j++) {
            if (!letterEquals(letters[j], letters[b])) {
               return false; 
            }
            b--;
        }
        
        
        return true;
    }
    
    public static boolean isPalindroom2(String input){
        char[] content = input.toUpperCase().toCharArray();
        int i = 0;
        int j = input.length()-1;
        while (i<j) {
            if (!isLetter(content[i])) {
                i++;
                continue;
            } else if (!isLetter(content[j])) {
                j--;
                continue;
            }
            if (!letterEquals(content[i], content[j])) {
                return false;
            }
            i++;
            j--;
        }
        return true;
    }
    
     public static boolean isPalindroom3(String input){ //meer elegant met loops
        char[] content = input.toUpperCase().toCharArray();
        int i = 0;
        int j = input.length()-1;
        while (i<j) {
            while (!isLetter(content[i])) {
                i++;
            }
            while (!isLetter(content[j])) {
                j--;
            }
            
            if (!letterEquals(content[i], content[j])) {
                return false;
            }
            i++;
            j--;

        }
        return true;
    }   
    
}
