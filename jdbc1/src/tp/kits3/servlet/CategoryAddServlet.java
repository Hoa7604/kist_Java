package tp.kits3.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import td.kits3.livedinner.dao.CategoryDao;
import tp.kits3.livedinner.io.Category;

/**
 * Servlet implementation class CategoryAddServlet
 */
@WebServlet("/category/add")
public class CategoryAddServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CategoryAddServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO show form insert
//		int ctgid = Integer.parseInt(request.getParameter("ctgid"));
//		System.out.println(ctgid);
//		CategoryDao dao = new CategoryDao();
//		Category category = dao.findOne(ctgid); //selectOne
		String form = "<div>";
		form += "<form method='post' action='add'>" ;
		form += "Category.name <input type='text' name ='ctname' require />";
		form += "Category.service <input type='text' name ='service' require />";
		form += "<input type='submit' value ='Add'>";
		form += "</form></div>"; 
		
		response.getWriter().append(form);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO save to DB
		CategoryDao dao = new CategoryDao();
		Category category = new Category();
		category.setCtname(request.getParameter("ctname"));
		category.setService(request.getParameter("service"));
		category.toString();
		dao.save(category);
//		response.sendRedirect("/jdbc1/category/add");
//		doGet(request, response);
	}

}
