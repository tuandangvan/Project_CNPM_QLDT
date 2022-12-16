package Controller.admin;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Dao.ICouncilDetailsDao;
import Dao.Impl.CouncilDetailsDaoImpl;
import Models.CouncilDetailsModel;

@SuppressWarnings("serial")
@WebServlet(urlPatterns = {"/admin/Council/add-council"})
public class AddTeacherCouncilAdminController extends HttpServlet{

	ICouncilDetailsDao detailsDao = new CouncilDetailsDaoImpl();
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String teacherId = req.getParameter("idTeacher");
		String councilId = req.getParameter("councilId");
		
		String teachReturn = req.getParameter("teachReturn");
		String topicReturn = req.getParameter("topicReturn");
		
		CouncilDetailsModel councilDetail = new CouncilDetailsModel();
		councilDetail.setCouncilId(Integer.parseInt(councilId));
		councilDetail.setTeacherId(Integer.parseInt(teacherId));
		
		detailsDao.insert(councilDetail);
		resp.sendRedirect(req.getContextPath() + "/admin/Council/create?id="+ teachReturn +"&topicId=" + topicReturn);
	}

}
