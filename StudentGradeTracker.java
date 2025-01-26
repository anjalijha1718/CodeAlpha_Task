import java.util.ArrayList;
import java.util.Scanner;

public class StudentGradeTracker {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<Double> grades = new ArrayList<>();
        
        System.out.println("Student Grade Tracker\n");

        boolean running = true;

        while (running) {
            System.out.println("Choose an option:");
            System.out.println("1. Enter a grade");
            System.out.println("2. View statistics (average, highest, lowest)");
            System.out.println("3. View all grades");
            System.out.println("4. Exit");

            int choice = scanner.nextInt();

            switch (choice) {
                case 1 -> {
                    System.out.print("Enter the grade (0-100): ");
                    double grade = scanner.nextDouble();
                    if (grade >= 0 && grade <= 100) {
                        grades.add(grade);
                        System.out.println("Grade added successfully!\n");
                    } else {
                        System.out.println("Invalid grade. Please enter a value between 0 and 100.\n");
                    }
                }
                case 2 -> {
                    if (grades.isEmpty()) {
                        System.out.println("No grades available to calculate statistics.\n");
                    } else {
                        double average = calculateAverage(grades);
                        double highest = findHighest(grades);
                        double lowest = findLowest(grades);
                        System.out.println("Statistics:");
                        System.out.printf("Average Grade: %.2f\n", average);
                        System.out.printf("Highest Grade: %.2f\n", highest);
                        System.out.printf("Lowest Grade: %.2f\n\n", lowest);
                    }
                }
                case 3 -> {
                    if (grades.isEmpty()) {
                        System.out.println("No grades have been entered yet.\n");
                    } else {
                        System.out.println("Grades:");
                        for (int i = 0; i < grades.size(); i++) {
                            System.out.printf("Student %d: %.2f\n", i + 1, grades.get(i));
                        }
                        System.out.println();
                    }
                }
                case 4 -> {
                    System.out.println("Exiting program. Goodbye!");
                    running = false;
                }
                default -> System.out.println("Invalid option. Please try again.\n");
            }
        }

        scanner.close();
    }

    private static double calculateAverage(ArrayList<Double> grades) {
        double sum = 0;
        for (double grade : grades) {
            sum += grade;
        }
        return sum / grades.size();
    }

    private static double findHighest(ArrayList<Double> grades) {
        double highest = grades.get(0);
        for (double grade : grades) {
            if (grade > highest) {
                highest = grade;
            }
        }
        return highest;
    }

    private static double findLowest(ArrayList<Double> grades) {
        double lowest = grades.get(0);
        for (double grade : grades) {
            if (grade < lowest) {
                lowest = grade;
            }
        }
        return lowest;
    }
}
