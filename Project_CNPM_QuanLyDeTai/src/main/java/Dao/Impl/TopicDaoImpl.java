package Dao.Impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import Connection.DBConnection;
import Dao.ITopicDao;
import Models.TopicModel;

public class TopicDaoImpl extends DBConnection implements ITopicDao{
	@Override
	public void insert(TopicModel topic) {
		// TODO Auto-generated method stub
		String sql = "INSERT INTO topic(topicName,gender,birth,email,phone) VALUES (?,?,?,?,?)";
		try {
			Connection con = super.getConnection();
			PreparedStatement ps = con.prepareStatement(sql);
			
//			ps.setString(1, topic.gettopicName());
//			ps.setBoolean(2, topic.getGender());
//			ps.setDate(3, topic.getBirth());
//			ps.setInt(6, topic.gettopicId());
			
			
			ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
	
	
	@Override
	public void edit(TopicModel topic) {
		String sql = "UPDATE  topic SET topicName=?, gender=?, birth=? email=?, phone=? WHERE topicId=?";
		try {
			Connection con = super.getConnection();
			PreparedStatement ps = con.prepareStatement(sql);
//			ps.setString(1, topic.gettopicName());
//			ps.setBoolean(2, topic.getGender());
//			ps.setDate(3, topic.getBirth());
//			ps.setInt(6, topic.gettopicId());
			
			ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public void delete(int id) {
		String sql = "DELETE FROM topic WHERE topicId = ?";
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
	public TopicModel get(int id) {
		String sql = "SELECT * FROM Topic WHERE topicId = ? ";
		try {
			Connection con = super.getConnection();
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				TopicModel topic = new TopicModel();
				topic.setTopicId(rs.getInt("topicId"));
				topic.setTopicName(rs.getString("topicName"));
				topic.setTeacherId(rs.getInt("teacherId"));
				topic.setDetail(rs.getString("detail"));
		
				return topic;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public List<TopicModel> getAll() {
		List<TopicModel> topics = new ArrayList<TopicModel>();
		String sql = "SELECT * FROM Topic";
		try {
			Connection con = super.getConnection();
			PreparedStatement ps = con.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				TopicModel topic = new TopicModel();
				
				topic.setTopicId(rs.getInt("topicId"));
				topic.setTopicName(rs.getString("topicName"));
				topic.setTeacherId(rs.getInt("teacherId"));
				topic.setDetail(rs.getString("detail"));
				
				topics.add(topic);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return topics;
	}

	@Override
	public TopicModel findById(int id) {
		String sql = "SELECT * FROM Topic WHERE topicId = ? ";
		try {
			Connection con = super.getConnection();
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				TopicModel topic = new TopicModel();
				topic.setTopicId(rs.getInt("topicId"));
				topic.setTopicName(rs.getString("topicName"));
				topic.setTeacherId(rs.getInt("teacherId"));
				topic.setDetail(rs.getString("detail"));
		
				return topic;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
}
