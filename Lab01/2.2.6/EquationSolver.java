import java.util.Scanner;

public class EquationSolver {

    public static void firstDegreeEquation(double a, double b) {
        // ax + b = 0
        if (a == 0) {
            if (b == 0) {
                System.out.println("Infinitely many solutions");
            }
            else {
                System.out.println("No solution");
            }
        }
        else {
            double x = -b / a;
            System.out.println("Solution: x = " + x);
        }
    }

    public static void firstDegreeEquations(double a11, double a12, double b1, double a21, double a22, double b2) {
        // a11*x1 + a12*x2 = b1
        // a21*x1 + a22*x2 = b2

        double D = a11 * a22 - a21 * a12;
        double D1 = b1 * a22 - b2 * a12;
        double D2 = a11 * b2 - a21 * b1;

        if (D == 0) {
            if (D1 == 0 && D2 == 0) {
                System.out.println("Infinitely many solutions");
            }
            else {
                System.out.println("No solution");
            }
        }
        else {
            // Cramer's rule
            double x1 = D1 / D;
            double x2 = D2 / D1;
            System.out.println("Solution: x1 = " + x1 + ", x2 = " + x2);
        }
    }
    
    public static void quadraticEquation(double a, double b, double c) {
        // ax^2 + bx + c = 0
        if (a == 0) {
            firstDegreeEquation(b, c);
        }
        else {
            double discriminant = b*b - 4*a*c;
            if (discriminant > 0) {
                double x1 = (-b + Math.sqrt(discriminant)) / (2 * a);
                double x2 = (-b - Math.sqrt(discriminant)) / (2 * a);
                System.out.println("Solution: x1 = " + x1 + ", x2 = " + x2);
            }
            else if (discriminant == 0) {
                double x = -b / (2 * a);
                System.out.println("Double root: x = " + x);
            }
            else {
                System.out.println("No real roots");
            }
        }
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Choose the type of equation to solve:");
        System.out.println("1. ax + b = 0");
        System.out.println("2. a11*x1 + a12*x2 = b1\n   a21*x1 + a22*x2 = b2");
        System.out.println("3. ax^2 + bx + c = 0");
        System.out.print("Enter the number of your choice: ");

        int choice = scanner.nextInt();
        
        switch (choice) {
            case 1:
                System.out.print("Enter coefficient a: ");
                double a1 = scanner.nextDouble();
                System.out.print("Enter coefficient b: ");
                double b1 = scanner.nextDouble();
                firstDegreeEquation(a1, b1);
                break;
            case 2:
                System.out.print("Enter coefficient a11: ");
                double a11 = scanner.nextDouble();
                System.out.print("Enter coefficient a12: ");
                double a12 = scanner.nextDouble();
                System.out.print("Enter constant b1: ");
                double b1system = scanner.nextDouble();
                System.out.print("Enter coefficient a21: ");
                double a21 = scanner.nextDouble();
                System.out.print("Enter coefficient a22: ");
                double a22 = scanner.nextDouble();
                System.out.print("Enter constant b2: ");
                double b2system = scanner.nextDouble();
                firstDegreeEquations(a11, a12, b1system, a21, a22, b2system);
                break;
            case 3:
                System.out.print("Enter coefficient a: ");
                double a = scanner.nextDouble();
                System.out.print("Enter coefficient b: ");
                double b = scanner.nextDouble();
                System.out.print("Enter coefficient c: ");
                double c = scanner.nextDouble();
                quadraticEquation(a, b, c);
                break;
            default:
                System.out.println("Invalid choice. Please run the program again.");
        }
        scanner.close();
    }
}