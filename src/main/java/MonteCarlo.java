public class MonteCarlo {

    static final int x_0 = 1000;
    static final int A = 24693; //multiplier
    static final int C = 3517; //increment
    static final int K = (int) Math.pow(2,17); //modulus
    static final int num_of_RV = 500;
    static double [] W = new double[num_of_RV];
    static int iter = 0;
    static double [] x = new double[num_of_RV];
    static double [] u = new double[num_of_RV];

    public static double [] randomNumberGenerator(){
       x[0] = ((A* x_0+ C )% K);
       u[0] = x[0] / (double) K;
       for (int i = 1; i < num_of_RV; i++){
           x[i] = (( A* x[i-1]  + C) % K);
           u[i] = x[i] / (double) K;
       }
       return u;
    }
    public static double[] availabilityAndTimeChecker() {
        for (int i = 0; i < num_of_RV; i++) {
            int calls = 0;
            while (calls < 4) {
                calls++;
                W[i] += 6;
                if (u[iter] <= 0.2) {
                    W[i] += 4;
                }
                else if((u[iter] <= 0.5) && (u[iter] > 0.2)) {
                    W[i] += 26;
                }
                else if (u[iter] > 0.5) {
                    double x = -12*Math.log(1-u[iter]);
                    if (x <= 25) {
                        W[i] += x;
                        break;
                    }
                    else if (x > 25) {
                        W[i] += 26;
                    }
                }
                iter++;
            }
        }
        return W;
    }
    public static void main(String[] args) {
        double[] numList;
        double[] timeList;
        numList = randomNumberGenerator();
        timeList = availabilityAndTimeChecker();
        for (int i = 0; i < numList.length; i++) {
            int disp = i + 1;
//            System.out.println("Element " + disp + ": " + numList[i]);
            System.out.println("Element " + disp + ": " + numList[i] + ", " + timeList[i]);

        }


    }
}
