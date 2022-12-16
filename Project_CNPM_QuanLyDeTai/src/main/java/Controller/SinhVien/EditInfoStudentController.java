package Controller.SinhVien;

import java.io.IOException;
import java.sql.Date;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Dao.IMajorsDao;
import Dao.ISignUpDao;
import Dao.IStudentsDao;
import Dao.Impl.MajorsDaoImpl;
import Dao.Impl.SignUpDaoImpl;
import Dao.Impl.StudentsDaoImpl;
import Models.MajorsModel;
import Models.SignUpModel;
import Models.StudentsModel;

@SuppressWarnings("serial")
@WebServlet(urlPatterns = {"/student/info/edit"})
public class EditInfoStudentController extends HttpServlet{

	IStudentsDao studentsDao = new StudentsDaoImpl();
	IMajorsDao majorsDao = new MajorsDaoImpl();
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		ISignUpDao signUp = new SignUpDaoImpl();
		List<SignUpModel> signs = signUp.getAll();
		req.setAttribute("signs",signs);
		List<MajorsModel> lstMajor = majorsDao.getAll();
		req.setAttribute("lstMajor", lstMajor);
		String studentId =req.getParameter("id");
		StudentsModel student = studentsDao.findById(Integer.valueOf(studentId));
		req.setAttribute("student", student);
		req.getRequestDispatcher("/views/sinhvien/edit-InfoStudent.jsp").forward(req, resp);
		
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		try {
			resp.setContentType("text/html");
			req.setCharacterEncoding("UTF-8");
			
			StudentsModel student = new StudentsModel();
			student.setStudentId(Integer.parseInt(req.getParameter("studentId")));
			student.setStudentName(req.getParameter("name"));
			student.setPhone(req.getParameter("phone"));
			student.setGender(Boolean.parseBoolean(req.getParameter("gender")));
			student.setBirth(Date.valueOf(req.getParameter("birth")));
			student.setAddress(req.getParameter("address"));
			student.setMajorId(Integer.parseInt(req.getParameter("major")));
			
			studentsDao.edit(student);
			resp.sendRedirect(req.getContextPath() + "/student/info");
		} catch (Exception e) {
			resp.sendRedirect(req.getContextPath() + "/student/info");
			e.printStackTrace();
		}
	}
	

}
