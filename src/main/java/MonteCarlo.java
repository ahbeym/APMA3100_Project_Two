
import java.util.Arrays;

public class MonteCarlo {

    static final int x_0 = 1000;
    static final int A = 24693; //multiplier
    static final int C = 3517; //increment
    static final int K = (int) Math.pow(2,17); //modulus
    static final int num_of_RV = 2003;
    static double [] W = new double[500];
    static int iter = -1;
    static double [] x = new double[num_of_RV];
    static double [] u = new double[num_of_RV];

    public static double [] randomNumberGenerator() {
        x[0] = ((A* x_0+ C )% K);
        u[0] = x[0] / (double) K;
        for (int i = 1; i < num_of_RV; i++) {
            x[i] = (( A* x[i-1]  + C) % K);
            u[i] = x[i] / (double) K;
        }
        return u;
    }
    public static double[] availabilityAndTimeChecker() {
        for (int i = 0; i < 500; i++) {
            int calls = 0;
            while (calls < 4) {
                calls++;
                iter++;
                W[i] += 6;
                if (u[iter] <= 0.2) {
                    W[i] += 4;
                }
                else if((u[iter] <= 0.5) && (u[iter] > 0.2)) {
                    W[i] += 26;
                }
                else if (u[iter] > 0.5) {
                    iter++;
                    double x = -12*Math.log(1-u[iter]);
                    if (x <= 25) {
                        W[i] += x;
                        break;
                    }
                    else if (x > 25) {
                        W[i] += 26;
                    }
                }
            }
        }
        return W;
    }
    public static double calcMean(double [] a){
        double sum = 0;
        for (double d: a){
            sum += d;
        }
        return sum / a.length;

    }
    public static double calcMedian(double [] a){
        Arrays.sort(a);
        double median;
        if (a.length % 2 == 0)
            median = ((double)a[a.length/2] + (double)a[a.length/2 - 1])/2;
        else
            median = (double) a[a.length/2];
        return median;
    }
    public static double round(double number, int decimals) {
        double out = number * Math.pow(10, decimals);
        out = Math.round(out) / Math.pow(10, decimals);

        return out;
    }
    public static double[] round(double[] array, int decimals) {
        double[] out = new double[array.length];
        for (int i = 0; i < array.length; i++) {
            out[i] = round(array[i], decimals);
        }

        return out;
    }
    public static void main(String[] args) {
        double [] numList;
        double [] timeList;
        numList = randomNumberGenerator();
        timeList = availabilityAndTimeChecker();
        Arrays.sort(timeList);
        double mean = calcMean(timeList);
        double median = calcMedian(timeList);
        double [] neat = round(timeList, 4);
        System.out.println("W mean: " + mean);
        System.out.println("W median: " + median);
        System.out.println("----------------------------");
        for(int i = 0; i < 500; i++) {
            int form = i+1;

            System.out.println("Value " + form + ": " + neat[i]);
        }
    }
}
