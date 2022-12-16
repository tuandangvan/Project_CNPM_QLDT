package Controller.GiangVien;

import Dao.ISignUpDao;
import Dao.ITeachersDao;
import Dao.ITopicDao;
import Dao.Impl.SignUpDaoImpl;
import Dao.Impl.TeachersDaoImpl;
import Dao.Impl.TopicDaoImpl;
import Models.AccountModel;
import Models.SignUpModel;
import Models.TeachersModel;
import Models.TopicModel;

import java.io.IOException;
import java.time.LocalDate;
import java.util.List;
import java.sql.Date;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class RegisterController
 */
@WebServlet("/teacher/register")
public class RegisterController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public RegisterController() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		ISignUpDao signUp = new SignUpDaoImpl();
		List<SignUpModel> signs = signUp.getAll();
		request.setAttribute("signs",signs);
		// TODO Auto-generated method stub
		response.setContentType("text/html;charset=UTF-8");
		request.setCharacterEncoding("UTF-8");

		ISignUpDao signUpDao = new SignUpDaoImpl();
		SignUpModel signUpModel = signUpDao.getLast();
		Date now = Date.valueOf(LocalDate.now());
		if ((now.compareTo(signUpModel.getStartTime()) > 0 || now.compareTo(signUpModel.getStartTime()) == 0)
				&& (now.compareTo(signUpModel.getEndTime()) < 0 || now.compareTo(signUpModel.getEndTime()) == 0)) {
			if (signUpModel.getRole() == false) {
				HttpSession session = request.getSession();
				if (session != null && session.getAttribute("account") != null) {
					AccountModel account = (AccountModel) session.getAttribute("account");

					// email = 20110300@student.hcmute.edu.vn
					String user = account.getUsername();
					ITeachersDao iTeachersDao = new TeachersDaoImpl();
					TeachersModel teachersModel = iTeachersDao.getByUser(user);

					request.setAttribute("teacherId", teachersModel.getTeacherId());
					request.getRequestDispatcher("/views/teacher/register.jsp").forward(request, response);
				}

			} else {
				request.setAttribute("message", "Không nằm trong thời gian đăng ký");
				request.getRequestDispatcher("/views/teacher/error.jsp").forward(request, response);
			}
		} else {
			request.setAttribute("message", "Không nằm trong thời gian đăng ký");
			request.getRequestDispatcher("/views/teacher/error.jsp").forward(request, response);
		}

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html;charset=UTF-8");
		request.setCharacterEncoding("UTF-8");
		
		HttpSession session = request.getSession();
		if (session != null && session.getAttribute("account") != null) {

			AccountModel account = (AccountModel) session.getAttribute("account");

			// email = 20110300@student.hcmute.edu.vn
			String user = account.getUsername();
			ITeachersDao iTeachersDao = new TeachersDaoImpl();
			TeachersModel teachersModel = iTeachersDao.getByUser(user);

			String topicName = request.getParameter("topicName");
			String detail = request.getParameter("detail");

			TopicModel topicModel = new TopicModel(0, topicName, teachersModel.getTeacherId(), detail, null);
			ITopicDao topicDao = new TopicDaoImpl();
			topicDao.insert(topicModel);
			request.setAttribute("teacherId", teachersModel.getTeacherId());
			doGet(request, response);
		}

	}

}
