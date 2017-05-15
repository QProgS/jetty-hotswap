package moduleweb.servlet;

import com.google.inject.Guice;
import com.google.inject.Injector;
import moduleweb.ServerModule;
import moduleweb.controllers.CalcController;
import moduleweb.testservice.Calc;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class HelloServlet extends HttpServlet
{
    private CalcController calcController;

    public HelloServlet()
    {
        Injector injector = Guice.createInjector(new ServerModule());
        this.calcController = injector.getInstance(CalcController.class);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        response.setContentType("text/html");
        response.setStatus(HttpServletResponse.SC_OK);
        calcController.generate(request, response);
    }

}