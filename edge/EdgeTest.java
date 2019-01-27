package edge;

import vertex.*;
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;


public class EdgeTest {

    private Vertex a1;
    private Vertex b1;
    private Edge i1;
    private Edge d1;

    @Before
    public void createVertex(){
        a1 = new Vertex("a1");
        b1 = new Vertex("e4");
    }

    @Before
    public void createEdge(){
        i1 = new Edge(a1,b1,14);
        d1 = new Edge(b1,a1,4.6);
    }

    @Test
    public void testGetDistanceInteger(){
        assertEquals((Object) i1.getDistance(), 14.0);
    }

    @Test
    public void testGetDistanceDouble(){
        assertEquals((Object) d1.getDistance(), 4.6);
    }

    @Test
    public void testGetSources(){
        assertEquals(a1,i1.getSource());
    }

    @Test
    public void testGetDestination(){
        assertEquals(b1,i1.getDestination());
    }

    @Test
    public void testToString(){
        assertEquals(d1.toString(), "e4 --> a1");
    }

    public static void main(String [] args){
        Result result = JUnitCore.runClasses(EdgeTest.class);
        for (Failure failure : result.getFailures()){
            System.out.println(failure.toString());
        }

        System.out.println(result.wasSuccessful());

    }//main
}
