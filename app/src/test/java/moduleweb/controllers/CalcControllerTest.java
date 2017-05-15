package moduleweb.controllers;

import com.google.inject.Guice;
import com.google.inject.Injector;
import moduleweb.ServerModule;
import org.junit.BeforeClass;
import org.junit.Test;

import static org.junit.Assert.*;

public class CalcControllerTest
{
    private static CalcController calcController;

    @BeforeClass
    public static void init(){
        Injector injector = Guice.createInjector(new ServerModule());
        calcController = injector.getInstance(CalcController.class);
    }

    @Test
    public void testInt(){
        assertTrue(calcController.isInteger("4"));
    }

    @Test
    public void testBigInt(){
        assertFalse(calcController.isInteger("1234567890"));
    }

    @Test
    public void testNoInt(){
        assertFalse(calcController.isInteger("dfsd"));
    }

    @Test
    public void testContent(){
        String content = calcController.getContent("1", "2");
        assertTrue(content.contains("<h1>Hello</h1>"));
        assertTrue(content.contains("sum = "));
        assertTrue(content.contains("times = "));
    }

    @Test
    public void testContentEmpty(){
        String content = calcController.getContent("1", "");
        assertTrue(content.contains("<h1>Hello</h1>"));
        assertTrue(!content.contains("sum = "));
        assertTrue(!content.contains("times = "));
    }
}