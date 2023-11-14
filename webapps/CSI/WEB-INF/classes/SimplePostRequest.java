import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;
public class SimplePostRequest extends HttpServlet 
{
    public void doPost(HttpServletRequest request, HttpServletResponse response)
		throws ServletException,IOException
    {                     
        String lastName = request.getParameter("lastName");
		String firstName = request.getParameter("firstName");            					       
		response.setContentType("text/html");
		PrintWriter out = null;
		try
		{
			out =  response.getWriter();
		}
		catch (IOException e) 
		{
  			e.printStackTrace();
		}		
		out.println("<html><head><title>  Request has been sent</title>");	 
		out.println("</head><body>");				
		out.print( "<br /><b><center><font color=\"RED\"><H2>The following request has been sent to the server:</H2></font>");		
        out.print( lastName );
		out.print( firstName );		
        out.println( "</center><br />" );
       	out.println("</body></html>");
    } 
}
