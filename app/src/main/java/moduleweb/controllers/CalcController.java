package moduleweb.controllers;

import moduleweb.testservice.Calc;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class CalcController implements Controller
{
    private Calc calc;

    @Inject
    public CalcController(Calc calc)
    {
        this.calc = calc;
    }


    @Override
    public void generate(HttpServletRequest request, HttpServletResponse response) throws IOException
    {
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
