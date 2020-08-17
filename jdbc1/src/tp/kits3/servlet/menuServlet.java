package tp.kits3.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class menuServlet
 */
@WebServlet("/menu/list")
public class menuServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
//    private static String driverManager;
//    private static String connectionSQL;
//    private static String userN;
//    private static String passW;
    
//    driverManager = "org.mariadb.jdbc.Driver";
//    connectionSQL = "";
    /**
     * @see HttpServlet#HttpServlet()
     */
    public menuServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
//		Class.forName(driverManager);
		response.getWriter().append("Served at: ").append(request.getContextPath());
		
		String profix = "/WEB-INF/views/";
		String subfix = ".jsp";
		
		RequestDispatcher dispatcher = request.getRequestDispatcher(profix+"menu"+subfix);
		dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
