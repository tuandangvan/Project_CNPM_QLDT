package Controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Dao.IStudentsDao;
import Dao.Impl.StudentsDaoImpl;
import Models.StudentsModel;

@SuppressWarnings("serial")
@WebServlet(urlPatterns = {"/student/info-student","/teacher/info-student"})
public class InfoStudentsController extends HttpServlet{

	IStudentsDao studentDao = new StudentsDaoImpl();
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		List<StudentsModel> lstStudent = new ArrayList<StudentsModel>();
		lstStudent = studentDao.getAllByAdmin();
		
		req.setAttribute("lstStudent", lstStudent);
		
		RequestDispatcher dispatcher = req.getRequestDispatcher("/views/list-student.jsp");
		dispatcher.forward(req, resp);
	}
	
}
