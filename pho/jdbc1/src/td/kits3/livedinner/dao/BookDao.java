package td.kits3.livedinner.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
//import tp.kits3.servlet.Book;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;
//import com.sun.jmx.snmp.Timestamp;
import java.sql.Timestamp;
//import java.sql.Time;

import tp.kits3.livedinner.io.Book;

public class BookDao {
	private DataSource ds;
	
	public BookDao() {
		
		try {
			Context ctx = new InitialContext();
			this.ds = (DataSource) ((Context) ctx.lookup("java:/comp/env")).lookup("jdbc/mariadb");
		} catch (NamingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public List<Book> findAll() {
		// TODO Auto-generated method stub
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		List<Book> list = new ArrayList<Book>();
		try {
			conn = pstmt.getConnection();
			String find = "select * from book";
			pstmt = conn.prepareStatement(find);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				Book book = new Book();
				book.setBkid(rs.getInt("bkid"));
				book.setBkname(rs.getString("bkname"));
				book.setBkemail(rs.getString("bkemail"));
				book.setBkphone(rs.getString("bkphone"));
				book.setBktime(rs.getTimestamp("bktime"));
				book.setBknum(rs.getInt("bknum"));
				book.setBooking(rs.getString("booking"));
				book.setBkmemo(rs.getString("bkmemo"));
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		return null;
	}

}
