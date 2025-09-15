package vn.iostar.controllers;

import java.io.*;
import jakarta.servlet.*;
import jakarta.servlet.annotation.*;
import jakarta.servlet.http.*;

import vn.iostar.model.Category;
import vn.iostar.service.CategoryService;
import vn.iostar.service.impl.CategoryServiceImpl;
import vn.iostar.util.Constant;

@WebServlet("/admin/category/add")
@MultipartConfig
public class CategoryAddController extends HttpServlet {
    private CategoryService service = new CategoryServiceImpl();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("/views/admin/add-category.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        String name = req.getParameter("name");

        Part filePart = req.getPart("icon");
        String fileName = filePart.getSubmittedFileName();
        if (!fileName.isEmpty()) {
            filePart.write(Constant.DIR + File.separator + fileName);
        }

        Category c = new Category();
        c.setName(name);
        c.setIcon(fileName);

        service.insert(c);
        resp.sendRedirect(req.getContextPath() + "/admin/category/list");
    }
}
