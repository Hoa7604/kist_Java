package tp.kits3.upload;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class FileDowloadServlet
 */
@WebServlet("/download.do")
public class FileDowloadServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public FileDowloadServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		
		String filePath = getServletContext().getInitParameter("downloadPath");
		String fileName = (String) request.getParameter("pho");
		//open stream for binary (file is not string)
		OutputStream out = response.getOutputStream(); // gui file binary thi phai co inputstream va outputstream
		File sendFile = new File( filePath + File.separator + fileName);
		//add file data in header
		response.setHeader("Cache-Control", "no-cache");
		response.addHeader("Content-disposition", "attachment; fileName= "+fileName); 
		//to ready by browser
		//read file from Disk
		FileInputStream in = new FileInputStream(sendFile);
		byte[] buffer = new byte[1024 * 8]; //byte stream is binary
		while( true ) {
			int count = in.read(buffer); // read in file and save in buffer
			//count is bytes from file
			if(count == -1) { //if count == 1 end of file
				break;
			}
			out.write(buffer, 0, count); //send to client
		}
		
		in.close();
		out.close();
		
//		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
