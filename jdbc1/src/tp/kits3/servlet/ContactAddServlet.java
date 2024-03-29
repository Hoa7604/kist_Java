package tp.kits3.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import td.kits3.livedinner.dao.ContactDAO;
import tp.kits3.livedinner.io.Contact;

/**
 * Servlet implementation class ContactAddServlet
 */
@WebServlet("/contact/add")
public class ContactAddServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ContactAddServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		ContactDAO contactdao = new ContactDAO();
		String form = "<div>";
		form += "<form method='post' action='add' >";
		form += "Contact.name: <input type='text' name='coname' require/><br>";
		form += "Contact.priphone: <input type='text' name='priphone' require/><br>";
		form += "Contact.subphone: <input type='text' name='subphone' /><br>";
		form += "Contact.email: <input type='address' name='email' require/><br>";
<<<<<<< HEAD
		form += "Contact.address: <input type='text' name='address' /><br>";
		form += "Contact.unused: <input type='checkbox' name='unused' /><br>";
		form += "Contact.openning: <input type='text' name='opening' /><br>";
		form += "Contact.weekday: <input type='text' name='weekday' /><br>";
		form += "Contact.weekend: <input type='text' name='weekend' /><br>";
		form += "Contact.aboutus: <input type='text' name='aboutus' /><br>";
=======
		form += "Contact.address: <input type='text' name='address' require/><br>";
		form += "Contact.unused: <input type='checkbox' name='unused' /><br>";
		form += "Contact.openning: <input type='text' name='opening' require/><br>";
		form += "Contact.weekday: <input type='text' name='weekday' require/><br>";
		form += "Contact.weekend: <input type='text' name='weekend' require/><br>";
		form += "Contact.aboutus: <input type='text' name='aboutus' require/><br>";
>>>>>>> 43f35c49a28213dffab30ebc2dca4b2ac0037650
		form += "Contact.latitude: <input type='text' name='latitude' /><br>";
		form += "Contact.logitude: <input type='text' name='logitude' />";
		form += " <input type='submit' value='Submit' />";
		form += "</form></div>";
		response.getWriter().append(form);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	@SuppressWarnings("unlikely-arg-type")
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub\
		ContactDAO dao = new ContactDAO();
		Contact contact = new Contact();
		contact.setConame(request.getParameter("coname"));
		contact.setPriphone(request.getParameter("priphone"));
		contact.setSubphone(request.getParameter("subphone"));
		contact.setEmail(request.getParameter("email"));
		contact.setAddress(request.getParameter("address"));
<<<<<<< HEAD
		Boolean a = true;
		String unused = request.getParameter("unused");
		if (unused == null) {
			a = false;
		}else {
			a = true;
		}
		contact.setUnused(a);		
		
=======
		boolean a = true;
		if (request.getParameter("unused") != null) {
			a = true;
		}else {
			a = false;
		}
		contact.setUnused(a);
>>>>>>> 43f35c49a28213dffab30ebc2dca4b2ac0037650
		contact.setOpening(request.getParameter("opening"));
		contact.setWeekday(request.getParameter("weekday"));
		contact.setWeekend(request.getParameter("weekend"));
		contact.setAboutus(request.getParameter("aboutus"));
		contact.setLatitude(Double.parseDouble(request.getParameter("latitude")));
		contact.setLogitude(Double.parseDouble(request.getParameter("logitude")));
		
		dao.save(contact);
		doGet(request, response);
	}

}
