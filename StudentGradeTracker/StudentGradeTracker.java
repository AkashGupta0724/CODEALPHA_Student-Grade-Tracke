import java.util.ArrayList;
import java.util.Scanner;

public class StudentGradeTracker {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in); // Creates a new Scanner object to read input from the console.
        ArrayList<Double> grades = new ArrayList<>(); // Creates an ArrayList to store student grades as double values.

        System.out.println("Welcome to the Student Grade Tracker!");

        // Loop to allow adding grades until the user decides to stop.
        while (true) {
            System.out.print("Enter a student's grade (or 'q' to quit): ");
            String input = scanner.next();

            if (input.equalsIgnoreCase("q")) { // If the input is "q" (case-insensitive), the loop breaks.
                break;
            }

            try {
                double grade = Double.parseDouble(input); // Parses the string input as a double grade.
                grades.add(grade); // Adds the parsed grade to the ArrayList.
            } catch (NumberFormatException e) { // Catches NumberFormatException if the input is not a valid number.
                System.out.println("Invalid input. Please enter a valid grade or 'q' to quit.");
            }
        }

        if (grades.isEmpty()) { // If no grades were entered, prints a message and exits.
            System.out.println("No grades entered. Exiting the program.");
            return;
        }

        // Calculate and display statistics.
        System.out.println("\n--- Grade Summary ---");
        System.out.printf("Average Score: %.2f\n", calculateAverage(grades)); // Displays the average score formatted to two decimal places.
        System.out.printf("Highest Score: %.2f\n", findHighest(grades)); // Displays the highest score.
        System.out.printf("Lowest Score: %.2f\n", findLowest(grades)); // Displays the lowest score.

        scanner.close(); // Closes the scanner to release resources.
    }

    /**
     * Calculates the average of a list of grades.
     *
     * @param grades The ArrayList containing student grades.
     * @return The average of the grades.
     */
    public static double calculateAverage(ArrayList<Double> grades) {
        if (grades.isEmpty()) { // Handles the case of an empty list to avoid division by zero.
            return 0.0;
        }
        double sum = 0;
        for (double grade : grades) { // Iterates through the grades and sums them up.
            sum += grade;
        }
        return sum / grades.size(); // Returns the average.
    }

    /**
     * Finds the highest score in a list of grades.
     *
     * @param grades The ArrayList containing student grades.
     * @return The highest score.
     */
    public static double findHighest(ArrayList<Double> grades) {
        if (grades.isEmpty()) { // Handles the case of an empty list.
            return 0.0; // Or throw an exception if appropriate.
        }
        double highest = grades.get(0); // Initializes the highest score with the first grade.
        for (int i = 1; i < grades.size(); i++) { // Iterates from the second grade onwards.
            if (grades.get(i) > highest) { // Compares each grade to the current highest.
                highest = grades.get(i); // Updates the highest score if a larger grade is found.
            }
        }
        return highest; // Returns the highest score found.
    }

    /**
     * Finds the lowest score in a list of grades.
     *
     * @param grades The ArrayList containing student grades.
     * @return The lowest score.
     */
    public static double findLowest(ArrayList<Double> grades) {
        if (grades.isEmpty()) { // Handles the case of an empty list.
            return 0.0; // Or throw an exception if appropriate.
        }
        double lowest = grades.get(0); // Initializes the lowest score with the first grade.
        for (int i = 1; i < grades.size(); i++) { // Iterates from the second grade onwards.
            if (grades.get(i) < lowest) { // Compares each grade to the current lowest.
                lowest = grades.get(i); // Updates the lowest score if a smaller grade is found.
            }
        }
        return lowest; // Returns the lowest score found.
    }
}
