package Controller.GiangVien;

import Dao.ICouncilDao;
import Dao.ICouncilDetailsDao;
import Dao.IMajorsDao;
import Dao.ITeachersDao;
import Dao.ITopicDao;
import Dao.Impl.CouncilDaoImpl;
import Dao.Impl.CouncilDetailsDaoImpl;
import Dao.Impl.MajorsDaoImpl;
import Dao.Impl.TeachersDaoImpl;
import Dao.Impl.TopicDaoImpl;
import Models.AccountModel;
import Models.CouncilDetailsModel;
import Models.CouncilModel;
import Models.TeachersModel;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

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

		HttpSession session = request.getSession();
		if (session != null && session.getAttribute("account") != null) {
			AccountModel account = (AccountModel) session.getAttribute("account");
			
			// email = 20110300@student.hcmute.edu.vn
			String user = account.getUsername();
			ITeachersDao iTeachersDao = new TeachersDaoImpl();
			TeachersModel teachersModel = iTeachersDao.getByUser(user);

			ICouncilDetailsDao iCouncilDetailsDao = new CouncilDetailsDaoImpl();
			ICouncilDao iCouncilDao = new CouncilDaoImpl();
			ITopicDao iTopicDao = new TopicDaoImpl();
			List<CouncilDetailsModel> listDetails =  iCouncilDetailsDao.getAllByTeacher(teachersModel.getTeacherId());
			
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
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
