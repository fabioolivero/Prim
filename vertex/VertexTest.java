package vertex;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;

public class VertexTest {

    private Vertex i1;
    private Vertex i2;
    private Vertex d1;

    @Before
    public void createVertex(){
        i1 = new Vertex("a1");
        i2 = new Vertex("a1");
        d1 = new Vertex("b2");
    }

    @Test
    public void testSetKey(){
        i1.setKey(32.2);
        assertEquals(32.2, (Object)i1.getKey());

    }

    @Test
    public void testSetParent(){
        d1.setParent(i1);
        assertEquals(i1,d1.getParent());
    }

    @Test
    public void testGetName(){
        assertEquals("a1",i1.getName());
    }

    @Test
    public void testGetKey(){
        assertEquals(Double.MAX_VALUE, (Object)d1.getKey());
    }

    @Test
    public void testGetParent(){
        assertNull(i1.getParent());
    }

    @Test
    public void testEquals(){
        assertTrue(i1.equals(i2));
    }

    public static void main(String [] args){
        Result result = JUnitCore.runClasses(VertexTest.class);
        for (Failure failure : result.getFailures()){
            System.out.println(failure.toString());
        }

        System.out.println(result.wasSuccessful());

    }//main

}
