import java.util.*;

class Destination {
    String name;
    Date startDate;
    Date endDate;
    double budget;

    public Destination(String name, Date startDate, Date endDate, double budget) {
        this.name = name;
        this.startDate = startDate;
        this.endDate = endDate;
        this.budget = budget;
    }

    @Override
    public String toString() {
        return "Destination: " + name + "\nStart Date: " + startDate + "\nEnd Date: " + endDate + "\nBudget: $" + budget;
    }
}

public class TravelItineraryPlanner {
    private static List<Destination> itinerary = new ArrayList<>();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.println("Welcome to Travel Itinerary Planner!");
        while (true) {
            System.out.println("\n1. Add Destination\n2. View Itinerary\n3. Calculate Total Budget\n4. Exit");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    addDestination();
                    break;
                case 2:
                    viewItinerary();
                    break;
                case 3:
                    calculateTotalBudget();
                    break;
                case 4:
                    System.out.println("Exiting... Safe Travels!");
                    return;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    private static void addDestination() {
        System.out.print("Enter destination name: ");
        String name = scanner.nextLine();
        System.out.print("Enter start date (yyyy-mm-dd): ");
        Date startDate = parseDate(scanner.nextLine());
        System.out.print("Enter end date (yyyy-mm-dd): ");
        Date endDate = parseDate(scanner.nextLine());
        System.out.print("Enter budget for this destination: ");
        double budget = scanner.nextDouble();
        scanner.nextLine(); // Consume newline

        itinerary.add(new Destination(name, startDate, endDate, budget));
        System.out.println("Destination added successfully!");
    }

    private static void viewItinerary() {
        if (itinerary.isEmpty()) {
            System.out.println("No destinations added yet.");
            return;
        }
        for (Destination dest : itinerary) {
            System.out.println(dest);
            System.out.println("----------------------");
        }
    }

    private static void calculateTotalBudget() {
        double totalBudget = 0;
        for (Destination dest : itinerary) {
            totalBudget += dest.budget;
        }
        System.out.println("Total Estimated Budget: $" + totalBudget);
    }

    private static Date parseDate(String dateStr) {
        try {
            return new java.text.SimpleDateFormat("yyyy-MM-dd").parse(dateStr);
        } catch (Exception e) {
            System.out.println("Invalid date format. Please use yyyy-mm-dd.");
            return new Date();
        }
    }
}

