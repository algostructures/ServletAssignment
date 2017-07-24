package Question_5;

import javax.servlet.RequestDispatcher;
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
@WebServlet(name = "Q5_Servlet")
public class Q5_Servlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        PrintWriter pw = response.getWriter();
        request.getParameter("name");
        response.setContentType("text/html");
        pw.print("from source 1<br>");
        RequestDispatcher rd_1 = request.getRequestDispatcher("Q5_RD_1");
        request.setAttribute("fst", "this_is_param_1");
        pw.print("this is before include");
        rd_1.include(request, response);
        pw.print("this is after include");
    }
}
