package tp.mri.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class loginSuccess
 */
@WebServlet("/loginSuccess")
public class loginSuccess extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public loginSuccess() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		//Recuperation de la cookies
		
				PrintWriter out = response.getWriter();
				response.setContentType("text/html"); // Set the Content-Type header
				String userName=null;
				Cookie[] cookies = request.getCookies();
				System.out.println(cookies);
				if (cookies != null) {
						for (Cookie cookie: cookies) {
							if ( cookie.getName ().equals("login")) {
								userName = cookie.getValue();
							}
						}	
				}
				if (userName == null) {
						response.sendError(	HttpServletResponse.SC_FORBIDDEN);
					}
				out.println("<html><head><title>Succcess</title></head><body>");
				out.println ("<h3>Salut " + userName+ ", tout est ok !</h3>");
				out.println("<br>");
				out.println("<form action=\"Login.html\" method=\"post\">");
				out.println
				("<input type=\"submit\"value=\"Deconnecter\" >");
				out.println("</form>");
				out.println("</body></html>");
	
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
