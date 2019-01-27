package graph;

import priorityqueue.*;
import edge.*; 
import vertex.*;
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;

import java.util.ArrayList;


public class GraphTest {

    private Graph g;
    private PriorityQueue Q;
    private Vertex v1;
    private ArrayList<Edge> A;

    @Before
    public void createGraph(){
        g = new Graph();
        A = new ArrayList<>();
    }

    @Test
    public void testAdd() throws PriorityQueueException{
        String[] tmp_1 = {"a1","a2","13.4"};
        String[] tmp_2 = {"a3","a4","134.45"};
        String[] tmp_3 = {"a5","a6","23.4"};
        g.add(tmp_1);
        g.add(tmp_2);
        g.add(tmp_3);
        Q  = g.createQueue();
        assertEquals("a1", ((Vertex)Q.extractMax()).getName());
        assertEquals("a3", ((Vertex)Q.extractMax()).getName());
        assertEquals("a6", ((Vertex)Q.extractMax()).getName());
    }

    @Test
    public void testSize(){
        String[] tmp_1 = {"a1","a2","13.4"};
        String[] tmp_2 = {"b1","b2","15.46"};
        String[] tmp_3 = {"c1","c2","1132.46"};
        String[] tmp_4 = {"c1","c3","1132.46"};
        g.add(tmp_1);
        g.add(tmp_2);
        g.add(tmp_3);
        g.add(tmp_4);
        assertEquals(7, g.size());
    }

    @Test
    public void testCreateQueue()throws PriorityQueueException{
        String[] tmp_1 = {"a1","a2","13.4"};
        g.add(tmp_1);
        Q  = g.createQueue();
        assertEquals(2,Q.size()-1);
        assertEquals(((Vertex) Q.extractMax()).getName(),"a1");
    }

    @Test
    public void testGetVertexKeyInQueue() throws PriorityQueueException{
        String[] tmp_1 = {"a3","d1","9.4"};
        String[] tmp_2 = {"d1","d2","4.5"};
        String[] tmp_3 = {"a4","d4","34.45"};
        v1 = new Vertex("a3");
        g.add(tmp_1);
        g.add(tmp_2);
        g.add(tmp_3);
        g.prim();
        Q  = g.createQueue();
        assertEquals(9.4, (Object) g.getVertexKeyInQueue(v1,Q));
    }

    @Test
    public void testPrim() throws PriorityQueueException{
        String[] tmp_1 = {"a1","a2","13.4"};
        String[] tmp_2 = {"a3","a4","134.45"};
        String[] tmp_3 = {"a5","a6","23.4"};
        g.add(tmp_1);
        g.add(tmp_2);
        g.add(tmp_3);
        Q  = g.createQueue();
        A = g.prim();
        double dist = 0;
        for(int i=0; i<A.size(); i++)
            dist +=A.get(i).getDistance();
        assertEquals(g.size(), 6);
        assertEquals(A.size(), 3);
        assertEquals((Object) dist,171.25);

    }

    public static void main(String [] args){
        Result result = JUnitCore.runClasses(GraphTest.class);
        for (Failure failure : result.getFailures()){
            System.out.println(failure.toString());
        }

        System.out.println(result.wasSuccessful());

    }//main

}
