package Question_1_2;

import javax.servlet.RequestDispatcher;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.PrintWriter;

/**
 * Created by prajapas on 7/17/2017.
 */
@WebServlet(name = "Servlet1")
public class Servlet1 extends HttpServlet {
    public void doGet(HttpServletRequest request, HttpServletResponse response)
    {
        try{

            response.setContentType("text/html");
            PrintWriter out = response.getWriter();
            out.print("<LINK REL='StyleSheet' HREF='styles.css'>");
            //retrieve existing ssn, hence false parameter is sent
            HttpSession ssn=request.getSession(false);

            try{
                //retrieve the attribute uname, from the ssn
                String name = (String) ssn.getAttribute("username");
                //String password = (String) ssn.getAttribute("password");

                //invoke removeAttribute() if you want to remove any attribute
                //stored in the ssn
                //session.removeAttribute("attribute_name");
                out.print("<div id = top-right><a href='Logout'>Logout</p></a></div>");
                out.print("<div id = bottom-right>" + name + "<br></div>");
            }
            catch(NullPointerException e){
                out.print("<div id = center_1>You Don't Have Access Please Login</div>");
                RequestDispatcher rd=request.getRequestDispatcher("/index.html");

                //request.setAttribute("def", "this_parameter_added_by_servlet");

                //index.html page is included in the output along with message from current servlet
                rd.include(request, response);
            }
            //use invalidate method to completely destroy current ssn
            //so that it doesn't exist any more
            //ssn.invalidate();

            out.close();

        }catch(Exception e){System.out.println(e);}
    }
}
