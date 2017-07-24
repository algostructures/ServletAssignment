package Question_4;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Created by prajapas on 7/18/2017.
 */
@WebServlet(name = "Q4_Servlet_2")
public class Q4_Servlet_2 extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter pw = response.getWriter();
        ServletContext context = getServletContext();
        String contextParam = context.getInitParameter("ContextParam");
        pw.println("Servlet 2 : ContextParam : " + contextParam);
        pw.close();
    }
}
