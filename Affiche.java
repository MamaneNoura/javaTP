package tp.mri.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class afffiche
 */
@WebServlet("/affiche")
public class Affiche extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Affiche() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		response.setContentType("text/html");
		PrintWriter out = response.getWriter(); 
	
		String pname = request.getParameter("name");
		if(pname==null) {
			pname="World";
		}
		
			out.println ("<!DOCTYPE html>");
			out.println ("<html>");
			out.println ("<head> ");
			out.println ("	<title> Hello, "+ pname +"</title>");
			out.println( "        <link rel='stylesheet' type='text/css' href='styles.css' /> " );
			out.println ("</head>");
			out.println ("<body>");
			out.println("<label>" +pname +"<label>");
			
			out.println ("</body>"); 
			out.println ("</html>");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
