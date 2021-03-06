package tp.kits3.servlet;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import td.kits3.livedinner.dao.CategoryDao;
import tp.kits3.livedinner.io.Category;

/**
 * Servlet implementation class categoryServlet
 */
@WebServlet("/category/list")
public class categoryServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public categoryServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
	//	request.getAttribute("nameMenu");//noi nhan dung
		CategoryDao dao = new CategoryDao();
		List<Category> list = dao.findAll();
		if (list.size() == 0) {
			System.out.println("list have empty");
		}
		String divList = "<div class'ctgList'>";
		for(Category ct : list) {
			divList += "<p><a href='update?ctgid="+ ct.getCtgid()+ "'>" + ct.toString() + "</a></p>";
			
		}
		divList += "<p><a href='add'>/category/add</p></a>";
		divList += "</div>";
		
		response.setContentType("text/html; charset = UTF-8");
		response.getWriter().append(divList);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
