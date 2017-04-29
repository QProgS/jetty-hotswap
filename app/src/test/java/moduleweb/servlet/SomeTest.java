package moduleweb.servlet;

import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class SomeTest
{
    private HelloServlet helloServlet = new HelloServlet();

    @Test
    public void testInt(){
        assertTrue(helloServlet.isInteger("4"));
    }

    @Test
    public void testBigInt(){
        assertFalse(helloServlet.isInteger("1234567890"));
    }

    @Test
    public void testNoInt(){
        assertFalse(helloServlet.isInteger("dfsd"));
    }
}
