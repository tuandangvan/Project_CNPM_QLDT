package Controller.admin;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Dao.IAccountDao;
import Dao.Impl.AccountDaoImpl;
import Models.AccountModel;

@SuppressWarnings("serial")
@WebServlet(urlPatterns = {"/admin/manage-account/change-pass"})
public class EditPassByAdminController extends HttpServlet{

	IAccountDao accountDao = new AccountDaoImpl();
	
	private String username = "";
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		username = req.getParameter("username");
		AccountModel account = new AccountModel();
		account = accountDao.get(username);
		
		req.setAttribute("account", account);
		
		RequestDispatcher dispatcher = req.getRequestDispatcher("/views/admin/edit-account.jsp");
		dispatcher.forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		try {
			resp.setContentType("text/html");
			req.setCharacterEncoding("UTF-8");
			
			AccountModel account = new AccountModel();
			account.setPassword(req.getParameter("password"));
			account.setUsername(username);
			
			accountDao.changePassByAdmin(account);
			resp.sendRedirect(req.getContextPath() + "/admin/manage-account");
		} catch (Exception e) {
			resp.sendRedirect(req.getContextPath() + "/admin/manage-account");
			e.printStackTrace();
		}
	}
	
}
