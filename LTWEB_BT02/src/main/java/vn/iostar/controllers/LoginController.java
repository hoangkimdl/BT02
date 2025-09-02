package vn.iostar.controllers;

import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;

import vn.iostar.models.User;
import vn.iostar.services.UserService;
import vn.iostar.services.impl.UserServicesImpl;

@SuppressWarnings("serial")
@WebServlet(urlPatterns = "/login")
public class LoginController extends HttpServlet {

	public static final String COOKIE_REMEMBER = "remember_username";

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession session = req.getSession(false);

		// Nếu đã có session, redirect tới /waiting để set message và redirect theo role
		if (session != null && session.getAttribute("account") != null) {
			resp.sendRedirect(req.getContextPath() + "/waiting");
			return;
		}

		// Kiểm tra cookie "remember me"
		Cookie[] cookies = req.getCookies();
		if (cookies != null) {
			for (Cookie cookie : cookies) {
				if (COOKIE_REMEMBER.equals(cookie.getName())) {
					UserService service = new UserServicesImpl();
					User user = service.findByUsername(cookie.getValue());
					if (user != null) {
						session = req.getSession(true);
						session.setAttribute("account", user);
						resp.sendRedirect(req.getContextPath() + "/waiting");
						return;
					}
				}
			}
		}

		// Nếu không có session và cookie, hiển thị trang login
		req.getRequestDispatcher("/views/login.jsp").forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html;charset=UTF-8");
		req.setCharacterEncoding("UTF-8");

		String username = req.getParameter("username");
		String password = req.getParameter("password");
		boolean isRememberMe = "on".equals(req.getParameter("remember"));

		// Kiểm tra dữ liệu trống
		if (username == null || username.isEmpty() || password == null || password.isEmpty()) {
			req.setAttribute("alert", "Tài khoản hoặc mật khẩu không được rỗng");
			req.getRequestDispatcher("/views/login.jsp").forward(req, resp);
			return;
		}

		UserService service = new UserServicesImpl();
		User user = service.login(username, password);

		if (user != null) {
			HttpSession session = req.getSession(true);
			session.setAttribute("account", user);

			// Lưu cookie nếu chọn remember me
			if (isRememberMe) {
				saveRememberMe(resp, username);
			}

			// Redirect tới /waiting để set message và redirect theo role
			resp.sendRedirect(req.getContextPath() + "/waiting");

		} else {
			req.setAttribute("alert", "Tài khoản hoặc mật khẩu không đúng");
			req.getRequestDispatcher("/views/login.jsp").forward(req, resp);
		}
	}

	private void saveRememberMe(HttpServletResponse response, String username) {
		Cookie cookie = new Cookie(COOKIE_REMEMBER, username);
		cookie.setMaxAge(30 * 60); // 30 phút
		response.addCookie(cookie);
	}
}
