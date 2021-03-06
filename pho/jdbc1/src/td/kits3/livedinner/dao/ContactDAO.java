package td.kits3.livedinner.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

import tp.kits3.livedinner.io.Contact;

public class ContactDAO {
	DataSource datasource;
	public ContactDAO() {
		try {
			Context ctx = new InitialContext();
			//get info to tomcat
			Context envCtx = (Context) ctx.lookup("java:/comp/env");
			//get info to context.xml
			this.datasource = (DataSource) envCtx.lookup("jdbc/mariadb");
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
	public void save(Contact contact) {
		// TODO Auto-generated method stub
		System.out.println(contact.toString());
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			conn = this.datasource.getConnection();
			String insert = "insert into contact (coname, priphone, subphone, email, address, unused, opening, weekday, weekend, aboutus, latitude, logitude) values(?,?,?,?,?,?,?,?,?,?,?,?)";
			pstmt = conn.prepareStatement(insert);
			pstmt.setString(1, contact.getConame());
			pstmt.setString(2, contact.getPriphone());
			pstmt.setString(3,  contact.getSubphone());
			pstmt.setString(4,  contact.getEmail());
			pstmt.setString(5, contact.getAddress());
			pstmt.setBoolean(6, contact.getUnused());		
			pstmt.setString(7, contact.getOpening());
			pstmt.setString(8, contact.getWeekday());
			pstmt.setString(9, contact.getWeekend());
			pstmt.setString(10, contact.getAboutus());
			pstmt.setDouble(11, contact.getLatitude());
			pstmt.setDouble(12, contact.getLogitude());
			pstmt.executeUpdate();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
	
	public Contact findOne(int coid) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		Contact contact = new Contact();
		System.out.println(coid);
		try {
			conn = this.datasource.getConnection();
			String find = "select * from contact where coid = ?";
			pstmt = conn.prepareStatement(find);
			pstmt.setInt(1, coid);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				 contact = new Contact();
				contact.setCoid(rs.getInt("coid"));
				contact.setConame(rs.getString("coname"));
				contact.setPriphone(rs.getString("priphone"));
				contact.setSubphone(rs.getString("subphone"));
				contact.setEmail(rs.getString("email"));
				contact.setAddress(rs.getString("address"));
				contact.setUnused(rs.getBoolean("unused"));
				contact.setOpening(rs.getString("opening"));
				contact.setWeekday(rs.getString("weekday"));
				contact.setWeekend(rs.getString("weekend"));
				contact.setAboutus(rs.getString("aboutus"));
				contact.setLatitude(rs.getDouble("latitude"));
				contact.setLogitude(rs.getDouble("logitude"));
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		// TODO Auto-generated method stub
		return contact;
	}
	
	public void update(Contact contact) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			conn = this.datasource.getConnection();
			String update = "update contact set coname = ?, priphone=?, subphone=?, email=?, address=?, unused=?, opening=?, weekday=?, weekend=?, aboutus=?, latitude=?, logitude=? where coid = ?";
			pstmt = conn.prepareStatement(update);
			pstmt.setString(1, contact.getConame());
			pstmt.setString(2, contact.getPriphone());
			pstmt.setString(3,  contact.getSubphone());
			pstmt.setString(4,  contact.getEmail());
			pstmt.setString(5, contact.getAddress());
			pstmt.setBoolean(6, contact.getUnused());		
			pstmt.setString(7, contact.getOpening());
			pstmt.setString(8, contact.getWeekday());
			pstmt.setString(9, contact.getWeekend());
			pstmt.setString(10, contact.getAboutus());
			pstmt.setDouble(11, contact.getLatitude());
			pstmt.setDouble(12, contact.getLogitude());
			pstmt.setInt(13, contact.getCoid());
			rs = pstmt.executeQuery();
			if (rs.next()) {
				contact.setConame(rs.getString("coname"));
				contact.setPriphone(rs.getString("priphone"));
				contact.setSubphone(rs.getString("subphone"));
				contact.setEmail(rs.getString("email"));
				contact.setAddress(rs.getString("address"));
				contact.setUnused(rs.getBoolean("unused"));
				contact.setOpening(rs.getString("opening"));
				contact.setWeekday(rs.getString("weekday"));
				contact.setWeekend(rs.getString("weekend"));
				contact.setAboutus(rs.getString("aboutus"));
				contact.setLatitude(rs.getDouble("latitude"));
				contact.setLogitude(rs.getDouble("logitude"));
				contact.setCoid(rs.getInt("coid"));
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		// TODO Auto-generated method stub
		
	}
	public List<Contact> findAll() {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		Contact contact = new Contact();
		List<Contact> list = new ArrayList<Contact>();
		try {
			conn = this.datasource.getConnection();
			String find = "select * from contact";
			pstmt = conn.prepareStatement(find);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				contact = new Contact();
				contact.setCoid(rs.getInt("coid"));
				contact.setConame(rs.getString("coname"));
				contact.setPriphone(rs.getString("priphone"));
				contact.setSubphone(rs.getString("subphone"));
				contact.setEmail(rs.getString("email"));
				contact.setAddress(rs.getString("address"));
				contact.setUnused(rs.getBoolean("unused"));
				contact.setOpening(rs.getString("opening"));
				contact.setWeekday(rs.getString("weekday"));
				contact.setWeekend(rs.getString("weekend"));
				contact.setAboutus(rs.getString("aboutus"));
				contact.setLatitude(rs.getDouble("latitude"));
				contact.setLogitude(rs.getDouble("logitude"));
				list.add(contact);
			}
		} catch (Exception e) {
			// TODO: handle exception
			
			try {
				rs.close();
				pstmt.close();
				conn.close();
			} catch (Exception e2) {
				// TODO: handle exception
				e.printStackTrace();
			}
		}
		// TODO Auto-generated method stub
		return list;
	}
}
