import java.util.*;
import model.Product;
import dao.productDAO;
import java.util.UUID;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        productDAO dao = new productDAO();

        while (true) {
            printMenu();

            System.out.print("Enter your choice: ");
            int choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {
                case 1:
                    System.out.println("\n--- Add Product ---");

                    System.out.print("Enter product name: ");
                    String name = sc.nextLine();

                    System.out.print("Enter quantity: ");
                    int qty = sc.nextInt();

                    System.out.print("Enter price: ");
                    double price = sc.nextDouble();
                    sc.nextLine();

                    String id = UUID.randomUUID().toString();
                    Product p = new Product(id, name, qty, price);

                    dao.addProduct(p);

                    System.out.println("Product added successfully!\n");
                    break;

                case 2:
                    System.out.println("\n--- Product List ---");

                    List<Product> products = dao.getAllProducts();

                    for (Product prod : products) {
                        System.out.println(
                                prod.getId() + " | " +
                                        prod.getName() + " | Qty: " +
                                        prod.getQuantity() + " | Price: " +
                                        prod.getPrice()
                        );
                    }

                    break;

                case 3:
                    System.out.println("\n--- Update Product ---");

                    System.out.print("Enter product ID: ");
                    String updateId = sc.nextLine();

                    System.out.print("Enter new name: ");
                    String newName = sc.nextLine();

                    System.out.print("Enter new quantity: ");
                    int newQty = sc.nextInt();

                    System.out.print("Enter new price: ");
                    double newPrice = sc.nextDouble();
                    sc.nextLine();

                    Product updatedProduct = new Product(updateId, newName, newQty, newPrice);
                    dao.updateProduct(updatedProduct);

                    System.out.println("Product updated successfully!\n");
                    break;

                case 4:
                    System.out.println("\n--- Delete Product ---");

                    System.out.print("Enter product ID: ");
                    String deleteId = sc.nextLine();

                    dao.deleteProduct(deleteId);

                    System.out.println("Product deleted successfully!\n");
                    break;

                case 5:
                    System.out.println("\n--- Stock In ---");

                    System.out.print("Enter product ID: ");
                    String stockInId = sc.nextLine();

                    System.out.print("Enter quantity to add: ");
                    int addQty = sc.nextInt();
                    sc.nextLine();

                    dao.increaseStock(stockInId, addQty);

                    System.out.println("Stock increased successfully!\n");
                    break;

                case 6:
                    System.out.println("\n--- Stock Out ---");

                    System.out.print("Enter product ID: ");
                    String stockOutId = sc.nextLine();

                    System.out.print("Enter quantity to remove: ");
                    int removeQty = sc.nextInt();
                    sc.nextLine();

                    dao.decreaseStock(stockOutId, removeQty);

                    System.out.println("Stock decreased successfully!\n");
                    break;

                case 0:
                    System.out.println("\nExiting system... Goodbye!");
                    System.exit(0);
                    break;

                default:
                    System.out.println("\nInvalid choice. Please try again.\n");
            }
        }
    }

    public static void printMenu() {
        System.out.println("\n======================================");
        System.out.println("   INVENTORY MANAGEMENT SYSTEM");
        System.out.println("======================================");
        System.out.println("1. Add Product");
        System.out.println("2. View Products");
        System.out.println("3. Update Product");
        System.out.println("4. Delete Product");
        System.out.println("5. Stock In");
        System.out.println("6. Stock Out");
        System.out.println("0. Exit");
        System.out.println("======================================");
    }
}