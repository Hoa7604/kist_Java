package td.kits3.livedinner.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

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
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			conn = this.datasource.getConnection();
			String insert = "insert into contact (coname, priphone, subphone, email, address,unused, opening, weekday, weekend, aboutus, latitude, logitude) values(?,?,?,?,?,?,?,?,?,?,?,?)";
			pstmt = conn.prepareStatement(insert);
			pstmt.setString(1, contact.getConame());
			pstmt.setString(2, contact.getPriphone());
			pstmt.setString(3,  contact.getSubphone());
			pstmt.setString(4,  contact.getEmail());
			pstmt.setString(5, contact.getAddress());
			pstmt.setBoolean(parameterIndex, x);
			pstmt.setString(6, contact.getOpening());
			pstmt.setString(7, contact.getWeekday());
			pstmt.setString(8,  contact.getWeekend());
			pstmt.setString(9, contact.getAboutus());
			pstmt.setDouble(10,  contact.getLatitude());
			pstmt.setDouble(11,  contact.getLogitude());
			pstmt.executeUpdate();
		} catch (Exception e) {
			// TODO: handle exception
		}
	}

}
