package Controller.GiangVien;

import Dao.ISignUpDao;
import Dao.ITopicDetailsDao;
import Dao.Impl.SignUpDaoImpl;
import Dao.Impl.TopicDetailsDaoImpl;
import Models.SignUpModel;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class DeleteStudentController
 */
@WebServlet("/teacher/topics/delete")
public class DeleteStudentController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DeleteStudentController() {
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

		Integer id = Integer.parseInt(request.getParameter("id"));
		Integer topicId = Integer.parseInt(request.getParameter("topicId"));

		ITopicDetailsDao topicDetailsDao = new TopicDetailsDaoImpl();
		topicDetailsDao.delete(id);
		response.sendRedirect("./details?topicId="+topicId);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
