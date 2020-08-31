package tp.kits3.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//import com.google.gson.Gson;

import td.kits3.livedinner.dao.MenuDao;
import tp.kits3.livedinner.io.Menu;

/**
 * Servlet implementation class MenuListServlet
 */
@WebServlet("/menu/list")
public class MenuListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MenuListServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		MenuDao dao = new MenuDao();
		response.setContentType("text/html; charset=UTF-8");
		List<Menu> menulist = dao.findAll();
		request.setAttribute("MenuList", menulist);
		
		//servlet to servlet
		
		String prefix = "/WEB-INF/views/";
		String posfix = ".jsp";
		RequestDispatcher dispatcher = request.getRequestDispatcher(prefix+"menulist"+posfix);
		dispatcher.forward(request, response);
		
		
		
//		Menu menu = new Menu();
//		menu.setMuid(1);
//		menu.setCtgid(1);
//		Gson gson = new Gson(); //khoi tao Gson
//		String json = gson.toJson(menu); //Object to String
//		Menu obj = gson.fromJson(json, Menu.class);
		
		////share date all servlet
//		ServletContext ctx = getServletContext();
//		ctx.setAttribute("menu", new Menu());
		
//		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/views/menulist.jsp"); //mapping to servlet
//		// Servlet <-> JSP
//		// browser URL not change
//		dispatcher.forward(request, response);
//		request.setAttribute("nameMenu", new Menu());
		
		response.getWriter().append(""); //println();
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
