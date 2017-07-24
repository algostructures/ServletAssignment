package Question_10;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Created by prajapas on 7/19/2017.
 */
@WebServlet(name = "Q10_Servlet2")
public class Q10_Servlet2 extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        System.out.println("Here");
        String name = request.getParameter("userName");
        String place = request.getParameter("userPlace");
        String s = (String)request.getAttribute("s");
        PrintWriter pw = response.getWriter();
        pw.print(name+" "+place+" "+s);
    }
}
