package Controller.SinhVien;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Dao.IMajorsDao;
import Dao.IStudentsDao;
import Dao.ITeachersDao;
import Dao.ITopicDao;
import Dao.ITopicDetailsDao;
import Dao.Impl.MajorsDaoImpl;
import Dao.Impl.StudentsDaoImpl;
import Dao.Impl.TeachersDaoImpl;
import Dao.Impl.TopicDaoImpl;
import Dao.Impl.TopicDetailsDaoImpl;
import Models.AccountModel;
import Models.StudentsModel;
import Models.TeachersModel;
import Models.TopicDetailsModel;
import Models.TopicModel;

@SuppressWarnings("serial")
@WebServlet(urlPatterns = { "/student/group" })
public class ManagerGroupController extends HttpServlet {

	IMajorsDao majorsDao = new MajorsDaoImpl();
	ITopicDao topicDao = new TopicDaoImpl();
	ITopicDetailsDao topicDetailsDao = new TopicDetailsDaoImpl();
	IStudentsDao studentsDao = new StudentsDaoImpl();
	ITeachersDao teachersDao = new TeachersDaoImpl();

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		HttpSession session = req.getSession();
		if (session != null && session.getAttribute("account") != null) {
			AccountModel account = (AccountModel) session.getAttribute("account");
			// lấy topicId theo email
			String topicId = studentsDao.findTopicIdByEmail(account.getUsername());

			// tìm dề tài
			TopicModel topic = new TopicModel();
			topic = topicDao.findById(Integer.parseInt(topicId));
			req.setAttribute("topic", topic);

			// tìm topicdetail theo topicId và leader
			List<TopicDetailsModel> topicdetails = new ArrayList<TopicDetailsModel>();
			topicdetails = topicDetailsDao.findTopicDetailByTopicId(Integer.parseInt(topicId));
			if (!topicdetails.isEmpty()) {
				if (topicdetails.get(0).getScores() >= 0)
					req.setAttribute("topicdetail", topicdetails.get(0));
			}
			List<StudentsModel> students = new ArrayList<StudentsModel>();

			for (TopicDetailsModel topicDetail : topicdetails) {
				// lấy leader thành viên
				StudentsModel sd = new StudentsModel();
				sd = studentsDao.findById(topicDetail.getStudentId());
				students.add(sd);
			}

			int sl = students.size();
			req.setAttribute("sl", sl);

			req.setAttribute("students", students);

			String majorName = topicDetailsDao.findMajorNameByTopicDetail(Integer.parseInt(topicId));
			req.setAttribute("majorName", majorName);

			// lấy leader thành viên
			StudentsModel leader = null;
			for (TopicDetailsModel tp : topicdetails) {
				if (tp.getLeader()) {
					leader = new StudentsModel();
					leader = studentsDao.findById(tp.getStudentId());
					req.setAttribute("leader", leader);
					break;
				}
			}

			if (leader.getEmail().equals(account.getUsername())) {
				req.setAttribute("isleader", 1);
			}

			// lấy thành viên

			// lấy giảng viên hd
			TeachersModel teacherIn = new TeachersModel();
			teacherIn = teachersDao.findById(topic.getTeacherId());
			req.setAttribute("teacherIn", teacherIn);


			// lay gv phan bien
			List<TeachersModel> teacherPbs = new ArrayList<TeachersModel>();
			teacherPbs = teachersDao.getAllTeacherByTopicId(Integer.parseInt(topicId));
			req.setAttribute("teacherPbs", teacherPbs);
		}

		RequestDispatcher dispatcher = req.getRequestDispatcher("/views/sinhvien/group-manager.jsp");
		dispatcher.forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession session = req.getSession();
		if (session != null && session.getAttribute("account") != null) {
			AccountModel account = (AccountModel) session.getAttribute("account");
			String topicId = studentsDao.findTopicIdByEmail(account.getUsername());
			String link_report = req.getParameter("report");
			topicDao.editReport(link_report, Integer.parseInt(topicId));
		}
		resp.sendRedirect(req.getContextPath() + "/student/group");
	}

}
