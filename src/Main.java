import java.util.*;

class Product {
    int id;
    String name;
    int quantity;
    double price;

    Product(int id, String name, int quantity, double price) {
        this.id = id;
        this.name = name;
        this.quantity = quantity;
        this.price = price;
    }

    public String toString() {
        return "ID: " + id + ", Name: " + name +
                ", Quantity: " + quantity + ", Price: " + price;


    }
}

public class Main {

    static ArrayList<Product> inventory = new ArrayList<>();
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {


        while (true) {
            System.out.println("\n--- Inventory Menu ---");
            System.out.println("1. ADD PRODUCT");
            System.out.println("2. UPDATE QUANTITY");
            System.out.println("3. REMOVE PRODUCT");
            System.out.println("4. View PRODUCTS");
            System.out.println("5. EXIT");

            int choice=sc.nextInt();

            switch (choice) {
                case 1:
                    addProduct();
                    break;
                case 2:
                    updateProduct();
                break;
                case 3:
                    removeProduct();
                break;
                case 4:
                    viewProducts(); break;
                case 5:
                    System.exit(0);

                default: System.out.println("Invalid choice!");
            }
        }
    }


    public static void addProduct() {
        System.out.print("Enter ID: ");
        int id = sc.nextInt();
        sc.nextLine();

        System.out.print("Enter Name: ");
        String name = sc.nextLine();

        System.out.print("Enter Quantity: ");
        int quantity = sc.nextInt();

        System.out.print("Enter Price: ");
        double price = sc.nextDouble();

        inventory.add(new Product(id, name, quantity, price));
        System.out.println("Product added successfully!");


    }

    public static void updateProduct() {
        System.out.print("Enter Product ID to update: ");
        int id = sc.nextInt();

        for (Product p : inventory) {
            if (p.id == id) {
                System.out.print("Enter new quantity: ");
                p.quantity = sc.nextInt();
                System.out.println("Updated successfully!");
                return;
            }
        }
        System.out.println("Product not found!");
    }

    static void removeProduct() {
        System.out.print("Enter Product ID to remove: ");
        int id = sc.nextInt();

        Iterator<Product> it = inventory.iterator();

        while (it.hasNext()) {     //
            Product p = it.next();
            if (p.id == id) {
                it.remove();
                System.out.println("Product removed!");
                return;
            }
        }
        System.out.println("Product not found!");
    }

    static void viewProducts() {
        if (inventory.isEmpty()) {
            System.out.println("Inventory is empty!");
            return;
        }

        for (Product p : inventory) {
            System.out.println(p);
        }
    }
}