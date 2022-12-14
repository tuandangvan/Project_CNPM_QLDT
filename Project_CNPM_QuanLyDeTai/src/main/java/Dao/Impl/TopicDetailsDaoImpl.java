package Dao.Impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.sql.Date;

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
	
}
