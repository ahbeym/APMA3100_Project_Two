public class MonteCarlo {

    static int x;
    static int a = 24693; //multiplier
    static int c = 3517; //increment
    static int k = 2^17; //modulus
    static double u = 0; //quotient of x/K
    static double v1 = 0;
    public static double [] randomNumberGenerator(){
        //need nested?
        double [] nums = new double[500];
//        nums[0] = x;
////        for (int i = 1; i < 500; i++){
////            nums[i] = ( (a*nums[i-1]) + c) % k;
////        }
//        for (int i = 1; i < 500; i++){
//            v1 = ( (a*nums[i-1]) + c) % k;
//            u = v1 /k;
//            nums[i] = u;
//        }
//        return nums;
    }
    public static void main(String[] args){
        double [] numList;
        numList = randomNumberGenerator();
        for(int i = 0; i < numList.length; i++){
            System.out.println("| Value: " + numList[i] + " | Position in array: "+ i + " |");
        }
    }
}
