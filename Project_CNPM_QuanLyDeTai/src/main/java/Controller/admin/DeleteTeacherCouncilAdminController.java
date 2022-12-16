package Controller.admin;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Dao.ICouncilDetailsDao;
import Dao.Impl.CouncilDetailsDaoImpl;

@SuppressWarnings("serial")
@WebServlet(urlPatterns = {"/admin/Council/delete"})
public class DeleteTeacherCouncilAdminController extends HttpServlet{

	ICouncilDetailsDao detailsDao = new CouncilDetailsDaoImpl();
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String teachReturn = req.getParameter("teachReturn");
		String topicReturn = req.getParameter("topicReturn");
		try {
			int councilId =  Integer.parseInt(req.getParameter("councilId"));
			int teacherId = Integer.parseInt(req.getParameter("teacherId"));
			
			detailsDao.delete(councilId, teacherId);
			resp.sendRedirect(req.getContextPath() + "/admin/Council/create?id="+ teachReturn +"&topicId=" + topicReturn);
		} catch (Exception e) {
			resp.sendRedirect(req.getContextPath() + "/admin/Council/create?id="+ teachReturn +"&topicId=" + topicReturn);
		}
		
	}

}
