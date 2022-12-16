package Controller.GiangVien;

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
import Dao.ITeachersDao;
import Dao.Impl.MajorsDaoImpl;
import Dao.Impl.SignUpDaoImpl;
import Dao.Impl.TeachersDaoImpl;
import Models.SignUpModel;
import Models.TeachersModel;

/**
 * Servlet implementation class UpdateProfileController
 */
@WebServlet("/teacher/updateProfile")
public class UpdateProfileController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateProfileController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ISignUpDao signUp = new SignUpDaoImpl();
		List<SignUpModel> signs = signUp.getAll();
		request.setAttribute("signs",signs);
		// TODO Auto-generated method stub
		response.setContentType("text/html;charset=UTF-8");
		request.setCharacterEncoding("UTF-8");
		
		String user = request.getParameter("user");
		ITeachersDao iTeachersDao = new TeachersDaoImpl();
		TeachersModel teachersModel = iTeachersDao.getByUser(user);
		IMajorsDao majorsDao = new MajorsDaoImpl();

		request.setAttribute("teacher",teachersModel);
		request.setAttribute("majorsDao",majorsDao);
		request.getRequestDispatcher("/views/teacher/update-profile.jsp").forward(request,response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html;charset=UTF-8");
		request.setCharacterEncoding("UTF-8");
		
		String email = request.getParameter("email");
		String teacherName = request.getParameter("teacherName");
		String phone = request.getParameter("phone");
		String gender = request.getParameter("gender");
		String birth = request.getParameter("birth");
		ITeachersDao iTeachersDao = new TeachersDaoImpl();

		TeachersModel teachersModel = iTeachersDao.getByUser(email);
		teachersModel.setBirth(Date.valueOf(birth));
		teachersModel.setGender(Boolean.valueOf(gender));
		teachersModel.setTeacherName(teacherName);
		teachersModel.setPhone(phone);

		IMajorsDao majorsDao = new MajorsDaoImpl();

		iTeachersDao.edit(teachersModel);

		request.setAttribute("teacher",teachersModel);
		request.setAttribute("majorsDao",majorsDao);
		request.getRequestDispatcher("/views/teacher/profile.jsp").forward(request,response);
	}

}
