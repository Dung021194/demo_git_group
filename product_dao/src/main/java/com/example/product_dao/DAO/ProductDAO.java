package com.example.product_dao.DAO;

import com.example.product_dao.model.Category;
import com.example.product_dao.model.Product;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;


public class ProductDAO {

        String jdbcURL = "jdbc:mysql://localhost:3306/product_manager";
        String jdbcUsername = "root";
        String jdbcPassword = "123456";
       public List<Product> getProductList(){
           List<Product> list = new ArrayList<>();
           String query = "SELECT * FROM product_manager.product;";
           try {
               Class.forName("com.mysql.cj.jdbc.Driver");
               Connection conn = DriverManager.getConnection(jdbcURL,jdbcUsername,jdbcPassword);
               PreparedStatement ps = conn.prepareStatement(query);
               ResultSet rs = ps.executeQuery();
               while (rs.next()){
                   list.add(new Product(rs.getInt(1),rs.getString(2),rs.getDouble(3),
                           rs.getInt(4),getCategoryById(rs.getInt(5))));
               }


           } catch (SQLException | ClassNotFoundException e) {
               throw new RuntimeException(e);
           }
           return list;
       }
       public List<Category> getCategoryList(){
           String query = "select * from product_manager.category";
           List<Category> list = new ArrayList<>();

           try {
               Class.forName("com.mysql.cj.jdbc.Driver");
               Connection conn = DriverManager.getConnection(jdbcURL,jdbcUsername,jdbcPassword);
               PreparedStatement ps = conn.prepareStatement(query);
               ResultSet rs = ps.executeQuery();
               while (rs.next()){
                   list.add(new Category(rs.getInt(1),rs.getString(2)));
               }

           } catch (SQLException e) {
               throw new RuntimeException(e);
           } catch (ClassNotFoundException e) {
               throw new RuntimeException(e);
           }
           return list;

       }
    public Category getCategoryById(int id){
        String query = "select * from product_manager.category where id=?";
        Category category = null;

        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection conn = DriverManager.getConnection(jdbcURL,jdbcUsername,jdbcPassword);
            PreparedStatement ps = conn.prepareStatement(query);
            ps.setInt(1,id);
            ResultSet rs = ps.executeQuery();
            while (rs.next()){
                category = new Category(rs.getInt(1),rs.getString(2));
            }


        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }

        return category;

    }
    public void setProductList(Product product){
        String query = "insert into product (name,price,quantity,category) values (?,?,?,?)";

        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection conn = DriverManager.getConnection(jdbcURL,jdbcUsername,jdbcPassword);
            PreparedStatement ps = conn.prepareStatement(query);
                ps.setString(1,product.getName());
                ps.setDouble(2,product.getPrice());
                ps.setInt(3,product.getQuantity());
                ps.setInt(4,product.getCategory().getId());
                ps.executeUpdate();

            } catch (SQLException ex) {
            throw new RuntimeException(ex);
        } catch (ClassNotFoundException ex) {
            throw new RuntimeException(ex);
        }
    }
    public void updateProduct(Product product){
        String query = "update product set name = ?,price = ?,quantity=?,category=? where id = ?";

        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection conn = DriverManager.getConnection(jdbcURL,jdbcUsername,jdbcPassword);
            PreparedStatement ps = conn.prepareStatement(query);
            ps.setString(1,product.getName());
            ps.setDouble(2,product.getPrice());
            ps.setInt(3,product.getQuantity());
            ps.setInt(4,product.getCategory().getId());
            ps.setInt(5,product.getId());
            ps.executeUpdate();

        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        } catch (ClassNotFoundException ex) {
            throw new RuntimeException(ex);
        }

    }
    public void deleteProduct(String id){
        String query = "delete from product where id = ?";

        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection conn = DriverManager.getConnection(jdbcURL,jdbcUsername,jdbcPassword);
            PreparedStatement ps = conn.prepareStatement(query);
            ps.setString(1,id);
            ps.executeUpdate();

        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        } catch (ClassNotFoundException ex) {
            throw new RuntimeException(ex);
        }

    }
    public void setCategoryList(Category category){
        String query = "insert into category(name) values(?)";
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection conn = DriverManager.getConnection(jdbcURL,jdbcUsername,jdbcPassword);
            PreparedStatement ps = conn.prepareStatement(query);
                ps.setString(1,category.getName());
                ps.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
    public void deleteCategoryById(String id){
        String query = "delete from category where id = ?";

        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection conn = DriverManager.getConnection(jdbcURL,jdbcUsername,jdbcPassword);
            PreparedStatement ps = conn.prepareStatement(query);
            ps.setString(1,id);
            ps.executeUpdate();
        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        } catch (ClassNotFoundException ex) {
            throw new RuntimeException(ex);
        }

    }

        }




