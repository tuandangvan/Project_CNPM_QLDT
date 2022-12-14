package Controller;

import java.io.IOException;

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
@WebServlet(urlPatterns = {"/home/RegistrationInstructions"})
public class RegistrationInstructionsController extends HttpServlet{

	ISignUpDao signUp = new SignUpDaoImpl();
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		SignUpModel sign = signUp.getTop();
		req.setAttribute("sign",sign);
		RequestDispatcher dispatcher = req.getRequestDispatcher("/views/RegistrationInstructions.jsp");
		dispatcher.forward(req, resp);
	}
	
}
