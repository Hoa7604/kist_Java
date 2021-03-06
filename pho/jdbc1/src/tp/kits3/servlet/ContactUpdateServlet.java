package tp.kits3.servlet;

import java.io.IOException;

import javax.naming.Context;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import td.kits3.livedinner.dao.ContactDAO;
import tp.kits3.livedinner.io.Contact;

/**
 * Servlet implementation class ContactUpdateServlet
 */
@WebServlet("/contact/update")
public class ContactUpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ContactUpdateServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		int coid = Integer.parseInt(request.getParameter("coid"));
		ContactDAO contactdao = new ContactDAO();
		Contact contact = new Contact();
		contact = contactdao.findOne(coid);
		
//		request.setAttribute("ContactFind", contact);
		ServletContext svc = request.getServletContext();
		svc.setAttribute("ContactFind", contact);
		
		if (contact == null) {
			System.out.println("No co List");
		}else {
			String form = "<div>";
			form += "<form method='post' action='update' >";
			form += "Contact.id: <input type='text' name='coid' value = '"+contact.getCoid() +"' readonly/><br>";
			form += "Contact.name: <input type='text' name='coname' value = '"+contact.getConame()+"'/><br>";
			form += "Contact.priphone: <input type='text' name='priphone' value = '"+contact.getPriphone()+"'/><br>";
			form += "Contact.subphone: <input type='text' name='subphone' value = '"+contact.getSubphone()+"'/><br>";
			form += "Contact.email: <input type='address' name='email' value = '"+contact.getEmail()+"'/><br>";
			form += "Contact.address: <input type='text' name='address' value = '"+contact.getAddress()+"'/><br>";
			form += "Contact.unused: <input type='checkbox' name='unused' value = '"+contact.getUnused()+"' /><br>";
			form += "Contact.openning: <input type='text' name='opening' value = '"+contact.getOpening()+"' /><br>";
			form += "Contact.weekday: <input type='text' name='weekday' value='"+contact.getWeekday()+"' /><br>";
			form += "Contact.weekend: <input type='text' name='weekend' value='"+contact.getWeekend()+"'/><br>";
			form += "Contact.aboutus: <input type='text' name='aboutus' value='"+contact.getAboutus()+"'/><br>";
			form += "Contact.latitude: <input type='text' name='latitude' value='"+contact.getLatitude()+"'/><br>";
			form += "Contact.logitude: <input type='text' name='logitude' value='"+contact.getLogitude()+"'/>";
			form += " <input type='submit' value='Submit' />";
			form += "</form></div>";
			response.getWriter().append(form);
		}
		
		String profix = "/WEB-INF/views/";
		String subfix = ".jsp";
		RequestDispatcher dispatcher = request.getRequestDispatcher(profix + "contactupdate" +subfix);
		dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		ContactDAO dao = new ContactDAO();
		Contact contact = new Contact();
		contact.setCoid(Integer.parseInt(request.getParameter("coid")));
		contact.setConame(request.getParameter("coname"));
		contact.setPriphone(request.getParameter("priphone"));
		contact.setSubphone(request.getParameter("subphone"));
		contact.setEmail(request.getParameter("email"));
		contact.setAddress(request.getParameter("address"));
		Boolean a = true;
		String unused = request.getParameter("unused");
		if (unused == null) {
			a = false;
		}else {
			a = true;
		}
		contact.setUnused(a);		
		
		contact.setOpening(request.getParameter("opening"));
		contact.setWeekday(request.getParameter("weekday"));
		contact.setWeekend(request.getParameter("weekend"));
		contact.setAboutus(request.getParameter("aboutus"));
		contact.setLatitude(Double.parseDouble(request.getParameter("latitude")));
		contact.setLogitude(Double.parseDouble(request.getParameter("logitude")));
		
		dao.update(contact);
		doGet(request, response);
	}

}
