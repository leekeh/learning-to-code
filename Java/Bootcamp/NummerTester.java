import java.util.ArrayList;
import javax.swing.JOptionPane;

public class Main {

    public static void main(String[] args) {
        String s;
        int i;
        while (true) {
            // Vraag de gebruiker om input.
            s = JOptionPane.showInputDialog("Geef een getal");
            if (s == null) break;  // Als op cancel gedrukt is: stoppen.

            try {
                i = Integer.parseInt(s);

            } catch (NumberFormatException e) { // De Integer.parseInt(s) is mislukt.
                System.out.println("Helaas '" + s + "' is geen integer.");
                continue; // Spring meteen naar einde van de loop (voor volgende input).
            }

            if (testSchrikkelJaar(i)) {
                System.out.println("De waarde " + i + " is een schrikkeljaar.");
            } else {
                System.out.println("De waarde " + i + " is geen schrikkeljaar.");
            }
            
            if (isPriem(i)) {
                System.out.println("De waarde " + i + " is een priemgetal.");
            } else {
                System.out.println("De waarde " + i + " is geen priemgetal.");
            }
            
            if (testArmstrong(i)) {
                System.out.println("De waarde " + i + " is een Armstrong getal.");
            } else {
                System.out.println("De waarde " + i + " is geen Armstrong getal.");
            }            

            if (testPerfect(i)) {
                System.out.println("De waarde " + i + " is een perfect getal.");
            } else {
                System.out.println("De waarde " + i + " is geen perfect getal.");
            }              
            
            if (testOvervloedig(i)) {
                System.out.println("De waarde " + i + " is een overvloedig getal.");
            } else {
                System.out.println("De waarde " + i + " is geen overvloedig getal.");
            }                    
        }
        System.out.println("Tot ziens!");
        // Opdracht 7A
        //System.out.println(testSchrikkelJaar(1584));
        // Opdracht 8b
        //testPriem(13);
        //testPriem(20);
        //testPriem(133);
        // variaties
        //System.out.println(testArmstrong(1111));
       // System.out.println(binToDec(100));

    }

    public static boolean testSchrikkelJaar(int i) {
        return i >= 1582 && i % 4 == 0 && (i % 400 == 0 || i % 100 != 0);
    }

    public static void testPriem(int x) {
        if (isPriem(x)) {
            System.out.println("De waarde " + x + " is geen priemgetal");
        } else {
            System.out.println("De waarde " + x + " is een priemgetal.");
        }
    }
    
    public static boolean isPriem(int x) {
        if (x<1) {
            return false;
        }
        for (int i = 2; i < x; i++) {
            if (x % i == 0) {
                return false;
            }
        }
        return true;
    }

    /**
     * Een Armstrong getal is gelijk aan de som van cijfers^lengte
     * @param x
     * @return 
     */
    public static boolean testArmstrong(int x) {
        int number = x;
        ArrayList<Integer> digits = new ArrayList<Integer>();
        while (number > 0) {
            digits.add(number % 10); //by doing this, a list of all digits will be generated
            number = number / 10;
        }
        
        int som = 0;
        int pow = digits.size();
        for (int digit : digits) {
            som += Math.pow(digit, pow);
        }

        return (x == som);
    }
    
    /**
     * Een Armstrong getal is gelijk aan de som van cijfers^lengte
     * @param x
     * @return 
     */
    public static boolean testArmstrong2(int x) {
        int number = x;
        int som = 0;
        int pow = Integer.toString(x).length();
        while (number > 0) {
            som += Math.pow(number % 10, pow);
            
            number = number / 10;
        }
        return x == som;
    }

    public static boolean testPerfect(int x) {
        int y = 0;
        for (int i = 1; i < x; i++) {
            if (x % i == 0) {
                y += i;
            }
        }
        return x == y; //number should equal the sum of its divisors
    }

    public static boolean testOvervloedig(int x) {
        int sum = 0;
        for (int i = 1; i < x; i++) {
            if (x % i == 0) {
                sum += i;
            }
        }
        return sum > x; //in an abundant nr, sum of divisors should be larger than the number
    }

}
