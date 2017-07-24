package Question_10;

import javax.servlet.RequestDispatcher;
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
@WebServlet(name = "Q10_Servlet1")
public class Q10_Servlet1 extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        System.out.println("Q_10Servlet1");
        PrintWriter pw = response.getWriter();
        request.setAttribute("s", "Servlet1_Attribute");
        RequestDispatcher rd = request.getRequestDispatcher("Q10_Servlet2");
        rd.forward(request, response);
    }
}
