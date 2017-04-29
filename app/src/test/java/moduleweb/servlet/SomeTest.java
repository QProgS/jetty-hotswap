package moduleweb.servlet;

import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class SomeTest
{
    private HelloServlet helloServlet = new HelloServlet("Hello");

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

    @Test
    public void testContent(){
        String content = helloServlet.getContent("1", "2");
        assertTrue(content.contains("<h1>Hello</h1>"));
        assertTrue(content.contains("sum = "));
        assertTrue(content.contains("times = "));
    }
}
