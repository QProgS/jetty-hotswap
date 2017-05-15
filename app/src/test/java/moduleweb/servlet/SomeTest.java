package moduleweb.servlet;

import com.google.inject.Guice;
import com.google.inject.Injector;
import moduleweb.ServerModule;
import org.junit.BeforeClass;
import org.junit.Test;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.mockito.Matchers.eq;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

public class SomeTest
{
    private static HelloServlet helloServlet;

    @BeforeClass
    public static void init(){
        Injector injector = Guice.createInjector(new ServerModule());
        helloServlet = injector.getInstance(HelloServlet.class);
    }

    @Test
    public void testDoGet() throws ServletException, IOException
    {
        HttpServletRequest request = mock(HttpServletRequest.class);

        when(request.getParameter("a")).thenReturn("1");
        when(request.getParameter("b")).thenReturn("2");

        HttpServletResponse response = mock(HttpServletResponse.class);
        PrintWriter writer = mock(PrintWriter.class);
        when(response.getWriter()).thenReturn(writer);
        helloServlet.doGet(request, response);

        verify(response).setContentType(eq("text/html"));
        verify(writer).print(eq("<h1>Hello</h1><br><h3>sum = 3</h3><h3>times = 2</h3>"));
    }

}
