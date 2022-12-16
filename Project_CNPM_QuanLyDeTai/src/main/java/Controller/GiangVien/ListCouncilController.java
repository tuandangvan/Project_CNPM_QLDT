package Controller.GiangVien;

import Dao.ICouncilDao;
import Dao.ICouncilDetailsDao;
import Dao.ITeachersDao;
import Dao.ITopicDao;
import Dao.Impl.CouncilDaoImpl;
import Dao.Impl.CouncilDetailsDaoImpl;
import Dao.Impl.TeachersDaoImpl;
import Dao.Impl.TopicDaoImpl;
import Models.CouncilDetailsModel;
import Models.CouncilModel;
import Models.TopicModel;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ListCouncilController
 */
@WebServlet("/teacher/listCouncil")
public class ListCouncilController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ListCouncilController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		request.setCharacterEncoding("UTF-8");

		String teacherId = "1";
		Integer iTeacherId = Integer.parseInt(teacherId);

		ICouncilDetailsDao iCouncilDetailsDao = new CouncilDetailsDaoImpl();
		ICouncilDao iCouncilDao = new CouncilDaoImpl();
		ITopicDao iTopicDao = new TopicDaoImpl();
		ITeachersDao iTeachersDao = new TeachersDaoImpl();
		List<CouncilDetailsModel> listDetails =  iCouncilDetailsDao.getAllByTeacher(iTeacherId);
		
		List<CouncilModel>  listCouncil = new ArrayList<>();
		for (CouncilDetailsModel detail: listDetails
			 ) {
				CouncilModel councilModel = iCouncilDao.getById(detail.getCouncilId());
				listCouncil.add(councilModel);
		}

		request.setAttribute("listCouncil",listCouncil);
		request.setAttribute("iTopicDao",iTopicDao);
		request.setAttribute("iTeachersDao",iTeachersDao);
		request.setAttribute("iCouncilDetailsDao",iCouncilDetailsDao);
		request.getRequestDispatcher("/views/teacher/list-council.jsp").forward(request,response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
