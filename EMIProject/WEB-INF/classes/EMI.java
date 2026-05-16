import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class EMI extends HttpServlet
{
    public void doPost(HttpServletRequest req,
                       HttpServletResponse res)
                       throws ServletException, IOException
    {
        res.setContentType("text/html");

        PrintWriter out = res.getWriter();

        double amount = Double.parseDouble(req.getParameter("amount"));
        double rate = Double.parseDouble(req.getParameter("rate"));
        int months = Integer.parseInt(req.getParameter("months"));

        double r = rate / (12 * 100);

        double emi =
        (amount * r * Math.pow(1 + r, months)) /
        (Math.pow(1 + r, months) - 1);

        out.println("<h2>EMI = " + emi + "</h2>");
    }
}