package Controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Dao.ISignUpDao;
import Dao.Impl.SignUpDaoImpl;
import Models.SignUpModel;

@SuppressWarnings("serial")
@WebServlet(urlPatterns = {"/home/TinTuGiaoVu"})
public class TinTuGiaoVuController extends HttpServlet{

	ISignUpDao signUp = new SignUpDaoImpl();
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		int id = Integer.parseInt(req.getParameter("id"));
		SignUpModel sign = signUp.get(id);
		req.setAttribute("sign",sign);
		
		List<SignUpModel> signs = signUp.getAll();
		req.setAttribute("sign",sign);
		req.setAttribute("signs",signs);
		RequestDispatcher dispatcher = req.getRequestDispatcher("/views/TinTuGiaoVu.jsp");
		dispatcher.forward(req, resp);
	}
	
}
