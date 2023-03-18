public class MonteCarlo {

    static final int x_0 = 1000;
    static final int A = 24693; //multiplier
    static final int C = 3517; //increment
    static final int K = (int) Math.pow(2,17); //modulus
    static final int num_of_RV = 500;

    public static double [] randomNumberGenerator(){
       double [] x = new double[num_of_RV];
       double [] u = new double[num_of_RV];
       x[0] = ((A* x_0+ C )% K);
       u[0] = x[0] / (double) K;
       for (int i = 1; i < num_of_RV; i++){
           x[i] = (( A* x[i-1]  + C) % K);
           u[i] = x[i] / (double) K;
       }
       return u;
    }
    public static void main(String[] args){
        double [] numList;
        numList = randomNumberGenerator();
        for(int i = 0; i < numList.length; i++){
            int disp = i+1;
            System.out.println("Element " + disp + ": " + numList[i]);
        }

    }
}

//    double [] nums = new double[500];
//    int x_i = x_0;
//        for (int i = 0; i < 500; i++){
//        x_i = ((x_i*A)+C) % K;
//        double u_i = (double) x_i / K;
//        nums[i] = u_i;
//        }
//        return nums;