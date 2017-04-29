package moduleweb.testservice;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class CalcTest
{
    @Test
    public void testSum(){
        assertEquals(4, new Calc().sum(2,2));
    }

    @Test
    public void testTimes(){
        assertEquals(4, new Calc().times(2,2));
    }

}
