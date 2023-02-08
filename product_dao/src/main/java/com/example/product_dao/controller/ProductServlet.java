package com.example.product_dao.controller;
import com.example.product_dao.model.Category;
import com.example.product_dao.model.Product;
import com.example.product_dao.service.ProductService;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.List;


@WebServlet(name = "ProductServlet", value = "/products")
public class ProductServlet extends HttpServlet {
    private ProductService productService = new ProductService();

    public ProductServlet() {
    }
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }
        switch (action) {
            case "create":
                createProductGet(request, response);
                break;
            case "delete":
                deleteProduct(request, response);
                break;
            case "update":
                updateProduct(request, response);
                break;
            case "deleteCategory":
                deleteCategory(request,response);
                break;
            default:
                displayProduct(request, response);
        }

    }
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }
        switch (action) {
            case "create":
                create(request, response);
                break;
            case "update":
                updateForm(request, response);
                break;
            case "createCategory":
                createCategory(request,response);
                displayCategory(request,response);
                break;
            default:
                displayProduct(request, response);

        }
    }
    private void displayProduct(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher rd = request.getRequestDispatcher("displayList.jsp");
        request.setAttribute("products", productService.findAll());
        rd.forward(request, response);
    }


    private void createProductGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher rd = request.getRequestDispatcher("create.jsp");
        request.setAttribute("listCategory",productService.productDAO.getCategoryList());
        rd.forward(request, response);
    }
    private void create(HttpServletRequest request, HttpServletResponse response) throws IOException {

        String name = request.getParameter("name");
        Double price = Double.parseDouble(request.getParameter("price"));
        Integer quantity = Integer.parseInt(request.getParameter("quantity"));
        Category category = productService.categoryService.
                findCategoryById(Integer.parseInt(request.getParameter("category")));

        productService.createProduct(new Product(name, price, quantity,category));
        response.sendRedirect("/products");
    }

    private void updateProduct(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher rd = request.getRequestDispatcher("update.jsp");
        request.setAttribute("listCategory",productService.productDAO.getCategoryList());
        int id = Integer.parseInt(request.getParameter("id"));
        request.setAttribute("product", productService.findById(id));
        rd.forward(request, response);
    }
    private void updateForm(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
       int id = Integer.parseInt(request.getParameter("id"));
        String name = request.getParameter("name");
        Double price = Double.parseDouble(request.getParameter("price"));
        Integer quantity = Integer.parseInt(request.getParameter("quantity"));
        Category category = productService.categoryService.
                findCategoryById(Integer.parseInt(request.getParameter("category")));
        productService.productDAO.updateProduct(new Product(id,name, price, quantity,category));
        response.sendRedirect("/products");

    }
    private void deleteProduct(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String id = request.getParameter("id");
        productService.productDAO.deleteProduct(id);
        response.sendRedirect("/products");
    }
    public void createCategory(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        String name = request.getParameter("name");
        productService.productDAO.setCategoryList(new Category(name));
    }
    public void displayCategory(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher rd = request.getRequestDispatcher("displayCategory.jsp");
        request.setAttribute("categoryList",productService.productDAO.getCategoryList());
        rd.forward(request, response);
    }
    private void deleteCategory(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String id = request.getParameter("id");
       productService.productDAO.deleteCategoryById(id);
    }


}
