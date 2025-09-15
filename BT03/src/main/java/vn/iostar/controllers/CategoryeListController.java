package vn.iostar.controllers;

import java.io.IOException;
import java.util.List;
import jakarta.servlet.*;
import jakarta.servlet.annotation.*;
import jakarta.servlet.http.*;

import vn.iostar.model.Category;
import vn.iostar.service.CategoryService;
import vn.iostar.service.impl.CategoryServiceImpl;

@WebServlet("/admin/category/list")
public class CategoryeListController extends HttpServlet {
    private CategoryService service = new CategoryServiceImpl();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // Lấy tham số từ request
        String pageStr = req.getParameter("page");
        String recordsPerPageStr = req.getParameter("recordsPerPage");
        String search = req.getParameter("search") != null ? req.getParameter("search") : "";

        int page = (pageStr != null) ? Integer.parseInt(pageStr) : 1;
        int recordsPerPage = (recordsPerPageStr != null) ? Integer.parseInt(recordsPerPageStr) : 10;

        int offset = (page - 1) * recordsPerPage; 

        // Lấy danh sách và tổng số từ service
        List<Category> cateList = service.searchAndPaginate(search, offset, recordsPerPage);
        int totalCategories = service.countCategories(search);
        int totalPages = (int) Math.ceil((double) totalCategories / recordsPerPage);

        // Set attribute cho JSP
        req.setAttribute("cateList", cateList);
        req.setAttribute("totalPages", totalPages);
        req.setAttribute("currentPage", page);
        req.setAttribute("recordsPerPage", recordsPerPage);
        req.setAttribute("search", search);

        req.getRequestDispatcher("/views/admin/list-category.jsp").forward(req, resp);
        HttpSession session = req.getSession(false);
        if (session == null || session.getAttribute("user") == null) {
            resp.sendRedirect(req.getContextPath() + "/views/login.jsp");
            return;
        }
    }
}