package Question_9;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by prajapas on 7/18/2017.
 */
@WebFilter(filterName = "Q9Filter")
public class Q9Filter implements Filter {
    public void destroy() {
    }

    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {
        String place = req.getParameter("place");
        System.out.println("In Filter");
        if(place.equals("Dublin") || place.equals("Boston")) {

            chain.doFilter(req, resp);
        }
        else{
            //chain.doFilter(req, resp);
        }

    }

    public void init(FilterConfig config) throws ServletException {

    }

}
