package vn.iostar.controllers;

import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;

@SuppressWarnings("serial")
@WebServlet(urlPatterns = {"/logout"})
public class LogoutController extends HttpServlet {
	@Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession(false); // lấy session hiện tại
        if (session != null) {
            session.invalidate(); // hủy session
        }
        resp.sendRedirect(req.getContextPath() + "/views/login.jsp");
    }
}
