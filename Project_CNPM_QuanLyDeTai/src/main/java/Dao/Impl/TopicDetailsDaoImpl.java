package Dao.Impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import Connection.DBConnection;
import Dao.ITopicDetailsDao;
import Models.TopicDetailsModel;

public class TopicDetailsDaoImpl extends DBConnection implements ITopicDetailsDao{
	@Override
	public void insert(TopicDetailsModel topicdetails) {
		// TODO Auto-generated method stub
		String sql = "INSERT INTO topicdetails(topicdetailsName,gender,birth,email,phone) VALUES (?,?,?,?,?)";
		try {
			Connection con = super.getConnection();
			PreparedStatement ps = con.prepareStatement(sql);
			
//			ps.setString(1, topicdetails.gettopicdetailsName());
//			ps.setBoolean(2, topicdetails.getGender());
//			ps.setDate(3, topicdetails.getBirth());
//			ps.setInt(6, topicdetails.gettopicdetailsId());
			
			
			ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
	
	
	@Override
	public void edit(TopicDetailsModel topicdetails) {
		String sql = "UPDATE  topicdetails SET topicdetailsName=?, gender=?, birth=? email=?, phone=? WHERE topicdetailsId=?";
		try {
			Connection con = super.getConnection();
			PreparedStatement ps = con.prepareStatement(sql);
//			ps.setString(1, topicdetails.gettopicdetailsName());
//			ps.setBoolean(2, topicdetails.getGender());
//			ps.setDate(3, topicdetails.getBirth());
//			ps.setInt(6, topicdetails.gettopicdetailsId());
			
			ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public void delete(int id) {
		String sql = "DELETE FROM topicdetails WHERE topicdetailsId = ?";
		try {
			Connection con = super.getConnection();
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1, id);
			ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

	@Override
	public TopicDetailsModel get(int id) {
		String sql = "SELECT * FROM topicdetails WHERE username = ? ";
		try {
			Connection con = super.getConnection();
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				TopicDetailsModel major = new TopicDetailsModel();
//				topicdetailser.settopicdetailsId(rs.getInt("topicdetailsId"));
//				topicdetailser.settopicdetailsName(rs.getString(id));
//				topicdetailser.settopicdetailsId(rs.getInt("topicdetailsId"));
//				topicdetailser.setBoolean(3, signup.getBoolean());
//				topicdetailser.setCreatedAt(rs.getDate("createdAt"));
//				topicdetailser.setPrice(rs.getBigDecimal("price"));
		
				return major;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public List<TopicDetailsModel> getAll() {
		List<TopicDetailsModel> topicdetails= new ArrayList<TopicDetailsModel>();
		String sql = "SELECT * FROM topicdetails";
		try {
			Connection con = super.getConnection();
			PreparedStatement ps = con.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				TopicDetailsModel major = new TopicDetailsModel();
				
//				topicdetailser.settopicdetailsId(rs.getInt("topicdetailsId"));
//				topicdetailser.settopicdetailsName(rs.getString(id));
//				topicdetailser.settopicdetailsId(rs.getInt("topicdetailsId"));
//				topicdetailser.setBoolean(3, signup.getBoolean());
//				topicdetailser.setCreatedAt(rs.getDate("createdAt"));
//				topicdetailser.setPrice(rs.getBigDecimal("price"));
				
				topicdetails.add(major);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return topicdetails;
	}

	@Override
	public TopicDetailsModel findById(int id) {
		String sql = "SELECT * FROM topicdetails WHERE id = ? ";
		try {
			Connection con = super.getConnection();
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				TopicDetailsModel topicdetails = new TopicDetailsModel();

//				topicdetailser.settopicdetailsId(rs.getInt("topicdetailsId"));
//				topicdetailser.settopicdetailsName(rs.getString(id));
//				topicdetailser.settopicdetailsId(rs.getInt("topicdetailsId"));
//				topicdetailser.setCreatedAt(rs.getDate("createdAt"));
//				topicdetailser.setPrice(rs.getBigDecimal("price"));
				
				return topicdetails;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	@Override
	public List<TopicDetailsModel> findTopicDetailByTopicId(int topicId) {
		String sql = "select * from Topic, TopicDetails WHERE Topic.topicId=TopicDetails.topicId and Topic.topicId=?";
		List<TopicDetailsModel> topicdetails = new ArrayList<TopicDetailsModel>();
		try {
			Connection con = super.getConnection();
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1, topicId);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				TopicDetailsModel topicdetail = new TopicDetailsModel();

				topicdetail.setId(rs.getInt("id"));
				topicdetail.setTopicId(rs.getInt("topicId"));
				topicdetail.setStudentId(rs.getInt("studentId"));
				topicdetail.setLeader(rs.getBoolean("leader"));
				if(rs.getString("scores")!=null)
					topicdetail.setScores(rs.getFloat("scores"));
				
				topicdetails.add(topicdetail);
				
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return topicdetails;
	}
	
	@Override
	public String findMajorNameByTopicDetail(int topicId) {
		String sql = "select DISTINCT  Majors.majorName \r\n"
				+ "from Topic, Teachers, Majors \r\n"
				+ "Where topic.teacherId=Teachers.teacherId and Teachers.majorId=Majors.majorId and Topic.topicId=?";
//		List<TopicDetailsModel> topicdetails = new ArrayList<TopicDetailsModel>();
		try {
			Connection con = super.getConnection();
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1, topicId);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				return rs.getString("majorName");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	@Override
	public void insertLeader(TopicDetailsModel topicdetail) {
		// TODO Auto-generated method stub
		String sql = "INSERT INTO topicDetails(topicId, studentId, leader, scores) VALUES (?,?,1,-1)";
		try {
			Connection con = super.getConnection();
			PreparedStatement ps = con.prepareStatement(sql);
			
			ps.setInt(1, topicdetail.getTopicId());
			ps.setInt(2, topicdetail.getStudentId());
			ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
	@Override
	public void insertMenber(TopicDetailsModel topicdetail) {
		// TODO Auto-generated method stub
		String sql = "INSERT INTO topicDetails(topicId, studentId, leader, scores) VALUES (?,?,0,-1)";
		try {
			Connection con = super.getConnection();
			PreparedStatement ps = con.prepareStatement(sql);
			
			ps.setInt(1, topicdetail.getTopicId());
			ps.setInt(2, topicdetail.getStudentId());
			ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
}
