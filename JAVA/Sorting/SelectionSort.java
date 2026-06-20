import java.util.Arrays;

public class SelectionSort {
static int[] selectionSort(int[] arr){
    int n = arr.length;

    for(int i = 0; i < n - 1; i++){
        int minIndex = i;
        for(int j = i + 1; j < n; j++){
            if(arr[j] < arr[minIndex]){
                minIndex = j;
            }
        }
       if (minIndex != i) {
            int temp = arr[i];
            arr[i] = arr[minIndex];
            arr[minIndex] = temp;
        }
    }
    return arr;
}
static int findMinIndex(int[] arr, int minIndex, int currentIdx, int end) {
    // If we scanned to the end of the array, return the best minIndex found
    if (currentIdx == end) {
        return minIndex;
    }
    
    // Update minIndex if a smaller value is found
    if (arr[currentIdx] < arr[minIndex]) {
        minIndex = currentIdx;
    }
    
    // Check the next element recursively
    return findMinIndex(arr, minIndex, currentIdx + 1, end);
}

static int[] selectionSortRecur(int[] array1, int sizeToShrink, int index, int end){
    if(sizeToShrink >= end - 1){
        return array1;
    }
    int minIndex = findMinIndex(array1, sizeToShrink, sizeToShrink + 1, end);
     if (minIndex != sizeToShrink) {
        int temp = array1[sizeToShrink];
        array1[sizeToShrink] = array1[minIndex];
        array1[minIndex] = temp;
    }

return selectionSortRecur(array1, sizeToShrink + 1, sizeToShrink + 2, end);
    
}

public static void main(String[] args) {
    int[] array = {64, 13, -4, 9, 77, 18, 100, 127, 99, 5, 26,-5,  23, 18, 0, 22, 17};
    int[] res1 = selectionSortRecur(array, 0, 1, array.length);
    System.out.println(Arrays.toString(res1));
    
}
}
