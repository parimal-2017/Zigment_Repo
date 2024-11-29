import java.util.Scanner;

public class Main {

    // Valid options for each field
    private static final String[] COMPANY_SIZES = {"1-50 employees", "51-200 employees", "201-1000 employees", "1000+ employees"};
    private static final String[] ANNUAL_BUDGETS = {"Less than $10,000", "$10,000 - $50,000", "$50,001 - $100,000", "More than $100,000"};
    private static final String[] INDUSTRIES = {"Technology", "Finance", "Healthcare", "Retail", "Other"};
    private static final String[] URGENCIES = {"Immediate", "Short-term", "Medium-term", "Long-term"};

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        LeadManagement leadManagement = new LeadManagement();

        while (true) {
            System.out.println("Enter lead details:");

            System.out.print("Name: ");
            String name = scanner.nextLine();

            String companySize = getValidInput(scanner, "Company Size (1-50 employees / 51-200 employees / 201-1000 employees / 1000+ employees): ", COMPANY_SIZES);
            String annualBudget = getValidInput(scanner, "Annual Budget (Less than $10,000 / $10,000 - $50,000 / $50,001 - $100,000 / More than $100,000): ", ANNUAL_BUDGETS);
            String industry = getValidInput(scanner, "Industry (Technology / Finance / Healthcare / Retail / Other): ", INDUSTRIES);
            String urgency = getValidInput(scanner, "Urgency of Need (Immediate / Short-term / Medium-term / Long-term): ", URGENCIES);

            // Create a new lead and add it to the system
            Lead newLead = new Lead(name, companySize, annualBudget, industry, urgency);
            leadManagement.addLead(newLead);

            System.out.print("Add another lead? (yes/no): ");
            String continueInput = scanner.nextLine();
            if (!continueInput.equalsIgnoreCase("yes")) {
                break;
            }
        }

        scanner.close();
    }

    // Method to validate user input against valid options
    private static String getValidInput(Scanner scanner, String promptMessage, String[] validOptions) {
        while (true) {
            System.out.print(promptMessage);
            String input = scanner.nextLine();

            for (String option : validOptions) {
                if (input.equalsIgnoreCase(option)) {
                    return option; // Return valid input
                }
            }

            System.out.println("Invalid input. Please enter one of the following options:");
            for (String option : validOptions) {
                System.out.println("- " + option);
            }
        }
    }
}
