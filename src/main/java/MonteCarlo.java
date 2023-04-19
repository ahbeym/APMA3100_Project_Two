
import java.util.*;

public class MonteCarlo {

    static final int x_0 = 1000;
    static final int A = 24693; //multiplier
    static final int C = 3967; //increment 3517
    static final int K = (int) Math.pow(2,18); //modulus
    static final int num_of_RV = 2003 ;
    static double [] W = new double[500];
    static int iter = -1;
    static double [] x = new double[1000000];
    static double [] u = new double[1000000];

    public static double [] randomNumberGenerator(int num_of_RV, int A, int C, int K, int x_0) {
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
    public static void printU(double [] dArray){
        for (int i = 0; i < 500; i++){
            int form = i+1;
            System.out.println("u Value " + form + ": " + dArray[i]);
        }
    }

    public static ArrayList<Double> updateArray1(ArrayList<Double> array1, ArrayList<Double> array2) {

        // Create a map to keep track of the number of duplicates for each value in array2
        Map<Double, Integer> duplicates = new HashMap<Double, Integer>();
        for (double value : array2) {
            if (duplicates.containsKey(value)) {
                duplicates.put(value, duplicates.get(value) + 1);
            } else {
                duplicates.put(value, 1);
            }
        }

        // Loop through array2 and update the corresponding values in array1
        for (int i = 0; i < array2.size(); i++) {
            double value = array2.get(i);
            int numDuplicates = duplicates.get(value);
            if (numDuplicates > 1) {
                double newValue = value * ((double) numDuplicates / 500);
                array1.set(i, newValue);
            }
        }

        return array1;
    }

    public static List<Double> generateSampleMeans() {
        List<Double> sampleMeans = new ArrayList<>();
        int[] nValues = {10, 30, 50, 100, 250, 500, 1000};
        int numTrials = 110;
        int numRVs = 1000;
        int A = 24693;
        int C = 3967;
        int K = (int) Math.pow(2, 18);
        int x_0 = 1000;

        for (int n : nValues) {
            for (int i = 0; i < numTrials; i++) {
                numRVs = 110*n;
                double[] randomNums = randomNumberGenerator(numRVs, A, C, K, x_0 ); // do we use i to generate a different seed for each trial
                double sum = 0.0;
                for (int j = 0; j < n; j++) {
                    sum += randomNums[j];
                }
                double mean = sum / n;
                sampleMeans.add(mean);
            }
        }
        return sampleMeans;
    }
    public static void main(String[] args) {
//        double [] probList;
//        double [] WList;
//        probList = randomNumberGenerator();
//
//        WList = availabilityAndTimeChecker();
//        //Arrays.sort(WList);
//
//        double [] neat = round(WList, 2);
//        for (int i = 0; i < 500; i++){
//            System.out.println(probList[i]);
        List<Double> sampleMeans = generateSampleMeans();
        System.out.println(sampleMeans);
        System.out.println(sampleMeans.size());
        }



    }

