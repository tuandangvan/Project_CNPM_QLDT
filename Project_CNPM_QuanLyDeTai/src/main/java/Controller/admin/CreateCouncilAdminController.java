package Controller.admin;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Dao.ICouncilDao;
import Dao.ICouncilDetailsDao;
import Dao.ITeachersDao;
import Dao.Impl.CouncilDaoImpl;
import Dao.Impl.CouncilDetailsDaoImpl;
import Dao.Impl.TeachersDaoImpl;
import Models.CouncilDetailsModel;
import Models.CouncilModel;
import Models.TeachersModel;

@SuppressWarnings("serial")
@WebServlet(urlPatterns = { "/admin/Council/create" })
public class CreateCouncilAdminController extends HttpServlet {

	ICouncilDao councilDao = new CouncilDaoImpl();
	ITeachersDao teachersDao = new TeachersDaoImpl();
	ICouncilDetailsDao detailsDao = new CouncilDetailsDaoImpl();

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		try {
			String teacherId = req.getParameter("id");
			String topicId = req.getParameter("topicId");

			String councilId = detailsDao.findByCouncilId(Integer.parseInt(topicId));

			String checkTopic = councilDao.checkTopicId(Integer.parseInt(topicId));
			// Tạo hội đồng
			if (checkTopic == null) {
				CouncilModel council = new CouncilModel();
				council.setTopicId(Integer.parseInt(req.getParameter("topicId")));
				councilDao.insert(council);
			}
			// List giảng viên có thể được chấm điểm
			List<TeachersModel> listTeacher = new ArrayList<TeachersModel>();
			listTeacher = teachersDao.getAllTeacherCouncil(Integer.parseInt(teacherId));
			req.setAttribute("listTeacher", listTeacher);

			// List giảng viên đã được chọn
			List<CouncilDetailsModel> councilDetailst = new ArrayList<CouncilDetailsModel>();
			councilDetailst = detailsDao.getAllTeacherByCouncilId(Integer.parseInt(councilId));
			req.setAttribute("details", councilDetailst);

			req.setAttribute("councilId", councilId);
			req.setAttribute("teachReturn", teacherId);
			req.setAttribute("topicReturn", topicId);
		} catch (Exception e) {
			e.printStackTrace();
		}

		RequestDispatcher dispatcher = req.getRequestDispatcher("/views/admin/list-AbleCouncil.jsp");
		dispatcher.forward(req, resp);
	}

}
