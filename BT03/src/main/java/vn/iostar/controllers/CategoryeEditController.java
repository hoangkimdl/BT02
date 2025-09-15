package vn.iostar.controllers;

import java.io.*;
import jakarta.servlet.*;
import jakarta.servlet.annotation.*;
import jakarta.servlet.http.*;

import vn.iostar.model.Category;
import vn.iostar.service.CategoryService;
import vn.iostar.service.impl.CategoryServiceImpl;
import vn.iostar.util.Constant;

@WebServlet("/admin/category/edit")
@MultipartConfig
public class CategoryeEditController extends HttpServlet {
    private CategoryService service = new CategoryServiceImpl();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int id = Integer.parseInt(req.getParameter("id"));
        Category cate = service.findById(id);
        req.setAttribute("category", cate);
        req.getRequestDispatcher("/views/admin/edit-Category.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        int id = Integer.parseInt(req.getParameter("id"));
        String name = req.getParameter("name");

        Part filePart = req.getPart("icon");
        String fileName = filePart.getSubmittedFileName();

        Category cate = service.findById(id);
        cate.setName(name);

        if (fileName != null && !fileName.isEmpty()) {
            filePart.write(Constant.DIR + File.separator + fileName);
            cate.setIcon(fileName);
        }
        service.update(cate);

        resp.sendRedirect(req.getContextPath() + "/admin/category/list");
    }
}
