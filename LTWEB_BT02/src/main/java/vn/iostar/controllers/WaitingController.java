package vn.iostar.controllers;

import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;

import vn.iostar.models.User;

@WebServlet("/waiting")
public class WaitingController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession(false);
        if (session != null && session.getAttribute("account") != null) {
            User u = (User) session.getAttribute("account");

            // Set message chào mừng
            session.setAttribute("message", "Xin chào, " + u.getFullName() + "!");

            // Redirect theo role
            if (u.getRoleid() == 1) {
                resp.sendRedirect(req.getContextPath() + "/admin/home");
            } else if (u.getRoleid() == 2) {
                resp.sendRedirect(req.getContextPath() + "/manager/home");
            } else {
                resp.sendRedirect(req.getContextPath() + "/home");
            }
        } else {
            resp.sendRedirect(req.getContextPath() + "/login");
        }
    }
}
