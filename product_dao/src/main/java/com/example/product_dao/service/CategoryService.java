package com.example.product_dao.service;

import com.example.product_dao.DAO.ProductDAO;
import com.example.product_dao.model.Category;

import java.util.ArrayList;
import java.util.List;

public class CategoryService {
    ProductDAO productDAO = new ProductDAO();
    private final List<Category> categoryList;


    public CategoryService() {
       categoryList = productDAO.getCategoryList();
    }
    public Category findCategoryById(int id){
        for (Category c : categoryList){
            if (c.getId()==id){
                return c;
            }
        }
        return null;
    }
    public void createCategory(Category category){
        categoryList.add(category);
    }
    public List<Category> findAll(){
        return categoryList;
    }
    public void deleteCategoryById(int id){
        for (Category c:categoryList) {
            if (c.getId()==id){
                categoryList.remove(c);
                break;
            }
        }
    }


}
