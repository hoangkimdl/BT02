package vn.iostar.controllers;

import java.io.IOException;
import jakarta.servlet.*;
import jakarta.servlet.annotation.*;
import jakarta.servlet.http.*;

import vn.iostar.service.CategoryService;
import vn.iostar.service.impl.CategoryServiceImpl;

@WebServlet("/admin/category/delete")
public class CategoryeDeleteController extends HttpServlet {
    private CategoryService service = new CategoryServiceImpl();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int id = Integer.parseInt(req.getParameter("id"));
        service.delete(id);
        resp.sendRedirect(req.getContextPath() + "/admin/category/list");
    }
}
