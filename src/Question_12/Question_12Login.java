package Question_12;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Created by prajapas on 7/20/2017.
 */
@WebServlet(name = "Question_12Login")
public class Question_12Login extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    }

    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        PrintWriter out = response.getWriter();
        String n=request.getParameter("username");
        String p=request.getParameter("userpass");
        response.setContentType("text/html");
        out.print("<LINK REL='StyleSheet' HREF='styles.css'>");
        System.out.println("here");
        //out.print("dsfkljdfkjakj");
        //out.println("Before if statement");
        if(validateLogin(n, p))//success
        {
            HttpSession session = request.getSession();
            session.setAttribute("username", n);
            session.setAttribute("password", p);
            String name= (String) session.getAttribute("username");
            out.print("<div id = top-right><a href='Q_12Logout'>Logout</a><br>");
        }
        else//failure
        {
            System.out.println("hereelse");
            out.print("<div id = center_1>Sorry UserName or Password Error!</div>");

            //instead of index.html, any servlet also can be used or included
            RequestDispatcher rd=request.getRequestDispatcher("/Q_12_Login.html");

            request.setAttribute("def", "this_parameter_added_by_servlet");

            //index.html page is included in the output along with message from current servlet
            rd.include(request, response);

            //out.print("This is after include");
        }

    }

    private boolean validateLogin(String usrnam, String passwd)
    {
        return true;
//        try {
//            System.out.println("Invalidate");
//            Connection con = JDBCHelper.getConnection();
//            PreparedStatement ps = con.prepareStatement("Select * from admin");
//            ps.executeQuery();
//            ResultSet rs = ps.getResultSet();
//            System.out.println("");
//            while(rs.next()){
//                String uname = rs.getString(1);
//                String pass = rs.getNString(2);
//                if(passwd.equals(pass) && usrnam.equalsIgnoreCase(uname))
//                {
//                    System.out.println("");
//                    JDBCHelper.close(con);
//                    return true;
//                }
//                else
//                {
//                    return false;
//                }
//            }
//
//
//        } catch (SQLException e){
//            return false;
//        }
//        return false;
    }

}
