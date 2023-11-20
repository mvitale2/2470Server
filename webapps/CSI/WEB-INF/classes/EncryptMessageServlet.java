import javax.servlet.*;
import javax.servlet.http.*;

import java.io.IOException;

public class EncryptMessageServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String message = request.getParameter("message");
        String encryptedMessage = encryptMessage(message);
        response.setContentType("text/html");
        response.getWriter().println("Encrypted Message: ");
    }

    private String encryptMessage(String message) {
        //needs actual encryption logic
        return "encrypted_" + message; //Placeholder
    }
}
