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
@WebServlet(name = "Q5_RD_1")
public class Q5_RD_1 extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        PrintWriter pw = response.getWriter();
        response.setContentType("text/html");
        pw.print("from Request Dispatcher_1<br>");
        RequestDispatcher rd_2 = request.getRequestDispatcher("Q5_RD_2");
        request.setAttribute("snd", "this_is_param_2");
        rd_2.include(request, response);
    }
}
