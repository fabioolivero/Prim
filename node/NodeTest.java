package node;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;

import java.util.Objects;


public class NodeTest {

    private Node p1;
    private Node<String> s1;
    private Node<String> s2;
    private Node<Integer> i1;
    private Node<Integer> i2;
    private Node<Double> d1;
    private Node<Double> d2;


    @Before
    public void createPriorityQueue() {
        p1 = new Node();
        s1 = new Node<String>(3,"test_1");
        s2 = new Node<String>(2,"test_2");
        i1 = new Node<Integer>(5,678);
        i2 = new Node<Integer>(6,6328);
        d1 = new Node<Double>(1,56.7);
        d2 = new Node<Double>(2,464.2);
    }

    @Test
    public void testGetPrInteger(){
        assertEquals(5.0, (Object)i1.getPr());
    }

    @Test
    public void testGetPrDouble(){
        assertEquals(1.0, (Object)d1.getPr());
    }

    @Test
    public void testGetPrString(){
        assertEquals(3.0, (Object)s1.getPr());
    }

    @Test
    public void testGetElemInteger(){
        assertEquals(678, (int) i1.getElem());
    }

    @Test
    public void testGetElemDouble(){
        assertEquals(56.7, (Object) d1.getElem());
    }

    @Test
    public void testGetElemString(){
        assertEquals("test_1", s1.getElem());
    }

    @Test
    public void testCompareToString(){
        assertTrue(s1.compareTo(s2));
    }

    @Test
    public void testCompareToInteger(){
        assertTrue(i2.compareTo(i1));
    }

    @Test
    public void testCompareToDouble() {
        assertTrue(d2.compareTo(d1));
    }

    @Test
    public void testSetPrInteger() {
        i1.setPr(45.0);
        assertEquals(45.0, (Object)i1.getPr());
    }

    @Test
    public void testSetPrDouble() {
        d1.setPr(4.0);
        assertEquals(4.0, (Object)d1.getPr());
    }

    @Test
    public void testSetPrString() {
        s1.setPr(6.0);
        assertEquals(6.0, (Object)s1.getPr());
    }

    @Test
    public void testSetElInteger() {
        i1.setElem(45);
        assertEquals(45, (int)i1.getElem());
    }

    @Test
    public void testSetElDouble() {
        d1.setElem(4.5);
        assertEquals(4.5, (Object)d1.getElem());
    }

    @Test
    public void testSetElString() {
        s1.setElem("prova_1");
        assertEquals("prova_1", s1.getElem());
    }

    public static void main(String [] args){
        Result result = JUnitCore.runClasses(NodeTest.class);
        for (Failure failure : result.getFailures()){
            System.out.println(failure.toString());
        }

        System.out.println(result.wasSuccessful());

    }//main

}//class