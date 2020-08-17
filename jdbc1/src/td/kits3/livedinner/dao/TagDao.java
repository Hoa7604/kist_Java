package td.kits3.livedinner.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

//import com.sun.corba.se.impl.protocol.giopmsgheaders.Message;

import tp.kits3.livedinner.io.Tag;

public class TagDao {
	private final String driver = "com.mysql.jdbc.Driver";
	private final String connectionDB = "jdbc:mysql://localhost:3306/livedinner";
	private final String user = "root";
	private final String pass = "123456";
	private Connection conn;
	
	/*
	public String getDriver() {
		return driver;
	}
	//if you make constructor with parameter
	//can't use default constructor new TagDao()
	//make
	public void setDriver(String driver) {
		this.driver = driver;
	}
	 */
	private void connection() {
		try {
			Class.forName(driver);
			 try {
				this.conn = DriverManager.getConnection(connectionDB, user, pass);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			String message = "";
			message += TagDao.class.getSimpleName();
			message += " : connection()";
			System.out.println(message);
			System.out.println("number");
			e.printStackTrace();
		}
	}
	
	public List<Tag> findAll() {
		List<Tag> list = null;
		// TODO Auto-generated method stub
		//Connection here
		connection();
		//CRUD here
		//request to DB 
			//Statement -> preparedStatement (focus different with its : "execute_Name")
		Statement stmt = null;																//|
		ResultSet rs = null; 																//| prepare take DB
		String sql_selectAll = "select * from tag";											//|
		try {
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql_selectAll);
			list = new ArrayList<Tag>();
			while(rs.next()) {
				Tag tags = new Tag();
				tags.setTagid(rs.getInt("tagid"));
				tags.setTgname(rs.getNString("tgname"));
				list.add(tags);
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace(); //show message sql error
		}finally {
			try {rs.close();} catch (Exception e) {}
			try {stmt.close();} catch (Exception e) {}
			try {conn.close();} catch (Exception e) {}
			//macAccess
		}
		//request to servlet
		return list;
	}

	public void save(Tag tag) {
		connection();
		Statement stmt = null;																//|
		ResultSet rs = null; 																//| prepare take DB
		String sql_insert = "insert into tag (tgname) values('"+ tag.getTgname()+"')";											//|
		try {
					stmt = conn.createStatement();
					if (stmt.execute(sql_insert)) {
						System.out.println("insert success");
					}else {
						System.out.println("insert fail");
					}
				} catch (Exception e) {
					// TODO: handle exception
					e.printStackTrace(); //show message sql error
				}finally {
					try {rs.close();} catch (Exception e) {}
					try {stmt.close();} catch (Exception e) {}
					try {conn.close();} catch (Exception e) {}
					//macAccess
				}
				//request to servlet
				return;
	}
	
	public void update(Tag tag) {
		//insert, update
		if (tag.getTagid() == null || tag.getTagid() == 0) {
			save(tag);
			return;
		}
		connection();
		Statement stmt = null;																									//|
		ResultSet rs = null; 																									//| prepare take DB
		String sql_insert = "update tag set tgname = '"+ tag.getTgname()+"'"+"where tgid = '"+ tag.getTagid()+"'";				//|
		try {
					stmt = conn.createStatement();
					if (stmt.execute(sql_insert)) {
						System.out.println("insert success");
					}else {
						System.out.println("insert fail");
					}
				} catch (Exception e) {
					// TODO: handle exception
					e.printStackTrace(); //show message sql error
				}finally {
					try {rs.close();} catch (Exception e) {}
					try {stmt.close();} catch (Exception e) {}
					try {conn.close();} catch (Exception e) {}
					//macAccess
				}
				//request to servlet
		return;
	}
	
}
