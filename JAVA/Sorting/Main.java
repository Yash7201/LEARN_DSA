import java.util.Arrays;

public class Main {
    static int[] mergeTwoSortedArr(int[] A, int[] B){
        int n = A.length;
        int m = B.length;
        int i = 0; int j = 0; int k = 0;
        int[] C = new int[n + m];
        while(i < n && j < m){
            if(A[i] < B[j] ){
                C[k] = A[i];
                i++;
            }else {
                C[k] = B[j];
                j++;
            }
            k++;
        }

        while(i < n){
            C[k] = A[i];
            i++;
            k++;
        }

           while(j < m){
            C[k] = B[j];
            j++;
            k++;
        }
        return C;
    }

    static int[] mergeSort(int[] arr, int start, int end){
            if(start == end){
                int[] bres = new int[1];
                bres[0] = arr[start];
                return bres;
            }

        int mid = start + (end - start) / 2;
        int[] D = mergeSort(arr, start, mid);
        int[] E = mergeSort(arr, mid + 1, end);
        int[] finArr = mergeTwoSortedArr(D, E);
        return finArr;
    }
    
    public static void main(String[] args) {
        int[] arr = {7, 8, 22, 105, 100, 99, 44, 33, 205, 195, 16};
        int[] arr1 = {14, 28, 53, 65};
        int[] res = mergeTwoSortedArr(arr, arr1);
        int[] da = mergeSort(arr, 0, arr.length-1);
        System.out.println(Arrays.toString(da));
    }
}
