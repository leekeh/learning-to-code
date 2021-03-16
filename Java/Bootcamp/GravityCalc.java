class GravityCalc {
    public static void main(String[] arguments) {
        double gravity = 9.81;  // Earth's gravity in m/s^2
        double initialVelocity = 0.0;
        double fallingTime = 10.0;
        double initialPosition = 0.0;
        double dis = posCalc(gravity, fallingTime, initialVelocity, initialPosition);
        System.out.println("Een object bevindt zich na " + fallingTime + " seconden op "+ dis + " meters");
    }
  
    public static double posCalc(double mag, double time, double inVel, double inPos) {
        double a = -0.5*mag*(time*time);
        double b = inVel*time;
        double finalPos =  a + b + inPos;
        if (finalPos<0) {
            finalPos = 0;
        }
        return finalPos;
    }
} 
