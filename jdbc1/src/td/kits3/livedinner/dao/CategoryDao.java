package td.kits3.livedinner.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

//Java Name DI
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import tp.kits3.livedinner.io.Category;
/*
 * 
 * use DataSource and connection Pool
 * @author bitcamp
 * 
 */
@SuppressWarnings("unused")
public class CategoryDao {

//	private DataSource datasource;
//	
//	public CategoryDao() {
//		//super() su dung super khi co externs
//		try {
//			Context ctx = new InitialContext(); //khoi tao
//			//get info of tomcat
//			Context envCtx = (Context)ctx.lookup("java:/comp/env"); //search and get to servlet container
//			//get info in contex.xml
//			this.datasource = (DataSource) envCtx.lookup("jdbc/mysql");
//		} catch (Exception e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		} //
//	}
	private final String driver = "com.mysql.cj.jdbc.Driver";
	private final String connectionDB = "jdbc:mysql://127.0.0.1:3306/livedinner?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
	private final String user = "root";
	private final String pass = "duchoa7604@";
	private Connection conn;
	
	
	public List<Category> findAll(){
		ResultSet rs = null;
		PreparedStatement pstmt = null;
		Connection conn = null;
		List<Category> list = new ArrayList<Category>();
		//list not null
		try {
//			conn = this.datasource.getConnection();
			Class.forName(driver);			
			conn = DriverManager.getConnection(connectionDB,user,pass);
			String selectAll = "select * from cateory";
			pstmt = conn.prepareStatement(selectAll);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				Category category = new Category();
				category.setCtgid(rs.getInt("ctgid"));
				category.setCtname(rs.getString("ctname"));
				category.setService(rs.getString("service"));
				list.add(category);
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		
		try {
			rs.close();
			pstmt.close();
			conn.close();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return list;
		
		// TODO Auto-generated method stub
	}
	public void save(Category category) {
		// TODO Auto-generated method stub
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
//			conn = this.datasource.getConnection();
			Class.forName(driver);			
			conn = DriverManager.getConnection(connectionDB,user,pass);
			String insert = "insert into cateory (ctname, service) values (?,?)";
			pstmt = conn.prepareStatement(insert);
			pstmt.setString(1, category.getCtname());
			pstmt.setString(2, category.getService());
			pstmt.executeUpdate();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}finally {
			try {
				
			} catch (Exception e2) {
				// TODO: handle exception
			}
		}
	}
	
	public Category findOne(int ctgid) {
		// TODO Auto-generated method stub
		System.out.println(ctgid);
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		Category category = new Category();
		try {
//			conn = this.datasource.getConnection();
			Class.forName(driver);			
			conn = DriverManager.getConnection(connectionDB,user,pass);
			String selectOne = "select * from cateory where ctgid = ?";
			pstmt = conn.prepareStatement(selectOne);
			pstmt.setInt(1, ctgid);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				category = new Category();
				category.setCtgid(rs.getInt("ctgid"));
				category.setCtname(rs.getString("ctname"));
				category.setService(rs.getString("service"));
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}finally {
			try {
				
			} catch (Exception e2) {
				// TODO: handle exception
			}
		}
		return category;
	}
	public void update(Category category) {
		// TODO update need WHERE statment
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		System.out.println(category);
		try {
//			conn = this.datasource.getConnection();
			Class.forName(driver);			
			conn = DriverManager.getConnection(connectionDB,user,pass);
			String update = "update cateory set ctname = ?, service = ? where ctgid = ?";
			pstmt = conn.prepareStatement(update);
			pstmt.setString(1, category.getCtname());
			pstmt.setString(2, category.getService());
			pstmt.setInt(3, category.getCtgid());
			System.out.println();
//			rs = pstmt.executeQuery();
			pstmt.executeUpdate();
//			System.out.println(rs.getString("ctname"));
//			if(rs.next()) {
//				category = new Category();
//				category.setCtgid(rs.getInt("ctgid"));
//				category.setCtname(rs.getString("ctname"));
//				category.setService(rs.getString("service"));
//			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}finally {
			try {
				
			} catch (Exception e2) {
				// TODO: handle exception
			}
		}
	}

}
