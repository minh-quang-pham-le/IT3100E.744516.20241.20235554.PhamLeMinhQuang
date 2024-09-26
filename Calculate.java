import java.util.Scanner;

public class Calculate {
    private double num1;
    private double num2;
    
    public Calculate(double x, double y) {
        num1 = x;
        num2 = y;
    }
    public double sum() {
        return num1 + num2;
    }
    public double difference() {
        return num1 - num2;
    }
    public double product() {
        return num1 * num2;
    }
    public double quotient() {
        if (num2 != 0) {
            return num1 / num2;
        } 
        else {
            System.out.println("Cannot divide by zero");
            return Double.NaN;
        }
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the first number: ");
        double num1 = scanner.nextDouble();

        System.out.print("Enter the second number: ");
        double num2 = scanner.nextDouble();

        Calculate calculate = new Calculate(num1, num2);

        System.out.println("Sum: " + calculate.sum());
        System.out.println("Difference: " + calculate.difference());
        System.out.println("Product: " + calculate.product());
        System.out.println("Quotient: " + calculate.quotient());
        
        scanner.close();
    }
}
