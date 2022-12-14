package Dao.Impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.sql.Date;

import Connection.DBConnection;
import Dao.ICouncilDetailsDao;
import Models.CouncilDetailsModel;

public class CouncilDetailsDaoImpl extends DBConnection implements ICouncilDetailsDao{
	@Override
	public void insert(CouncilDetailsModel councildetail) {
		// TODO Auto-generated method stub
		String sql = "INSERT INTO councildetail(councildetailName,gender,birth,email,phone) VALUES (?,?,?,?,?)";
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

	@Override
	public void delete(int id) {
		String sql = "DELETE FROM councildetail WHERE councildetailId = ?";
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
		List<CouncilDetailsModel> councildetailers= new ArrayList<CouncilDetailsModel>();
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
	
}
