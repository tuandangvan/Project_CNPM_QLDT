package Controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Login.UserService;
import Login.UserServiceImpl;
import Models.AccountModel;
import util.Constant;

@SuppressWarnings("serial")
@WebServlet(urlPatterns = { "/login" })
public class LoginController extends HttpServlet {

	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		resp.setContentType("text/htm");
		resp.setCharacterEncoding("UTF-8");
		req.setCharacterEncoding("UTF-8");

		HttpSession session = req.getSession(false);
		if (session != null && session.getAttribute("account") != null) {
			resp.sendRedirect(req.getContextPath() + "/waiting");
		}

		Cookie[] cookies = req.getCookies();
		if (cookies != null) {
			for (Cookie cookie : cookies) {
				if (cookie.getName().equals("username")) {
					session = req.getSession(true);
					session.setAttribute("username", cookie.getValue());
					resp.sendRedirect(req.getContextPath() + "/waiting");
					return;
				}
			}
		}

		req.getRequestDispatcher("/views/login.jsp").forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/htm");
		resp.setCharacterEncoding("UTF-8");
		req.setCharacterEncoding("UTF-8");

		String username = req.getParameter("username");
		String password = req.getParameter("password");

		boolean isRememberMe = false;
		String remember = req.getParameter("remember");
		if ("on".equals(remember)) {
			isRememberMe = true;
		}
		String alertMsg = null;

		if (username.isEmpty() || password.isEmpty()) {
			alertMsg = "Tài khoản hoặc mật khẩu không được rỗng";
			req.setAttribute("alerts", alertMsg);
			
			req.getRequestDispatcher("/views/login.jsp").forward(req, resp);
			return;
		}
		UserService service = new UserServiceImpl();

		AccountModel user = service.login(username, password);

		if (user != null) {
			HttpSession session = req.getSession(true);
			session.setAttribute("account", user);
			session.setMaxInactiveInterval(360000);
			if (isRememberMe) {
				saveRememberMe(resp, username);
			}
			resp.sendRedirect(req.getContextPath() + "/waiting");
		} else {
			alertMsg = "Tài Khoản hoặc mật khẩu không đúng";
			req.setAttribute("alerts", alertMsg);
			req.getRequestDispatcher("/views/login.jsp").forward(req, resp);
		}

	}
	
	
	  private void saveRememberMe(HttpServletResponse response,String username) {
	  Cookie cookie = new Cookie(Constant.COOKIE_REMEMBER,username);
	  cookie.setMaxAge(30*60); response.addCookie(cookie); 
	  }
}
