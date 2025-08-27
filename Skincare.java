import java.util.*;

public class Skincare {

    private String brand;
    private String productType;
    private double rating;
    private int quantity;
    private String[] skinType;

    public Skincare(String brand, String productType, double rating, int quantity, String[] skinType) {
        this.brand = brand;
        this.productType = productType;
        this.rating = rating;
        this.quantity = quantity;
        this.skinType = skinType;
    }

    public void displayDetails() {
        System.out.println("Brand: " + brand);
        System.out.println("Product Type: " + productType);
        System.out.println("Rating: " + rating);
        System.out.println("Quantity: " + quantity + " ml");
        System.out.println("Suitable for: " + String.join(", ", skinType));
    }

    // better: compare THIS with another
    public void compareWith(Skincare other, String mySkinType) {
        if (this.productType.equals(other.productType)) {
            if (this.rating > other.rating && Arrays.asList(this.skinType).contains(mySkinType)) {
                System.out.println("Preferred Product:");
                this.displayDetails();
            } else if (other.rating > this.rating && Arrays.asList(other.skinType).contains(mySkinType)) {
                System.out.println("Preferred Product:");
                other.displayDetails();
            } else {
                System.out.println("Both products are equally good (or not suitable for your skin).");
            }
        } else {
            System.out.println("Products are of different types and cannot be compared.");
        }
    }
}

class Main {
    public static void main (String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Welcome to SkinCure!");
        System.out.println("We help you settle debates regarding which skincare product is better for you");
        System.out.print("Enter your skin type (e.g., oily, dry, combination, sensitive): ");
        String mySkinType = scanner.nextLine().toLowerCase();

        int choice = 0;
        while(choice != 1) {
            System.out.println("\n--- Product 1 ---");
            System.out.print("Enter brand of product 1: ");
            String brand1 = scanner.nextLine();
            System.out.print("Enter product type of product 1 (e.g., cleanser, moisturizer): ");
            String productType1 = scanner.nextLine().toLowerCase();
            System.out.print("Enter rating of product 1 (out of 5): ");
            double rating1 = scanner.nextDouble();
            System.out.print("Enter quantity of product 1 (in ml): ");
            int quantity1 = scanner.nextInt();
            scanner.nextLine(); // consume newline
            System.out.print("Enter skin types suitable for product 1 (comma-separated): ");
            String[] skinType1 = Arrays.stream(scanner.nextLine().toLowerCase().split(","))
                                       .map(String::trim)
                                       .toArray(String[]::new);

            Skincare product1 = new Skincare(brand1, productType1, rating1, quantity1, skinType1);

            System.out.println("\n--- Product 2 ---");
            System.out.print("Enter brand of product 2: ");
            String brand2 = scanner.nextLine();
            System.out.print("Enter product type of product 2 (e.g., cleanser, moisturizer): ");
            String productType2 = scanner.nextLine().toLowerCase();
            System.out.print("Enter rating of product 2 (out of 5): ");
            double rating2 = scanner.nextDouble();
            System.out.print("Enter quantity of product 2 (in ml): ");
            int quantity2 = scanner.nextInt();
            scanner.nextLine(); // consume newline
            System.out.print("Enter skin types suitable for product 2 (comma-separated): ");
            String[] skinType2 = Arrays.stream(scanner.nextLine().toLowerCase().split(","))
                                       .map(String::trim)
                                       .toArray(String[]::new);

            Skincare product2 = new Skincare(brand2, productType2, rating2, quantity2, skinType2);

            // compare
            product1.compareWith(product2, mySkinType);

            System.out.print("\nPress 1 to stop or any other number to compare more products: ");
            choice = scanner.nextInt();
            scanner.nextLine(); // consume newline
        }
        scanner.close();
    }
}