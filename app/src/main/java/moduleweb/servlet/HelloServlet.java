package moduleweb.servlet;

import com.google.inject.Guice;
import com.google.inject.Injector;
import moduleweb.ServerModule;
import moduleweb.testservice.Calc;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class HelloServlet extends HttpServlet
{
    private Calc calc;

    public HelloServlet()
    {
        Injector injector = Guice.createInjector(new ServerModule());
        this.calc = injector.getInstance(Calc.class);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        response.setContentType("text/html");
        response.setStatus(HttpServletResponse.SC_OK);
        response.getWriter().print(getContent(request.getParameter("a"), request.getParameter("b")));
    }

    String getContent(String sA, String sB){
        StringBuilder sb = new StringBuilder("<h1>Hello</h1><br>");
        if(isInteger(sA) && isInteger(sB)){
            int a = Integer.parseInt(sA);
            int b = Integer.parseInt(sB);
            sb.append("<h3>sum = ").append(calc.sum(a, b)).append("</h3>");
            sb.append("<h3>times = ").append(calc.times(a, b)).append("</h3>");
        }
        return sb.toString();
    }

    boolean isInteger(String s) {
        int radix = 9;
        return s != null &&
               s.matches("^-?\\d+$") &&
               (s.length() <= radix || (s.charAt(0)=='-' && s.length()-1 <= radix) );
    }
}