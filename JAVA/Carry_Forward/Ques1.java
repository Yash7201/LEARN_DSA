

public class Ques1{
    /*
     * Question1. find Special "AG" sequences that A[i] = A and A[j] = G and i < j
     * using Carry forward approch
   */

   static long CarryFor(String A){
        long countG = 0L;
        long ans = 0L;
        for(int i = A.length()-1; i >=0; i--){
            if(A.charAt(i) == 'G'){
                countG++;
            }else if(A.charAt(i) == 'A'){
                ans += countG;
            }
        }
            return ans;
   }
    public static void main(String[] args) {
        String test = "ABCGAGG";
        System.out.println(CarryFor(test));
    }
}