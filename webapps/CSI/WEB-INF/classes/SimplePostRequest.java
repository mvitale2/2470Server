import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.concurrent.ConcurrentHashMap;

public class SimplePostRequest extends HttpServlet {

    private static final ConcurrentHashMap<String, Integer> voteCounts = new ConcurrentHashMap<>();

    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String voteOption = request.getParameter("voteOption");

        // Increment vote count for "yes" or "no"
        if ("yes".equals(voteOption) || "no".equals(voteOption)) {
            voteCounts.compute(voteOption, (key, val) -> (val == null) ? 1 : val + 1);
        }

        // Redirect to doGet to display current vote counts
        doGet(request, response);
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        out.println("<html><head><title>Current Vote Counts</title></head><body>");
        out.println("<h1>Current Vote Counts</h1>");
        out.println("<p>Yes: " + voteCounts.getOrDefault("yes", 0) + "</p>");
        out.println("<p>No: " + voteCounts.getOrDefault("no", 0) + "</p>");
        out.println("</body></html>");
    }
}