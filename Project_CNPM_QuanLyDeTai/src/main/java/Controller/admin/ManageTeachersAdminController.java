package Controller.admin;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Dao.ITeachersDao;
import Dao.Impl.TeachersDaoImpl;
import Models.AccountModel;
import Models.TeachersModel;

@SuppressWarnings("serial")
@WebServlet(urlPatterns = {"/admin/manage-teacher"})
public class ManageTeachersAdminController extends HttpServlet{

	ITeachersDao teacherDao = new TeachersDaoImpl();
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		List<TeachersModel> lstTeacher = new ArrayList<TeachersModel>();
		lstTeacher = teacherDao.getAllByAdmin();
		
		req.setAttribute("lstTeacher", lstTeacher);
		RequestDispatcher dispatcher = req.getRequestDispatcher("/views/admin/list-teacher.jsp");
		dispatcher.forward(req, resp);
	}
}
