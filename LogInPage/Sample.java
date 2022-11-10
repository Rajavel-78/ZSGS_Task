package Clasess;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.ZoneId;
import java.util.TimeZone;

/**
 * Servlet implementation class Sample
 */
@WebServlet("/registerServlet")
public class Sample extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Sample() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		PrintWriter out=response.getWriter();
		String name=request.getParameter("name");
		String password=request.getParameter("password");
		if(name.equals("Rajavel")&&password.equals("12345")) {
			out.println("WELCOME TO "+name);
			 java.util.Date date = new java.util.Date(); 
			 ZoneId zoneId = TimeZone.getDefault().toZoneId();
			    System.out.println(date);  
			   
		out.print("DATE :: "+date);
		out.print("LOCATION :: "+zoneId);
		
		
		}
		else {
			
		}		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
