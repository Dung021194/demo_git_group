package com.example.product_dao.service;

import com.example.product_dao.DAO.ProductDAO;
import com.example.product_dao.model.Product;

import java.util.ArrayList;
import java.util.List;

public class ProductService {
    public ProductDAO productDAO ;
    public CategoryService categoryService;
    public ProductService() {
        productDAO= new ProductDAO();
        categoryService = new CategoryService();
        }
    public List<Product> findAll() {
        return productDAO.getProductList();
    }
    public Product findById(int id) {
        for (Product p: findAll()) {
            if (p.getId()==id){
                return p;
            }
        }
        return null;
    }
    public void createProduct(Product product) {
      findAll().add(product);
        productDAO.setProductList(product);
    }

    public void deleteProduct(int id) {
        findAll().remove(findById(id));
    }

}
