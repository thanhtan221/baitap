package controller;


import model.Product;
import service.ProductService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

@WebServlet(value = "/product")
public class ProductServlet extends HttpServlet {
    ProductService productService = new ProductService();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        request.setCharacterEncoding("utf-8");
        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }
        try {
            switch (action) {
                case "addproduct":
                    ShowAddProduct(request, response);
                    break;
                case"editproduct":
                    ShowEditProduct(request,response);
                    break;
                case"deleteproduct":
                    DeleteProduct(request,response);
                    break;
                case"seachproduct":
                    SeachProduct(request,response);
                    break;
                default:
                    ListProduct(request, response);
                    break;
            }
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        request.setCharacterEncoding("utf-8");
        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }
        switch (action) {
            case "addproduct":
                AddProduct(request, response);
                break;
            case"editproduct":
                EditProduct(request,response);
                break;
            case"seachproduct":
                SeachProduct(request,response);
                break;
            default:
                ListProduct(request, response);
                break;
        }
    }

    public void ListProduct(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Product> productList = productService.SeleProduct();
        request.setAttribute("productlist", productList);
        RequestDispatcher dispatcher = request.getRequestDispatcher("index.jsp");
        dispatcher.forward(request, response);
    }

    public void AddProduct(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String name = request.getParameter("name");
        long price = Long.parseLong(request.getParameter("price"));
        long quantity = Long.parseLong(request.getParameter("quantity"));
        String color = request.getParameter("color");
        String category = request.getParameter("category");
        Product product = new Product(name, price, quantity, color, category);
        productService.AddUser(product);
        RequestDispatcher dispatcher = request.getRequestDispatcher("AddProduct.jsp");
        dispatcher.forward(request, response);
    }

    private void ShowAddProduct(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher dispatcher = request.getRequestDispatcher("AddProduct.jsp");
        dispatcher.forward(request, response);

    }

    public void EditProduct(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        String name =request.getParameter("name");
        long price = Long.parseLong(request.getParameter("price"));
        long quantity = Long.parseLong(request.getParameter("quantity"));
        String color = request.getParameter("color");
        String category =request.getParameter("category");
        Product product =new Product(id,name,price,quantity,color,category);
        productService.EditProduct(product);
        RequestDispatcher dispatcher = request.getRequestDispatcher("EditProduct.jsp");
        dispatcher.forward(request, response);
    }
    private void ShowEditProduct(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
       productService.Showproduct(id);
        RequestDispatcher dispatcher = request.getRequestDispatcher("EditProduct.jsp");
        dispatcher.forward(request, response);

    }

    public void DeleteProduct(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        productService.deleteUser(id);
        List<Product> productList = productService.SeleProduct();
        request.setAttribute("productlist", productList);
        RequestDispatcher dispatcher = request.getRequestDispatcher("index.jsp");
        dispatcher.forward(request, response);
    }
    public void SeachProduct(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException {
        String name = request.getParameter("name");
       productService.Seachproduct(name);
        List<Product> productList = productService.Seachproduct(name);
        request.setAttribute("productlist", productList);
        RequestDispatcher dispatcher = request.getRequestDispatcher("index.jsp");
        dispatcher.forward(request, response);

    }
}
