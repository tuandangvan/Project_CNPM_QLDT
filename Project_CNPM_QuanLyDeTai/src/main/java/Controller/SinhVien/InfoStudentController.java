package Controller.SinhVien;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Dao.IMajorsDao;
import Dao.ISignUpDao;
import Dao.IStudentsDao;
import Dao.Impl.MajorsDaoImpl;
import Dao.Impl.SignUpDaoImpl;
import Dao.Impl.StudentsDaoImpl;
import Models.AccountModel;
import Models.MajorsModel;
import Models.SignUpModel;
import Models.StudentsModel;

@SuppressWarnings("serial")
@WebServlet(urlPatterns = { "/student/info" })
public class InfoStudentController extends HttpServlet {

	IStudentsDao studentsDao = new StudentsDaoImpl();
	IMajorsDao majorsDao = new MajorsDaoImpl();

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		ISignUpDao signUp = new SignUpDaoImpl();
		List<SignUpModel> signs = signUp.getAll();
		req.setAttribute("signs", signs);

		List<MajorsModel> lstMajor = majorsDao.getAll();
		req.setAttribute("lstMajor", lstMajor);

		HttpSession session = req.getSession();
		if (session != null && session.getAttribute("account") != null) {
			AccountModel account = (AccountModel) session.getAttribute("account");
			
			StudentsModel student = studentsDao.findStudentByEmail(account.getUsername());

			//StudentsModel student = studentsDao.findById(2);
			req.setAttribute("student", student);
		}
		RequestDispatcher dispatcher = req.getRequestDispatcher("/views/sinhvien/info-details.jsp");
		dispatcher.forward(req, resp);
	}

}
