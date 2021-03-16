public class Main {
    public static void main (String [] args) {
        System.out.println(fahrenheitToCelcius(100));
        System.out.println(celciusToFahrenheit(40));
        System.out.println(celciusToKelvin(-80));
        System.out.println(fahrenheitToKelvin(100));
    }
    
    public static double fahrenheitToCelcius(double f) {
        return ((f-32)*(5./9));
    }
    
    public static double celciusToFahrenheit(double c) {
        return ((c*(9./5))+32);
    }
    
    public static double celciusToKelvin(double c) {
        return c + 273.15;
    }
    
    public static double fahrenheitToKelvin(double f) {
        return celciusToKelvin(fahrenheitToCelcius(f));
    }
}
