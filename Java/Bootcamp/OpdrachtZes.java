public class Main {
    public static void main (String[] args) {
        //int a = 2.6;
        //System.out.println(a);
        // geeft een error, 2.6 is een double
        
        double a = 5/2.;
        System.out.println(a); // één van de twee is een double, dus resultaat deling is een double. wordt toegeschreven aan double variable;
        int b = 4/2;
        System.out.println(b); //klopt, is een int. wordt afgerond maar niks gaat verloren
        int c = 5/2;
        System.out.println(c); //int deling vergeet alles achter de komma
        double d = 5/2;
        System.out.println(d); // integer deling vindt eerst plaats, daarna omgezet naar double
        double x = 3/2 + 1;
        System.out.println(x); // integer deling eerst afgerond, daar na de rest.
        double y = 3/(2+1);
        System.out.println(y); // tussen haakjes wordt eerst uitgevoerd.
    }
}
