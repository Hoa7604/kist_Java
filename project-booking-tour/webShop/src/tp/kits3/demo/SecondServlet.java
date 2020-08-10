package tp.kits3.demo;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.GenericServlet;
import javax.servlet.Servlet;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;


//@SuppressWarnings("serial")
@WebServlet("/hai")
public class SecondServlet extends GenericServlet {

	/**
	 * version of this class(servlet)
	 */
//	private static final long serialVersionUID = 1L;
	@Override
	public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//1.Set Content-type
		res.setContentType("text/html; charset=UTF-8");
		//2open OutputStream to client
		PrintWriter out = res.getWriter();
		//Send HTML DAta
		out.println("<html><head><title>SecondServlett</title></head>");
		out.println("<body>");
		out.println("<h1>Second Servlet by Response object </h1>");
		out.println("</body></html>");
	}

}
