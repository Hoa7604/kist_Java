package tp.kits3.servlet;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;

import td.kits3.livedinner.dao.ContactDAO;
import tp.kits3.livedinner.io.Category;
import tp.kits3.livedinner.io.Contact;

/**
 * Servlet implementation class contactServlet
 */
@WebServlet("/contact/list")
public class contactServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public contactServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		ContactDAO contactdao = new ContactDAO();
		Contact contact = new Contact();
		List<Contact> listCT = new ArrayList<Contact>();
		List<Contact> list = new ArrayList<Contact>();
		list = contactdao.findAll();
//		listCT = contactdao.findOne(coid);
//		System.out.println(list);
		if (list.size() == 0) {
			System.out.println("List none");
		}
		String divList = "<div class'ctgList'>";
		for(Contact ct : list) {
			divList += "<p><a href='update?coid="+ ct.getCoid()+ "'>" + ct.toString() + "</a></p>";
		}
		divList += "<p><a href='add'>/contact/add</p></a>";
		divList += "</div>";
		
		response.setContentType("text/html; charset = UTF-8");
		response.getWriter().append(divList);
		
		//*************************************//
		request.setAttribute("ContactList", list);
		
		String profix = "/WEB-INF/views/";
		String subfix = ".jsp";
		RequestDispatcher dispatcher = request.getRequestDispatcher(profix + "contact" +subfix);
		dispatcher.forward(request, response);	
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		doGet(request, response);
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return super.toString();
	}
}
