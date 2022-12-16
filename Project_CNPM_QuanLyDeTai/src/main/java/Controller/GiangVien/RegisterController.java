package Controller.GiangVien;

import Dao.ISignUpDao;
import Dao.ITopicDao;
import Dao.Impl.SignUpDaoImpl;
import Dao.Impl.TopicDaoImpl;
import Models.SignUpModel;
import Models.TopicModel;

import java.io.IOException;
import java.time.LocalDate;
import java.sql.Date;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html;charset=UTF-8");
		request.setCharacterEncoding("UTF-8");

		String teacherId = "1";
		Integer IteacherId = Integer.valueOf(teacherId);

		request.setAttribute("teacherId", IteacherId);
		request.getRequestDispatcher("/views/teacher/register.jsp").forward(request,response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html;charset=UTF-8");
		request.setCharacterEncoding("UTF-8");
		ISignUpDao signUpDao = new SignUpDaoImpl();
		SignUpModel signUpModel = signUpDao.getLast();
		Date now = Date.valueOf(LocalDate.now());
		
		if((now.compareTo(signUpModel.getStartTime())>0 || now.compareTo(signUpModel.getStartTime())==0)
				&& (now.compareTo(signUpModel.getEndTime())<0 || now.compareTo(signUpModel.getEndTime())==0))
		{
			if(signUpModel.getRole()==false) {
				String topicName = request.getParameter("topicName");
				String detail = request.getParameter("detail");
				String teacherId = "1";
				Integer IteacherId = Integer.valueOf(teacherId);

				TopicModel topicModel = new TopicModel(0, topicName, IteacherId, detail, null);
				ITopicDao topicDao = new TopicDaoImpl();
				topicDao.insert(topicModel);
				request.setAttribute("teacherId", IteacherId);
				doGet(request, response);
			}
			else {
				request.setAttribute("message", "Không nằm trong thời gian đăng ký");
				request.getRequestDispatcher("/views/teacher/error.jsp").forward(request,response);
			}
		}
		else {
			request.setAttribute("message", "Không nằm trong thời gian đăng ký");
			request.getRequestDispatcher("/views/teacher/error.jsp").forward(request,response);
		}

	}

}
