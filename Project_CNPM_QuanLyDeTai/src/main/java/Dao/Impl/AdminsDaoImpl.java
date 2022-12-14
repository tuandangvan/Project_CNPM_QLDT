package Dao.Impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.sql.Date;

import Connection.DBConnection;
import Dao.IAdminsDao;
import Models.AdminsModel;

public class AdminsDaoImpl extends DBConnection implements IAdminsDao{
	@Override
	public void insert(AdminsModel admin) {
		// TODO Auto-generated method stub
		String sql = "INSERT INTO Admin(adminName,gender,birth,email,phone) VALUES (?,?,?,?,?)";
		try {
			Connection con = super.getConnection();
			PreparedStatement ps = con.prepareStatement(sql);
			
			ps.setString(1, admin.getAdminName());
			ps.setBoolean(2, admin.getGender());
			ps.setDate(3, admin.getBirth());
			ps.setString(4, admin.getEmail());
			ps.setString(5, admin.getPhone());
			
			ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
	
	
	@Override
	public void edit(AdminsModel admin) {
		String sql = "UPDATE  Admin SET adminName=?, gender=?, birth=? email=?, phone=? WHERE adminId=?";
		try {
			Connection con = super.getConnection();
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, admin.getAdminName());
			ps.setBoolean(2, admin.getGender());
			ps.setDate(3, admin.getBirth());
			ps.setString(4, admin.getEmail());
			ps.setString(5, admin.getPhone());
			
			ps.setInt(6, admin.getAdminId());
			ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public void delete(int id) {
		String sql = "DELETE FROM Admin WHERE adminId = ?";
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
	public AdminsModel get(int id) {
		String sql = "SELECT * FROM admin WHERE username = ? ";
		try {
			Connection con = super.getConnection();
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				AdminsModel adminer = new AdminsModel();
				adminer.setAdminId(rs.getInt("adminId"));
				adminer.setAdminName(rs.getString(id));
		
				return adminer;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public List<AdminsModel> getAll() {
		List<AdminsModel> adminers= new ArrayList<AdminsModel>();
		String sql = "SELECT * FROM admin";
		try {
			Connection con = super.getConnection();
			PreparedStatement ps = con.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				AdminsModel adminer = new AdminsModel();
				adminers.add(adminer);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return adminers;
	}

	@Override
	public AdminsModel findById(int id) {
		String sql = "SELECT * FROM admin WHERE id = ? ";
		try {
			Connection con = super.getConnection();
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				AdminsModel adminer = new AdminsModel();

				return adminer;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
}
