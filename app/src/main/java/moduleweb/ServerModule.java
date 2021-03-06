package moduleweb;

import com.google.inject.AbstractModule;
import moduleweb.controllers.CalcController;
import moduleweb.servlet.HelloServlet;
import moduleweb.testservice.Calc;

public class ServerModule extends AbstractModule
{
    @Override
    protected void configure()
    {
        bind(Calc.class);
        bind(HelloServlet.class);
        bind(CalcController.class);
    }
}
