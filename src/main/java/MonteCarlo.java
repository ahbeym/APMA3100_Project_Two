public class MonteCarlo {

    static int x_0 = 1000;
    static final int A = 24693; //multiplier
    static final int C = 3517; //increment
    static final int K = (int) Math.pow(2,17); //modulus

    public static double [] randomNumberGenerator(){
        //need nested?
        double [] nums = new double[500];
        int x_i = x_0;
        for (int i = 0; i < 500; i++){
            x_i = ((x_i*A)+C) % K;
            double u_i = (double) x_i / K;
            nums[i] = u_i;
        }
        return nums;
    }
    public static void main(String[] args){
        double [] numList;
        numList = randomNumberGenerator();
        for(int i = 0; i < numList.length; i++){
            System.out.println("| Value: " + numList[i] + " | Position in array: "+ i + " |");
        }
    }
}
