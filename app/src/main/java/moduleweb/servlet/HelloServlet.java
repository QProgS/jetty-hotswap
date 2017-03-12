package moduleweb.servlet;

import moduleweb.testservice.Calc;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class HelloServlet extends HttpServlet
{
    private Calc calc = new Calc();

    private String greeting="Hello World";
    public HelloServlet(){}
    public HelloServlet(String greeting)
    {
        this.greeting=greeting;
    }
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        response.setContentType("text/html");
        response.setStatus(HttpServletResponse.SC_OK);

        response.getWriter().println("<h1>"+greeting+"</h1><br>");

        if(isInteger(request.getParameter("a")) && isInteger(request.getParameter("b"))){
            int a = Integer.parseInt(request.getParameter("a"));
            int b = Integer.parseInt(request.getParameter("b"));
            response.getWriter().println("<h3>sum = "+calc.sum(a, b)+"</h3>");
            response.getWriter().println("<h3>times = "+calc.times(a, b)+"</h3>");
        }

        response.getWriter().println("session=" + request.getSession(true).getId());
    }

    private static boolean isInteger(String s) {
        int radix = 9;
        return s != null &&
               s.matches("^-?\\d+$") &&
               (s.length() <= radix || (s.charAt(0)=='-' && s.length()-1 <= radix) );
    }
}