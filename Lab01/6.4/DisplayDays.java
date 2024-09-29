import java.util.Scanner;
public class DisplayDays {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int year = 0;
        String monthInput = "";
        boolean validInput = false;
        int daysInMonth = 0;

        while (!validInput) {
            System.out.print("Enter the month (full name, abbreviation, or number): ");
            monthInput = scanner.nextLine().trim();

            System.out.print("Enter the year (non-negative whole number): ");
            String yearInput = scanner.nextLine().trim();

            year = Integer.parseInt(yearInput);
            if (year < 0) {
                System.out.println("Year cannot be negative. Please enter a valid year.");
                continue;
            }

            switch (monthInput) {
                case "January":
                case "Jan":
                case "Jan.":
                case "1":
                    daysInMonth = 31;
                    validInput = true;
                    break;
                case "February":
                case "Feb":
                case "Feb.":
                case "2":
                    daysInMonth = isLeapYear(year) ? 29 : 28;
                    validInput = true;
                    break;
                case "March":
                case "Mar":
                case "Mar.":
                case "3":
                    daysInMonth = 31;
                    validInput = true;
                    break;
                case "April":
                case "Apr":
                case "Apr.":
                case "4":
                    daysInMonth = 30;
                    validInput = true;
                    break;
                case "May":
                case "May.":
                case "5":
                    daysInMonth = 31;
                    validInput = true;
                    break;
                case "June":
                case "Jun":
                case "Jun.":
                case "6":
                    daysInMonth = 30;
                    validInput = true;
                    break;
                case "July":
                case "Jul":
                case "Jul.":
                case "7":
                    daysInMonth = 31;
                    validInput = true;
                    break;
                case "August":
                case "Aug":
                case "Aug.":
                case "8":
                    daysInMonth = 31;
                    validInput = true;
                    break;
                case "September":
                case "Sep":
                case "Sep.":
                case "9":
                    daysInMonth = 30;
                    validInput = true;
                    break;
                case "October":
                case "Oct":
                case "Oct.":
                case "10":
                    daysInMonth = 31;
                    validInput = true;
                    break;
                case "November":
                case "Nov":
                case "Nov.":
                case "11":
                    daysInMonth = 30;
                    validInput = true;
                    break;
                case "December":
                case "Dec":
                case "Dec.":
                case "12":
                    daysInMonth = 31;
                    validInput = true;
                    break;
                default:
                    System.out.println("Invalid month. Please enter a valid month.");
            }
        }

        System.out.println("The number of days is: " + (isLeapYear(year) && monthInput.startsWith("Feb") ? 29 : daysInMonth));
        scanner.close();
    }

    private static boolean isLeapYear(int year) {
        return (year % 4 == 0 && year % 100 != 0) || (year % 400 == 0);
    }
}
