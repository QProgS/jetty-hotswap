package moduleweb.servlet;

import com.google.inject.Inject;
import moduleweb.controllers.CalcController;

import javax.inject.Singleton;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


@Singleton
public class HelloServlet extends HttpServlet
{
    @Inject
    private CalcController calcController;

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        response.setContentType("text/html");
        response.setStatus(HttpServletResponse.SC_OK);
        calcController.generate(request, response);
    }

}