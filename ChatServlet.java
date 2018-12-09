package tp.mri.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;
import java.util.Enumeration;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import jdk.internal.org.objectweb.asm.util.Printer;

/**
 * Servlet implementation class ChatServlet
 */
@WebServlet("/Chat")
public class ChatServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private StringBuffer chatContent;   
	private final String SaisiUser = "bob";

    /**
     * @see HttpServlet#HttpServlet()
     */
    public ChatServlet() {
        super();
        // TODO Auto-generated constructor stub
    }
	/**
	 * @throws ServletException 
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
    
    public void init(ServletConfig conf) throws ServletException {
    	super.init(conf);
    	chatContent = new StringBuffer();
    	
    	chatContent.append("Bienvenue sur le chat").append("<br>");

    	chatContent.append("Soyez polis").append("\n");
    	/*log("Contextinitparameters:");
    	ServletContext context = getServletContext();
    	Enumeration	e = context.getInitParameterNames();
    	while(e.hasMoreElements()) {
    		    	
    	}
    	 */   	
    }
    
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
	
		response.setContentType("text/html");
		PrintWriter out = response.getWriter() ;
		
		out.println("<label>" + chatContent.toString()+"</label>");
		out.println(new Date());
		
		
		
		//Recuperation de la cookies
				PrintWriter outs = response.getWriter();
				response.setContentType("text/html"); // Set the Content-Type header
				String userName=null;
				Cookie[] cookies = request.getCookies();
				//System.out.println(cookies);
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
				outs.println("<html><head><title>Succcess</title></head><body>");
				outs.println ("<label>: " + userName+ "> </label>");
				//outs.println("<br>");
				

				String action = request.getParameter("action");
				if (action != null && action.equals("Envoyer")) {
				    // Ajouter la ligne au contenu
					Affiche chat = new Affiche(); 
					chat.doGet(request, response);
					//LoginServlet log= new LoginServlet();
					//log.doGet(request, response);
					
					}
				
				
						
		RequestDispatcher rd = request.getRequestDispatcher("chat.jsp");
		request.setAttribute("content", chatContent.toString());
		rd.include(request, response);
		outs.println("<form action=\"Login.html\" method=\"post\">");
		outs.println("<input type=\"submit\"value=\"Deconnecter\" >");
		outs.println("</form>");
		outs.println("</body></html>");
		
    }
    

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		//String action = request.getParameter("");
	     //PrintWriter out = response.getWriter() ;
         doGet(request, response);
	}

}
