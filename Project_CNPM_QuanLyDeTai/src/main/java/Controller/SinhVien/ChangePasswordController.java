package Controller.SinhVien;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Dao.IAccountDao;
import Dao.Impl.AccountDaoImpl;
import Models.AccountModel;

@SuppressWarnings("serial")
@WebServlet(urlPatterns = { "/student/doimatkhau" })
public class ChangePasswordController extends HttpServlet {

	public ChangePasswordController() {
		super();
		// TODO Auto-generated constructor stub
	}

	IAccountDao iacc = new AccountDaoImpl();

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		RequestDispatcher dispatcher = request.getRequestDispatcher("/views/ChangePassword.jsp");
		dispatcher.forward(request, response);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession session = request.getSession();
		AccountModel acc = (AccountModel) session.getAttribute("account");
		String pass = request.getParameter("password");
		String newpass = request.getParameter("newpassword");
		String retypenewpass = request.getParameter("retypepassword");
		String alertmg = null;

		if (acc.getPassword().equals(pass)) {
			if (newpass.equals(retypenewpass)) {
				iacc.editPassword(acc, newpass);
				acc.setPassword(newpass);
				alertmg = "Đổi mật khẩu thành công";
				request.setAttribute("alerts", alertmg);
			} else {
				alertmg = "Đổi mật khẩu không thành công";
				request.setAttribute("alerts", alertmg);
			}
		} else {
			alertmg = "Đổi mật khẩu không thành công";
			request.setAttribute("alerts", alertmg);
		}

		RequestDispatcher dispatcher = request.getRequestDispatcher("/views/ChangePassword.jsp");
		dispatcher.forward(request, response);
	}

}