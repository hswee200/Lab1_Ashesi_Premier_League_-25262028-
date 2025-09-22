import java.util.Scanner;

public class PlayerSelection {
    final static double POUND_TO_KG = 0.45359237;
    final static int METER_TO_CM = 100;
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        short age;
        float height;
        double weight;
        int jerseyNumber;

        // --- Step 1: Collect Player Details ---
        System.out.print("Enter player name: ");
        String name = input.nextLine();

        System.out.print("Enter age: ");
        age = input.nextShort();

        System.out.print("Enter height (in meters): ");
        height = input.nextFloat();

        System.out.print("Enter weight (in pounds): ");
        weight = input.nextDouble();

        System.out.print("Enter jersey number: ");
        jerseyNumber = input.nextInt();

        // --- Step 2: Conversions ---
        int heightInCm = (int) (height * METER_TO_CM);
        int weightInKg = (int) (weight * POUND_TO_KG);

        // --- Step 3: Category ---
        String category;
        if (age < 20)
            category = "Rising Star";
        else if (age <= 30)
            category = "Prime Player";
        else
            category = "Veteran";

        // --- Step 4: Position ---
        String position;
        switch (jerseyNumber) {
            case 1: position = "Goalkeeper"; break;
            case 2, 5: position = "Defender"; break;
            case 6, 8: position = "Midfielder"; break;
            case 7, 11: position = "Winger"; break;
            case 9: position = "Striker"; break;
            case 10: position = "Playmaker"; break;
            default: position = "Unknown"; break;
        }

        // --- Step 5: Attacker Jersey ---
        boolean attacker = (jerseyNumber == 7 || jerseyNumber == 9 || jerseyNumber == 10 || jerseyNumber == 11);

        // --- Step 6: Eligibility ---
        boolean eligibility = (age >= 18 && age <= 35 && weightInKg < 90);

        // --- Step 7: Lineup Decision (Nested If) ---
        String lineupDecision;
        if (category.equals("Prime Player")) {
            if (weightInKg < 80)
                lineupDecision = "Starting Lineup";
            else
                lineupDecision = "Bench";
        } else {
            lineupDecision = "Bench";
        }

        // --- Step 8: Final Decision (Ternary) ---
        String finalDecision = eligibility ? "Play" : "Rest";

        // --- Step 9: Print Player Report ---
        System.out.println("\n--- Player Report ---");
        System.out.println("Player: " + name);
        System.out.println("Age: " + age + " (" + category + ")");
        System.out.println("Height: " + heightInCm + " cm");
        System.out.println("Weight: " + weightInKg + " kg");
        System.out.println("Jersey: " + jerseyNumber);
        System.out.println("Position: " + position);
        System.out.println("Attacker jersey: " + (attacker ? "Yes" : "No"));
        System.out.println("Eligibility: " + (eligibility ? "Eligible" : "Not Eligible"));
        System.out.println("Lineup Decision: " + lineupDecision);
        System.out.println("Final Decision: " + finalDecision);

        // --- Step 10: Unwanted Fall-through  ---
        System.out.println("\n--- Fall-through Demo ---");
        switch (jerseyNumber) {
            case 2:
                System.out.println("Defender");
            case 6:
                System.out.println("Midfielder");
            case 7:
                System.out.println("Winger");
            default:
                System.out.println("Player Position not found.");
        }

        input.close();
    }
}

