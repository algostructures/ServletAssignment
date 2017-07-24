package Question_7;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Created by prajapas on 7/18/2017.
 */
@WebServlet(name = "Q7_CookieColor")
public class Q7_CookieColor extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        request.getCookies();
        Cookie ls[] = request.getCookies();
        PrintWriter pw = response.getWriter();
        //System.out.println(ls.length);
        if(ls != null){
            System.out.println("try");
            String s= ls[0].getValue();
            pw.print("<body style='background-color:"+s+";'>");

        }
        else {
            System.out.println("catch");
            pw.println("<form action = 'Q7_CookieColor_2'><select name = 'color'>"+
                    "<option value='#FF0000'>Red</option>" +
                    "<option value='#0000FF'>Blue</option>" +
                    "<option value='#00FF00'>Green</option>"+"</select>" +
                    "<input type = 'submit'>"+
                    "</form>");


        }
    }
}
