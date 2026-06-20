// all sorting alogorithms and there recursive version

import java.util.Arrays;

public class BubbleSort{
    static int[] bubbleSort(int[] arr){
        int n = arr.length;
        for(int i = 0; i < n; i++){
            boolean swapped = false;
            for(int j = 0; j < n-i-1; j++){
                if(arr[j] > arr[j+1]){
                    int temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
                    swapped = true;
                }
            }

            if(!swapped){
                break;
            }
        }
        return arr;
    }
    
    static int[] bubbleSortRecur(int[] arr, int sizeToShrink, int index, boolean swapped){
        if(sizeToShrink <= 1){
            return arr;
        }
   
        if(index == sizeToShrink - 1){
             if (!swapped) {
            return arr; 
        }
            return bubbleSortRecur(arr, sizeToShrink-1, 0, false);
        }

      
        if (arr[index] > arr[index + 1]) {
            int temp = arr[index];
            arr[index] = arr[index + 1];
            arr[index + 1] = temp;
            swapped = true;
    }
        

        return bubbleSortRecur(arr, sizeToShrink, index + 1, swapped);
      
    }
    
    public static void main(String[] args){
        System.out.println("Hi, there");
        int[] array = {64, 13, -4, 9, 77, 5, 26,-5,  23, 18, 0, 22, 17};
        // int[] res = bubbleSort(array);
        int[] result = bubbleSortRecur(array, array.length, 0, false);
        System.out.println(Arrays.toString(result));
    }
}

