package moduleweb.controllers;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public interface Controller
{
    void generate(HttpServletRequest request, HttpServletResponse response) throws IOException;
}
