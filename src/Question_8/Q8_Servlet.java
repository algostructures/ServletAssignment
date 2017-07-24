package Question_8;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by prajapas on 7/21/2017.
 */
@WebServlet(name = "Q8_Servlet")
public class Q8_Servlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        String username = request.getParameter("username");
        try {
            Connection con = JDBCHelper.getConnection();
            PreparedStatement ps = con.prepareStatement("SELECT * from signup");
            ps.executeQuery();
            ResultSet rs = ps.getResultSet();
            boolean already = false;
            while(rs.next()){
                if(rs.getString("username").equals(username)){
                    out.print("Error : username already exits!");
                    RequestDispatcher rd = request.getRequestDispatcher("SignUp.html");
                    rd.include(request, response);
                    already = true;
                }
            }
            if(!already) {
                String name = request.getParameter("name");
                String password = request.getParameter("password");
                long phone = Long.parseLong(request.getParameter("phone"));
                String email = request.getParameter("email");
                PreparedStatement ps1 = con.prepareStatement("Insert into signup values(?,?,?,?,?)");
                ps1.setString(1, username);
                ps1.setString(2, name);
                ps1.setString(3, password);
                ps1.setLong(4, phone);
                ps1.setString(5, email);
                ps1.executeUpdate();
                out.print("Signed Up Successfully");
            }
        } catch(SQLException e){
            e.printStackTrace();
        }
    }
}
