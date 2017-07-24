package Question_3;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Created by prajapas on 7/17/2017.
 */
@WebServlet(name = "ServletRD")
public class ServletRD extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        PrintWriter pw = response.getWriter();
        request.getParameter("name");
        response.setContentType("text/html");
        pw.print("from source");
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        RequestDispatcher rd_1 = request.getRequestDispatcher("Q3Servlet1");
        RequestDispatcher rd_2 = request.getRequestDispatcher("Q3Servlet2");
        request.setAttribute("fst", "this_is_param_1");
        request.setAttribute("snd", "this_is_param_2");
        pw.print("This is Before Include");
        rd_1.include(request, response);
        rd_2.include(request, response);
        pw.print("This is After Include");
    }
}
