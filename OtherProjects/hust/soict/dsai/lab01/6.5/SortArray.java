import java.util.Arrays;
import java.util.Scanner;

public class SortArray {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.print("Enter the number of elements in the array: ");
        int n = scanner.nextInt();

        int[] arr = new int[n];
        System.out.println("Enter " + n + " elements");
        for (int i = 0; i < n; i++) {
            arr[i] = scanner.nextInt();
        }
        // Sort
        Arrays.sort(arr);

        // Sum
        int sum = 0;
        for (int num : arr) {
            sum += num;
        }
        // Average
        double average = (double) sum / n;

        System.out.println("Sorted Array: " + Arrays.toString(arr));
        System.out.println("Sum: " + sum);
        System.out.println("Average: " + average);

        scanner.close();
    }
}
