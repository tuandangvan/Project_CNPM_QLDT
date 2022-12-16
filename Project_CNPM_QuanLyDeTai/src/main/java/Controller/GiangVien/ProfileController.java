package Controller.GiangVien;

import Dao.IMajorsDao;
import Dao.ITeachersDao;
import Dao.Impl.MajorsDaoImpl;
import Dao.Impl.TeachersDaoImpl;
import Models.TeachersModel;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ProfileController
 */
@WebServlet("/teacher/profile")
public class ProfileController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ProfileController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html;charset=UTF-8");
		request.setCharacterEncoding("UTF-8");
		String user = request.getParameter("user");
		ITeachersDao iTeachersDao = new TeachersDaoImpl();
		TeachersModel teachersModel = iTeachersDao.getByUser(user);

		IMajorsDao majorsDao = new MajorsDaoImpl();
		request.setAttribute("teacher",teachersModel);
		request.setAttribute("majorsDao",majorsDao);
		request.getRequestDispatcher("/views/teacher/profile.jsp").forward(request,response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
