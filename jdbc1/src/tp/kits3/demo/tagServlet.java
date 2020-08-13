package tp.kits3.demo;

import java.io.IOException;
//import java.sql.Connection;
//import java.sql.DriverManager;
//import java.sql.ResultSet;
//import java.sql.SQLException;
//import java.sql.Statement;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import td.kits3.livedinner.dao.TagDao;
import tp.kits3.livedinner.io.Tag;

/*
 * 
 * 
 * Servlet implementation class tagServlet */

@WebServlet("/tag/*")
public class tagServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
//      private Connection conn;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public tagServlet() {
        super();
        // TODO Auto-generated constructor stub
        //just once called by servlet container
//        initConnection();
    }

  /*  
    private void initConnection() {
//    	Connection conn;
    	try {
			conn = DriverManager.getConnection("jdbc:mariadb://localhost:3306/livedinner", "root", "123456");
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	try {
			Statement stmt = conn.createStatement();
			String sql = "select * from tag";
			ResultSet rs = stmt.executeQuery(sql); //need to get data
			while(rs.next()) {
				//abstract method
//				resolver(rs);
				int tid = rs.getInt("tagid");
				String tname = rs.getString("tgname");
				System.out.println(tid+":"+tname);
			}
			//order
			
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
    }
    
//	protected abstract void resolver(ResultSet rs);
/*
 * what concept java oop
 * 1. re-use (one multi use)
 * 2.east to maintaince(repair, upgrade, update)
 */
/*
	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		super.destroy();
	}
*/
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//PathVariable <--spring framework famous
		String[] uri = request.getRequestURI().split("/"); //,<- what command
		String command = uri[(uri.length - 1)];
		TagDao dao = new TagDao();
		if ("insert".equals(command)) {
			Tag tag = new Tag();
//			tag.setTagid(tagid);  <-- primary key auto incremant
			String tgname = request.getParameter("tgname");
			tag.setTgname(tgname);
			dao.save(tag);
		}
		
		if ("list".equals(command)) {
			List<Tag> list = dao.findAll(); //selectAll
			//make HTML to response
			
			String table = "<table>";
			for(Tag t : list) {
				int tid = t.getTagid();
				String tname = t.getTgname();
				table += "<tr><td>"+tid+"</td><td>"+tname+"</td></tr>";
				//or consider oeverride toString method
				//table += t.toString();
			}
			table += "</table>";
			response.getWriter().println(table);
		}else {
			System.out.println("null list");
		}
		
		
		/*Statement stmt = null;
		ResultSet rs = null;
		// TODO Auto-generated method stub
		try {
			Class.forName("org.mariadb.jdbc.Driver");
			try {
				Connection conn = DriverManager.getConnection("jdbc:mariadb://localhost:3306/livedinner", "root", "123456");
//				System.out.println(conn);
				 stmt = conn.createStatement();
				String sql = "select * from tag";
				//boolean rs = stmt.excute(sql); //success ? update ?, insert
				 rs = stmt.executeQuery(sql); //need to get data
				while(rs.next()) {
					int tid = rs.getInt("tagid");
					String tname = rs.getString("tgname");
					System.out.println(tid+":"+tname);
				}
				
				conn.close(); //is fiel when create Constructor
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} finally {
				//outside scope(block) of define
				//all stream have to close
				try {
					rs.close();
				} catch (Exception e2) {
					// TODO: handle exception
				}
				try {
					stmt.close();
				} catch (Exception e2) {
					// TODO: handle exception
				}
				
			}
			//set your db
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		*/
	/*	String uri = request.getRequestURI();
		String[] splitedURI = uri.split("/");
		//what last index of array
		int last = splitedURI.length - 1;
		response.getWriter().append("Served at: ").append(splitedURI[last]);*/
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
