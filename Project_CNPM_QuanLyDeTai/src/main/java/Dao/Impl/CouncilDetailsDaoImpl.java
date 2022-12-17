package Dao.Impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import Connection.DBConnection;
import Dao.ICouncilDetailsDao;
import Dao.ITopicDetailsDao;
import Models.CouncilDetailsModel;
import Models.TopicDetailsModel;

public class CouncilDetailsDaoImpl extends DBConnection implements ICouncilDetailsDao {
	@Override
	public void insert(CouncilDetailsModel councildetail) {
		// TODO Auto-generated method stub
		// TODO Auto-generated method stub
		String sql = "INSERT INTO CouncilDetails(CouncilId, teacherId, scores) VALUES (?,?,-1)";
		try {
			Connection con = super.getConnection();
			PreparedStatement ps = con.prepareStatement(sql);

			ps.setInt(1, councildetail.getCouncilId());
			ps.setInt(2, councildetail.getTeacherId());

			ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	@Override
	public void edit(CouncilDetailsModel councildetail) {
		String sql = "UPDATE  councildetail SET councildetailName=?, gender=?, birth=? email=?, phone=? WHERE councildetailId=?";
		try {
			Connection con = super.getConnection();
			PreparedStatement ps = con.prepareStatement(sql);
//			ps.setString(1, councildetail.getcouncildetailName());
//			ps.setBoolean(2, councildetail.getGender());
//			ps.setDate(3, councildetail.getBirth());
//			ps.setInt(6, councildetail.getcouncildetailId());

			ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	// Xóa teacher khỏi hội đồng chấm thi
	@Override
	public void delete(int councilId, int teacherId) {
		String sql = "DELETE FROM CouncilDetails\r\n" + "WHERE CouncilId = ? and teacherId = ? ";
		try {
			Connection con = super.getConnection();
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1, councilId);
			ps.setInt(2, teacherId);
			ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public CouncilDetailsModel get(int id) {
		String sql = "SELECT * FROM councildetail WHERE username = ? ";
		try {
			Connection con = super.getConnection();
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				CouncilDetailsModel councildetailer = new CouncilDetailsModel();
//				councildetailer.setcouncildetailId(rs.getInt("councildetailId"));
//				councildetailer.setcouncildetailName(rs.getString(id));
//				councildetailer.setcouncildetailId(rs.getInt("councildetailId"));
//				councildetailer.setCreatedAt(rs.getDate("createdAt"));
//				councildetailer.setPrice(rs.getBigDecimal("price"));

				return councildetailer;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public List<CouncilDetailsModel> getAll() {
		List<CouncilDetailsModel> councildetailers = new ArrayList<CouncilDetailsModel>();
		String sql = "SELECT * FROM councildetail";
		try {
			Connection con = super.getConnection();
			PreparedStatement ps = con.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				CouncilDetailsModel councildetailer = new CouncilDetailsModel();

//				councildetailer.setcouncildetailId(rs.getInt("councildetailId"));
//				councildetailer.setcouncildetailName(rs.getString(id));
//				councildetailer.setcouncildetailId(rs.getInt("councildetailId"));
//				councildetailer.setCreatedAt(rs.getDate("createdAt"));
//				councildetailer.setPrice(rs.getBigDecimal("price"));

				councildetailers.add(councildetailer);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return councildetailers;
	}

	@Override
	public CouncilDetailsModel findById(int id) {
		String sql = "SELECT * FROM councildetail WHERE id = ? ";
		try {
			Connection con = super.getConnection();
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				CouncilDetailsModel councildetailer = new CouncilDetailsModel();

//				councildetailer.setcouncildetailId(rs.getInt("councildetailId"));
//				councildetailer.setcouncildetailName(rs.getString(id));
//				councildetailer.setcouncildetailId(rs.getInt("councildetailId"));
//				councildetailer.setCreatedAt(rs.getDate("createdAt"));
//				councildetailer.setPrice(rs.getBigDecimal("price"));

				return councildetailer;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public String findByCouncilId(int topicId) {
		String sql = "select id from Council where topicId = ? ";
		try {
			Connection con = super.getConnection();
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1, topicId);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				return rs.getString(1);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public List<CouncilDetailsModel> getAllTeacherByCouncilId(int councilId) {
		List<CouncilDetailsModel> councildetailers = new ArrayList<CouncilDetailsModel>();
		String sql = "select CouncilDetails.CouncilId, CouncilDetails.teacherId, Teachers.teacherName\r\n"
				+ "from Council, CouncilDetails, Teachers \r\n"
				+ "where CouncilDetails.CouncilId = Council.id and CouncilDetails.teacherId = Teachers.teacherId\r\n"
				+ "and CouncilDetails.CouncilId = ?";
		try {
			Connection con = super.getConnection();
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1, councilId);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				CouncilDetailsModel councildetailer = new CouncilDetailsModel();
				councildetailer.setCouncilId(rs.getInt(1));
				councildetailer.setTeacherId(rs.getInt(2));
				councildetailer.setTeacherName(rs.getString(3));
				councildetailers.add(councildetailer);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return councildetailers;
	}

	@Override
	public List<CouncilDetailsModel> getAllByTeacher(int teacherId) {
		List<CouncilDetailsModel> councildetailers = new ArrayList<CouncilDetailsModel>();
		String sql = "SELECT * FROM CouncilDetails where teacherId=?";
		try {
			Connection con = super.getConnection();
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1, teacherId);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				CouncilDetailsModel councildetailer = new CouncilDetailsModel();

				councildetailer.setCouncilId(rs.getInt("CouncilId"));
				councildetailer.setTeacherId(rs.getInt("teacherId"));
				councildetailer.setLeader(rs.getBoolean("leader"));
				councildetailer.setId(rs.getInt("id"));
				councildetailer.setScores(rs.getFloat("Scores"));

				councildetailers.add(councildetailer);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return councildetailers;
	}

	@Override
	public List<CouncilDetailsModel> getAllByCouncilId(int councilId) {
		List<CouncilDetailsModel> councildetailers = new ArrayList<CouncilDetailsModel>();
		String sql = "SELECT * FROM CouncilDetails where councilId=?";
		try {
			Connection con = super.getConnection();
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1, councilId);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				CouncilDetailsModel councildetailer = new CouncilDetailsModel();

				councildetailer.setCouncilId(rs.getInt("CouncilId"));
				councildetailer.setTeacherId(rs.getInt("teacherId"));
				councildetailer.setLeader(rs.getBoolean("leader"));
				councildetailer.setId(rs.getInt("id"));
				councildetailer.setScores(rs.getFloat("Scores"));

				councildetailers.add(councildetailer);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return councildetailers;
	}
	
	public void updateScoresCounCilDetail(float scores, int councilId, int teacherId,int topicId) {
		String sql = "UPDATE CouncilDetails SET scores=? WHERE councilId=? and teacherId=?";
		try {
			Connection con = super.getConnection();
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setFloat(1, scores);
			ps.setInt(2, councilId);
			ps.setInt(3, teacherId);
			ps.executeUpdate();
			
			updateScoresCounCil(councilId,topicId);


		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void updateScoresCounCil(int councilId,int topicId) {
		String sql = "UPDATE Council SET averagescore=? WHERE id=?";
		try {
			float averageScore = getAverageScore(councilId);
			Connection con = super.getConnection();
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setFloat(1,averageScore);
			ps.setInt(2, councilId);
			ps.executeUpdate();
			
			if(averageScore>=0)
				updateTopicDetail(topicId,averageScore);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void updateTopicDetail(int topicId, float scores) {
		ITopicDetailsDao topicDetailDAO = new TopicDetailsDaoImpl();
		List<TopicDetailsModel> topicDetailsModels = topicDetailDAO.getAllByTopicId(topicId);
		for (TopicDetailsModel topicDetail: topicDetailsModels
			 ) {

			topicDetail.setScores(scores);
			topicDetailDAO.edit(topicDetail);
		}
	}

	public int getCount(int councilId) {
		String sql = "Select Count(CouncilId) as count from CouncilDetails where CouncilId = ? and Scores>0";
		int count =0;
		try {
			Connection con = super.getConnection();
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1, councilId);

			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				count = rs.getInt("count");
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		if(count==0)
			return 1;
		return count;
	}

	public float getAverageScore(int CouncilId) {
		if(checkScore(CouncilId)==1)
			return -1;
		else {
			String sql = "Select Sum(Scores) as sum from CouncilDetails where CouncilId =? and Scores>0";
			float sum = -1;
			try {
				Connection con = super.getConnection();
				PreparedStatement ps = con.prepareStatement(sql);
				ps.setInt(1,CouncilId);
				
				ResultSet rs = ps.executeQuery();
				while (rs.next()) {
					sum = rs.getFloat("sum");
				}
				
				return sum/getCount(CouncilId);
				
			} catch (Exception e) {
				e.printStackTrace();
			}
			return sum;
		}
	}

	public int checkScore(int councilId) {
		String sql = "Select Count(CouncilId) as count from CouncilDetails where CouncilId =? and Scores<0";
		try {
			Connection con = super.getConnection();
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1, councilId);

			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				int count = rs.getInt("count");
				if (count == 0)
					return -1;
				return 1;
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return -1;
	}
	
	@Override
	public Float findScoresByTeacherIdAndCouncilId(int topicId, String email) {
		String sql = "select CouncilDetails.Scores from CouncilDetails, Teachers, Council, Topic\r\n"
				+ "where CouncilDetails.teacherId=Teachers.teacherId and  CouncilDetails.CouncilId=Council.id\r\n"
				+ "and Topic.topicId=Council.topicId and Topic.topicId=? and Teachers.email=?";
		try {
			Connection con = super.getConnection();
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1, topicId);
			ps.setString(2, email);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				return rs.getFloat("scores");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	
	
}
