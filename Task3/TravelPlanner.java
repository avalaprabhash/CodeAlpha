import java.util.Scanner;
import java.util.HashMap;
import java.util.Map;

class Destination {
    private String name;
    private String startDate;
    private String endDate;
    private double estimatedCost;

    public Destination(String name, String startDate, String endDate, double estimatedCost) {
        this.name = name;
        this.startDate = startDate;
        this.endDate = endDate;
        this.estimatedCost = estimatedCost;
    }

    public String getName() {
        return name;
    }

    public String getStartDate() {
        return startDate;
    }

    public String getEndDate() {
        return endDate;
    }

    public double getEstimatedCost() {
        return estimatedCost;
    }
}

public class TravelPlanner {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Map<String, Destination> itinerary = new HashMap<>();

        while (true) {
            System.out.println("Options:");
            System.out.println("1. Add Destination");
            System.out.println("2. View Itinerary");
            System.out.println("3. Calculate Total Budget");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    System.out.print("Enter destination name: ");
                    String name = scanner.nextLine();
                    System.out.print("Enter start date (YYYY-MM-DD): ");
                    String startDate = scanner.nextLine();
                    System.out.print("Enter end date (YYYY-MM-DD): ");
                    String endDate = scanner.nextLine();
                    System.out.print("Enter estimated cost: $");
                    double cost = scanner.nextDouble();
                    scanner.nextLine(); // Consume newline
                    Destination destination = new Destination(name, startDate, endDate, cost);
                    itinerary.put(name, destination);
                    System.out.println("Destination added successfully!");
                    break;
                case 2:
                    System.out.println("Your Itinerary:");
                    for (Destination dest : itinerary.values()) {
                        System.out.println("Name: " + dest.getName() +
                                ", Start Date: " + dest.getStartDate() +
                                ", End Date: " + dest.getEndDate() +
                                ", Estimated Cost: $" + dest.getEstimatedCost());
                    }
                    break;
                case 3:
                    double totalBudget = itinerary.values().stream()
                            .mapToDouble(Destination::getEstimatedCost)
                            .sum();
                    System.out.println("Total estimated budget: $" + totalBudget);
                    break;
                case 4:
                    System.out.println("Exiting. Thank you!");
                    return;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }
}
