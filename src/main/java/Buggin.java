//import java.util.ArrayList;
//import java.util.List;
//
//
//public class Buggin {
//
//    public class SampleMeansGenerator {
//
//        public static double[] randomNumberGenerator(int num_of_RV, int A, int C, int K, int x_0) {
//            double[] x = new double[num_of_RV];
//            double[] u = new double[num_of_RV];
//            x[0] = ((A * x_0 + C) % K);
//            u[0] = x[0] / (double) K;
//            for (int i = 1; i < num_of_RV; i++) {
//                x[i] = ((A * x[i - 1] + C) % K);
//                u[i] = x[i] / (double) K;
//            }
//            return u;
//        }
//
//        public static List<Double> generateSampleMeans() {
//            List<Double> sampleMeans = new ArrayList<>();
//            int[] nValues = {10, 30, 50, 100, 250, 500, 1000};
//            int numTrials = 110;
//            int numRVs = 1000;
//            int A = 24693;
//            int C = 3967;
//            int K = (int) Math.pow(2, 18);
//            int x_0 = 1000;
//
//            for (int n : nValues) {
//                for (int i = 0; i < numTrials; i++) {
//                    double[] randomNums = randomNumberGenerator(numRVs, A, C, K, x_0 + i); // Use i to generate a different seed for each trial
//                    double sum = 0.0;
//                    for (int j = 0; j < n; j++) {
//                        sum += randomNums[j];
//                    }
//                    double mean = sum / n;
//                    sampleMeans.add(mean);
//                }
//            }
//            return sampleMeans;
//        }
//
//        public static void main(String[] args) {
//            List<Double> sampleMeans = generateSampleMeans();
//            System.out.println(sampleMeans.size()); // should output 213400
//        }
//    }
//
//}
