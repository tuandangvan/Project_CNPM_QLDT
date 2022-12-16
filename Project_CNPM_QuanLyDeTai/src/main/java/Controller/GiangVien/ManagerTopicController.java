package Controller.GiangVien;

import Dao.IStudentsDao;
import Dao.ITopicDao;
import Dao.ITopicDetailsDao;
import Dao.Impl.StudentsDaoImpl;
import Dao.Impl.TopicDaoImpl;
import Dao.Impl.TopicDetailsDaoImpl;
import Models.TopicModel;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ManagerTopicController
 */
@WebServlet("/teacher/topics/details")
public class ManagerTopicController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ManagerTopicController() {
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
		
		String topicX = request.getParameter("topicId");
		Integer topicId = Integer.parseInt(topicX);
		ITopicDao topicDao = new TopicDaoImpl();
		TopicModel topicModel = topicDao.getById(topicId);
		ITopicDetailsDao topicDetailsDao = new TopicDetailsDaoImpl();
		IStudentsDao studentsDao = new StudentsDaoImpl();

		request.setAttribute("studentsDao",studentsDao);
		request.setAttribute("topicModel",topicModel);
		request.setAttribute("topicDetailsDao",topicDetailsDao);
		request.getRequestDispatcher("/views/teacher/detail-topic.jsp").forward(request,response);

		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html;charset=UTF-8");
		request.setCharacterEncoding("UTF-8");
		doGet(request, response);
	}

}
