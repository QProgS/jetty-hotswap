package moduleweb.servlet;

import com.google.inject.Guice;
import com.google.inject.Injector;
import com.google.inject.servlet.GuiceServletContextListener;
import com.google.inject.servlet.ServletModule;
import moduleweb.ServerModule;

public class ServletConfig extends GuiceServletContextListener
{

    @Override
    protected Injector getInjector() {
        return Guice.createInjector(new ServerModule(), new ServletModule() {

            @Override
            protected void configureServlets() {
                serve("/*").with(HelloServlet.class);
            }
        });
    }
}
