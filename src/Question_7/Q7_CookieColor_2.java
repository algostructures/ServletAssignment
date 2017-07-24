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
@WebServlet(name = "Q7_CookieColor_2")
public class Q7_CookieColor_2 extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        String s =request.getParameter("color");
        PrintWriter pw = response.getWriter();
        Cookie ck=new Cookie("color", s);
        ck.setMaxAge(24*60*60);
        response.addCookie(ck);
        pw.print("<body style='background-color:"+s+";'>");

    }
}
