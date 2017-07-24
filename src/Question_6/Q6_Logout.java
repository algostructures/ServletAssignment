package Question_6;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by prajapas on 7/20/2017.
 */
@WebServlet(name = "Q6_Logout")
public class Q6_Logout extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out=response.getWriter();
        HttpSession hs = request.getSession();
        long thisstart = (long) System.currentTimeMillis();
        if(hs.getAttribute("name") != null) {
            try {
                java.sql.Connection con = JDBCHelper.getConnection();
                PreparedStatement ps = con.prepareStatement("Select * from servlets");
                ps.executeQuery();
                ResultSet rs = ps.getResultSet();
                boolean found = false;
                while (rs.next()) {
                    if (rs.getString(1).equals(hs.getAttribute("name"))) {
                        long time = rs.getLong(2);
                        PreparedStatement ps1 = con.prepareStatement("UPDATE servlets set TimeMillis = ? where Page_Name = ?");
                        ps1.setLong(1, time + thisstart - (long) hs.getAttribute("time"));
                        String name = (String) hs.getAttribute("name");

                        ps1.setString(2, name);
                        ps1.executeUpdate();
                        found = true;

                    }
                }
                if (!found) {
                    PreparedStatement ps1 = con.prepareStatement("INSERT into servlets values(?,?)");
                    ps1.setString(1, (String) hs.getAttribute("name"));
                    ps1.setLong(2, thisstart - (long) hs.getAttribute("time"));
                    ps1.executeUpdate();
                    JDBCHelper.close(ps1);
                }

            } catch (SQLException e) {
                e.printStackTrace();
            }

        }

        HttpSession session=request.getSession(false);
        session.invalidate();

        out.print("You are successfully logged out!");

        out.close();
    }
}