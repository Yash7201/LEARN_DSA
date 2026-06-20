import java.util.Arrays;

public class Insertion {
    static int[] insertionSort(int[] arr) {
        int n = arr.length;

        // Start from the second element (index 1) because the first element is already "sorted"
        for (int i = 1; i < n; i++) {
            int key = arr[i]; // The "new card" we want to insert
            int j = i - 1;    // Start comparing with the element right before it

            // Shift elements of the sorted section that are greater than the key
            // one position ahead of their current position
            while (j >= 0 && arr[j] > key) {
                arr[j + 1] = arr[j]; // Shift to the right
                j--;                 // Move backward through the sorted section
            }
            
            // Insert the key into its correct sorted position
            arr[j + 1] = key;
        }
        return arr;
    }

    public static void main(String[] args) {
        int[] arr = {22, 7, 100, 8, 44, 33};
        System.out.println("Original: " + Arrays.toString(arr));
        
        insertionSort(arr);
        System.out.println("Sorted:   " + Arrays.toString(arr));
    }
}
