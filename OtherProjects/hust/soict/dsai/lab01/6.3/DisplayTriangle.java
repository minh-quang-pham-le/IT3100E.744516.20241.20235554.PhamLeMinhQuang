import java.util.Scanner;
public class DisplayTriangle {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the height of triangle n = ");
        int n = scanner.nextInt();
        for (int i = 0; i < n; i++) {
            System.out.print(" ".repeat(n-i+1));
            for (int j = 0; j < (2*i+1); j++) {
                System.out.print('*');
            }
            System.out.println("");
        }
        scanner.close();
    }
}
