package dao;
import models.Product;
import database.DatabaseConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class productDAO {
    public static List<Product> getAllProducts() {
        List<Product> list = new ArrayList<>();

        try {
            Connection conn = DatabaseConnection.getConnection();
            String query = "SELECT * FROM products";

            PreparedStatement ps = conn.prepareStatement(query);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                Product p = new Product(
                        rs.getString("id"),
                        rs.getString("name"),
                        rs.getInt("quantity"),
                        rs.getDouble("price")
                );
                list.add(p);
            }

        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }

        return list;
    }

    public void updateProduct(Product product) {
        try {
            Connection conn = DatabaseConnection.getConnection();
            String query = "UPDATE products SET name=?, quantity=?, price=? WHERE id=?";

            PreparedStatement ps = conn.prepareStatement(query);
            ps.setString(1, product.getName());
            ps.setInt(2, product.getQuantity());
            ps.setDouble(3, product.getPrice());
            ps.setString(4, product.getId());

            ps.executeUpdate();

        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    public void deleteProduct(String id) {
        try {
            Connection conn = DatabaseConnection.getConnection();
            String query = "DELETE FROM products WHERE id=?";

            PreparedStatement ps = conn.prepareStatement(query);
            ps.setString(1, id);

            ps.executeUpdate();

        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    public void increaseStock(String id, int amount) {
        try {
            Connection conn = DatabaseConnection.getConnection();
            String query = "UPDATE products SET quantity = quantity + ? WHERE id=?";

            PreparedStatement ps = conn.prepareStatement(query);
            ps.setInt(1, amount);
            ps.setString(2, id);

            ps.executeUpdate();

        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    public void decreaseStock(String id, int amount) {
        try {
            Connection conn = DatabaseConnection.getConnection();
            String query = "UPDATE products SET quantity = quantity - ? WHERE id=?";

            PreparedStatement ps = conn.prepareStatement(query);
            ps.setInt(1, amount);
            ps.setString(2, id);

            ps.executeUpdate();

        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
