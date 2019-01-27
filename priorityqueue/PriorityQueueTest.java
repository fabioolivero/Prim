package priorityqueue;

import node.*;
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;

import java.util.concurrent.ExecutionException;

public class PriorityQueueTest {

	private PriorityQueue p1;
    private PriorityQueue<String> s1;
    private PriorityQueue<Integer> i1;
    private PriorityQueue<Double> d1;


	@Before
	public void createPriorityQueue(){
		p1 = new PriorityQueue();
		s1 = new PriorityQueue<String>();
		i1 = new PriorityQueue<Integer>();
		d1 = new PriorityQueue<Double>();
	}

	@Test
	public void testHeapSizeZeroEl(){
		assertEquals(1, p1.size());
	}


	@Test
	public void testHeapSizeOneElString() throws Exception{
		s1.insert(0,"test_1");
		assertEquals(2,s1.size());
	}

	@Test
	public void testHeapSizeOneElInteger() throws Exception{
		i1.insert(0,45);
		assertEquals(2,i1.size());
	}

	@Test
	public void testHeapSizeOneElDouble() throws Exception{
		d1.insert(0,4.5);
		assertEquals(2,d1.size());
	}

	@Test
	public void testInsertOneElString() throws Exception{
		s1.insert(0,"test_1");
		assertEquals("test_1",s1.getElem(1).getElem());
	}

	@Test
	public void testInsertOneElDouble() throws Exception{
		d1.insert(0,4.5);
		assertEquals(4.5,d1.getElem(1).getElem());
	}

	@Test
	public void testInsertOneElInteger() throws Exception{
		i1.insert(0,2);
		assertEquals(2,i1.getElem(1).getElem());
	}

	@Test
	public void testInsertThreeElString() throws Exception{
		s1.insert(0,"test_1");
		s1.insert(4, "test_2");
		s1.insert(3, "test_3");
		String[] arrTemp = {"test_1", "test_2","test_3"};
		for(int i = 1; i < 4; i++)
			assertEquals(arrTemp[i-1], s1.getElem(i).getElem());
	}

	@Test
	public void testInsertThreeElInteger() throws Exception{
		i1.insert(0,546);
		i1.insert(4, 32);
		i1.insert(3, 4);
		Integer[] arrTemp = {546, 32, 4};
		for(int i = 1; i < 4; i++)
			assertEquals(arrTemp[i-1], i1.getElem(i).getElem());
	}

	@Test
	public void testInsertThreeElDouble() throws Exception{
		d1.insert(0,3.5);
		d1.insert(4, 45.6);
		d1.insert(3, 23.6);
		Double[] arrTemp = {3.5, 45.6, 23.6};
		for(int i = 1; i < 4; i++)
			assertEquals(arrTemp[i-1], d1.getElem(i).getElem());
	}

	@Test
	public void testGetMaxString() throws Exception{
		s1.insert(0,"test_1");
		s1.insert(4, "test_2");
		s1.insert(3, "test_3");
		assertEquals("test_1",s1.getMax().getElem());
	}

	@Test
	public void testGetMaxInteger() throws Exception{
		i1.insert(0,546);
		i1.insert(4, 32);
		i1.insert(3, 4);
		assertEquals(546, i1.getMax().getElem());
	}

	@Test
	public void testGetMaxDouble() throws Exception{
		d1.insert(0,3.5);
		d1.insert(4, 45.6);
		d1.insert(3, 23.6);
		assertEquals(3.5, d1.getMax().getElem());
	}

	@Test
	public void testGetElemDouble() throws Exception{
		d1.insert(0,3.5);
		d1.insert(4, 45.6);
		d1.insert(3, 23.6);
		assertEquals(23.6, d1.getElem(3).getElem());
	}

	@Test
	public void testGetElemString() throws Exception{
		s1.insert(0,"test_1");
		s1.insert(4, "test_2");
		s1.insert(3, "test_3");
		assertEquals("test_3",s1.getElem(3).getElem());
	}

	@Test
	public void testGetElemInteger() throws Exception{
		i1.insert(0,546);
		i1.insert(4, 32);
		i1.insert(3, 4);
		assertEquals(4, i1.getElem(3).getElem());
	}


	@Test
	public void testExtractMaxDouble() throws Exception{
		d1.insert(0,3.5);
		d1.insert(1, 4.7);
		d1.insert(4, 45.6);
		assertEquals(3.5, (Object)d1.extractMax());
		assertEquals(4.7, d1.getMax().getElem());
	}

	@Test
	public void testExtractMaxString() throws Exception{
		s1.insert(0,"test_1");
		s1.insert(4, "test_2");
		s1.insert(3, "test_3");
		assertEquals("test_1", s1.extractMax());
		assertEquals("test_3",s1.getMax().getElem());
	}

	@Test
	public void testExtractMaxInteger() throws Exception{
		i1.insert(0,546);
		i1.insert(4, 32);
		i1.insert(3, 4);
		assertEquals(546, (int)i1.extractMax());
		assertEquals(4, i1.getMax().getElem());
	}

	@Test
	public void testMultiExtractMaxInteger() throws Exception{
		i1.insert(0,546);
		i1.insert(4, 32);
		i1.insert(3, 4);
		i1.extractMax();
		i1.extractMax();
		assertEquals(32, (int)i1.extractMax());
	}

	@Test
	public void testGetIndexOfInteger() throws Exception {
		i1.insert(2, 546);
		i1.insert(4, 32);
		i1.insert(3, 4);
		assertEquals(1, i1.getIndexOf(546));
	}

	@Test
	public void testGetIndexOfDouble() throws Exception {
		d1.insert(0, 54.6);
		d1.insert(2, 3.11);
		d1.insert(4, 4.0);
		assertEquals(2, d1.getIndexOf(3.11));
	}

	@Test
	public void testGetIndexOfString() throws Exception {
		s1.insert(0, "test_1");
		s1.insert(4, "test_2");
		s1.insert(3, "test_3");
		assertEquals(3, s1.getIndexOf("test_3"));
	}

	@Test
	public void testContainsInteger() throws Exception {
		i1.insert(2, 546);
		i1.insert(4, 32);
		i1.insert(3, 4);
		assertTrue(i1.contains(4));
	}

	@Test
	public void testContainsDouble() throws Exception {
		d1.insert(0, 54.6);
		d1.insert(2, 3.11);
		d1.insert(4, 4.0);
		assertTrue(d1.contains(3.11));
	}

	@Test
	public void testContainsOfString() throws Exception {
		s1.insert(0, "test_1");
		s1.insert(4, "test_2");
		s1.insert(3, "test_3");
		assertTrue(s1.contains("test_1"));
	}

	@Test
	public void testDecreaseKeyInteger() throws Exception{
		i1.insert(0, 546);
		i1.insert(4, 32);
		i1.insert(3, 4);
		i1.decreaseKey(546, 10);
		assertEquals(4, i1.getMax().getElem());
	}

	@Test
	public void testDecreaseKeyDouble() throws Exception{
		d1.insert(0, 32.56);
		d1.insert(4, 342.3);
		d1.insert(3, 34.12);
		d1.decreaseKey(32.56, 10);
		assertEquals(34.12, d1.getMax().getElem());
	}

	@Test
	public void testDecreaseKeyString() throws Exception{
		s1.insert(0, "test_1");
		s1.insert(4, "test_2");
		s1.insert(3, "test_3");
		s1.decreaseKey("test_1", 10);
		assertEquals("test_3", s1.getMax().getElem());
	}

	@Test
	public void testDeleteElemInteger() throws Exception{
		i1.insert(0, 546);
		i1.insert(4, 32);
		i1.insert(3, 4);
		i1.deleteElem(546);
		assertEquals(4, i1.getMax().getElem());
	}

	@Test
	public void testDeleteElemDouble() throws Exception{
		d1.insert(0, 132.5);
		d1.insert(4, 9.86);
		d1.insert(3, 3.4);
		d1.deleteElem(132.5);
		assertEquals(3.4, d1.getMax().getElem());
	}

	@Test
	public void testDeleteElemString() throws Exception{
		s1.insert(0, "test_1");
		s1.insert(4, "test_2");
		s1.insert(3, "test_3");
		s1.deleteElem("test_1");
		assertEquals("test_3", s1.getMax().getElem());
	}

	public static void main(String [] args) throws PriorityQueueException {
		Result result = JUnitCore.runClasses(PriorityQueueTest.class);
		for (Failure failure : result.getFailures()){
			System.out.println(failure.toString());
		}

		System.out.println(result.wasSuccessful());

	}//main

}//class