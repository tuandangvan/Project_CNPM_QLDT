package Controller.admin;

import java.io.IOException;
import java.sql.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Dao.IMajorsDao;
import Dao.ITeachersDao;
import Dao.Impl.MajorsDaoImpl;
import Dao.Impl.TeachersDaoImpl;
import Models.MajorsModel;
import Models.TeachersModel;

@SuppressWarnings("serial")
@WebServlet(urlPatterns = {"/admin/manage-teacher/edit"})
public class EditInfoTeachersAdminController extends HttpServlet{

	ITeachersDao teachersDao = new TeachersDaoImpl();
	IMajorsDao majorsDao = new MajorsDaoImpl();
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String teacherId = req.getParameter("id");
		
		TeachersModel teacher = teachersDao.findById(Integer.parseInt(teacherId));
		
		req.setAttribute("teacher", teacher);
		
		List<MajorsModel> lstMajor = majorsDao.getAll();
		req.setAttribute("lstMajor", lstMajor);
		req.getRequestDispatcher("/views/admin/edit-InfoTeacher.jsp").forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		try {
			resp.setContentType("text/html");
			req.setCharacterEncoding("UTF-8");
			
			TeachersModel teacher = new TeachersModel();
			teacher.setTeacherId(Integer.parseInt(req.getParameter("teacherId")));
			teacher.setTeacherName(req.getParameter("name"));
			teacher.setPhone(req.getParameter("phone"));
			teacher.setGender(Boolean.parseBoolean(req.getParameter("gender")));
			teacher.setBirth(Date.valueOf(req.getParameter("birth")));
			teacher.setMajorId(Integer.parseInt(req.getParameter("major")));
			
			teachersDao.editByAdmin(teacher);
			resp.sendRedirect(req.getContextPath() + "/admin/manage-teacher");
		} catch (Exception e) {
			e.printStackTrace();
			resp.sendRedirect(req.getContextPath() + "/admin/manage-teacher");
		}
	}

}
