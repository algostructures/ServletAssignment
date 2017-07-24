package Question_1_2;

import Question_8.JDBCHelper;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by prajapas on 7/17/2017.
 */
@WebServlet(name = "WelcomeServlet")
public class WelcomeServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    }

    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        PrintWriter out = response.getWriter();
        String n=request.getParameter("userName");
        String p=request.getParameter("userPass");
        response.setContentType("text/html");
        out.print("<LINK REL='StyleSheet' HREF='styles.css'>");
        System.out.println("here");
        if(validateLogin(n, p))//success
        {
            HttpSession session = request.getSession();
            session.setAttribute("username", n);
            session.setAttribute("password", p);
            String name= (String) session.getAttribute("username");
            out.print("<div id = top-right><a href='Logout'>Logout</a><br><a href='Servlet1'>Servlet1</a></div>");
            out.print("<div id = bottom-right>"+name+"</div>");
        }
        else//failure
        {
            out.print("<div id = center_1>Sorry UserName or Password Error!</div>");

            //instead of index.html, any servlet also can be used or included
            RequestDispatcher rd=request.getRequestDispatcher("/index.html");

            request.setAttribute("def", "this_parameter_added_by_servlet");

            //index.html page is included in the output along with message from current servlet
            rd.include(request, response);

            //out.print("This is after include");
        }

    }

    private boolean validateLogin(String usrnam, String passwd)
    {
        try {
            Connection con = JDBCHelper.getConnection();
            PreparedStatement ps = con.prepareStatement("Select * from admin");
            ps.executeQuery();
            ResultSet rs = ps.getResultSet();
            while(rs.next()){
                String uname = rs.getString(1);
                String pass = rs.getNString(2);
                if(passwd.equals(pass) && usrnam.equalsIgnoreCase(uname))
                {
                    JDBCHelper.close(con);
                    return true;
                }
                else
                {
                    return false;
                }
            }


        } catch (SQLException e){
            return false;
        }
        return false;
    }

}