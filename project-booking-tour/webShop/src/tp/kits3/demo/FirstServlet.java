package tp.kits3.demo;

import java.io.IOException;

import javax.servlet.Servlet;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;

//import short-key
//servlet container
		//servlet interface (implemets)
//servlet 3.0 can use Annotation if your use 2.5 under

@WebServlet("/mot")

public class FirstServlet implements Servlet{
	private ServletConfig config;
	
	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		System.out.println("FirstServlet :: destroy");
	}

	@Override
	public ServletConfig getServletConfig() {
		// TODO Auto-generated method stub
		return this.config;
	}

	@Override
	public String getServletInfo() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void init(ServletConfig config) throws ServletException {
		// TODO Auto-generated method stub
		this.config = config;
		System.out.println("FirstServlet :: init");
	}

	@Override
	public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.println("FirstServlet :: service");
	}
	
}
