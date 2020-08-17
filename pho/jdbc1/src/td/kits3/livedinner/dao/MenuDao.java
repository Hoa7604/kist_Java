package td.kits3.livedinner.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

import tp.kits3.livedinner.io.Category;
import tp.kits3.livedinner.io.Menu;

public class MenuDao {
	private DataSource ds;
	
	public MenuDao() {
		try {
			Context ctx = new InitialContext();
			//get info to tomcat
			Context envCtx = (Context) ctx.lookup("java:/comp/env");
//			System.out.println(ctx.lookup("java:/comp/env"));
//			System.out.println(envCtx);
			//get info to context.xml
			this.ds = (DataSource) envCtx.lookup("jdbc/mariadb");
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
	public List<Menu> findAll() {
		// TODO Auto-generated method stub
		ResultSet rs = null;
		PreparedStatement pstmt = null;
		Connection conn = null;
		List<Menu> list = new ArrayList<Menu>();
		try {
			conn = this.ds.getConnection();
			String selectAll = "select * from menu";
			pstmt = conn.prepareStatement(selectAll);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				Menu menu = new Menu();
				menu.setCtgid(rs.getInt("ctgid"));
				menu.setMuname(rs.getString("muname"));
				menu.setDetails(rs.getString("details"));
				menu.setCurrency(rs.getString("currency"));
				menu.setPrice(rs.getDouble("price"));
				menu.setIntro(rs.getString("intro"));
				list.add(menu);
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
	}

}
