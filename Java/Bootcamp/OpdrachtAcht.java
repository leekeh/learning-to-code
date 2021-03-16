public class NewClass {
    public static void main (String [] args) {
        table(8);
        juffen(1000);
        beerTable(1.75, 7);
        beerTableLit(1.75, 7);
    }
    
    public static void table (int multiplier) {
        for (int i=1; i<=10; i++) {
            System.out.println(i*multiplier);
        }
    }
    
    public static void juffen (int amount) {
        for (int i=1; i<=amount; i++) {
            if (i%7==0) {
                System.out.println("juf;");
            } else if (bevatZeven(i)) {
                System.out.println("juf;");
            } else {
                System.out.println(i + ";");
            }
        }
    }
    
    public static boolean bevatZeven (int i) {
        while (i>1) {
            if (i%10 ==7) {
                return true;
            }
            i = i/10;
        }
        return false;
    }
    
    
    public static void beerTable (double price, int amount) {
        System.out.println("1 biertje kost €" + price + "; ");
        for (int i=2; i<=amount; i++) {
            System.out.println(i + " biertjes kosten €" + price*i + "; ");
        }
    
    }
    
    public static void beerTableLit (double price, int amount) {
        for (int i=1; i<=amount; i++) {
            double cost = price * i;
            int eur = (int) cost;
            int cent = (int) ((cost-eur)*100);
            if (i==1) {
                System.out.println(i + " biertje kost " + eur + " euro en " + cent + " eurocent; ");
            }
            System.out.println(i + " biertjes kosten " + eur + " euro en " + cent + " eurocent; ");
        }        
    }

}
