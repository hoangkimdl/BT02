package vn.iostar.controllers;

import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;

import vn.iostar.models.User;
import vn.iostar.services.UserService;
import vn.iostar.services.Impl.UserServiceImpl;

@SuppressWarnings("serial")
@WebServlet(urlPatterns = {"/forget-password"})
public class ForgetPasswordController extends HttpServlet {

    private UserService service = new UserServiceImpl();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        req.getRequestDispatcher("/views/forget-password.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");

        String email = req.getParameter("email");

        User user = service.findByEmail(email);

        if (user != null) {
            // Ở đây bạn có thể gửi mail reset mật khẩu thật sự
            req.setAttribute("message", "Mật khẩu của bạn là: " + user.getPassword());
        } else {
            req.setAttribute("alert", "Email không tồn tại trong hệ thống!");
        }

        req.getRequestDispatcher("/views/forget-password.jsp").forward(req, resp);
    }
}
