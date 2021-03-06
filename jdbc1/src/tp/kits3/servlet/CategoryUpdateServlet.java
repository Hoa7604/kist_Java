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
 * Servlet implementation class CategoryUpdateServlet
 */
@WebServlet("/category/update")
public class CategoryUpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CategoryUpdateServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		int ctgid = Integer.parseInt(request.getParameter("ctgid"));
//		System.out.println(ctgid);
		CategoryDao dao = new CategoryDao();
		Category category = dao.findOne(ctgid); //selectOne
		if (category == null) {
			System.out.println("No co!");
		}else {
			String form = "<div>";
			form += "<form method='post' action='update'>";
			form += "Category.id <input type='text' name='ctgid' value = '"+category.getCtgid()+"' readonly />";
			form += "Category.name <input type='text' name='ctname' value = '"+category.getCtname()+"' />";
			form += "Category.service <input type='text' name='service' value = '"+category.getService()+"' />";
			form += "<input type='submit' value ='Update'>";
			form += "</form></div>"; 
			
			response.getWriter().append(form);
		}
			
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		CategoryDao dao = new CategoryDao();
		Category category = new Category();
		category.setCtgid(Integer.parseInt(request.getParameter("ctgid")));
		category.setCtname(request.getParameter("ctname"));
		if (request.getParameter("service").length() == 1) {
			category.setService(request.getParameter("service"));
			dao.update(category);
		}else {
			System.out.println("ko co");
		}
//		System.out.println(category.toString());
		
		//passing to Servlet, URL
//		response.sendRedirect("/jdbc1/category/list");
	}

}
