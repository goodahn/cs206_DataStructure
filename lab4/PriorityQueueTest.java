
import junit.framework.TestCase;

public class PriorityQueueTest extends TestCase {

	PriorityQueue PQ; 
	protected void setUp() throws Exception {
		super.setUp();

		PQ = new PriorityQueue();
		PQ.add(5, "e5");
//		System.out.println(PQ.root.getPriority());
//		System.out.println(PQ.size());
		PQ.add(2, "e2");
//		System.out.println(PQ.root.getPriority());
//		System.out.println(PQ.size());
		PQ.add(8, "e8");
//		System.out.println(PQ.root.getPriority());
//		System.out.println(PQ.size());
		PQ.add(1, "e1");
//		System.out.println(PQ.root.getPriority());
//		System.out.println(PQ.root.getLeftChild().getPriority());
//		System.out.println(PQ.root.getRightChild().getPriority());
//		System.out.println(PQ.root.getLeftChild().getLeftChild().getPriority());
//		System.out.println(PQ.size());
		PQ.add(10, "e10");
//		System.out.println(PQ.root.getPriority());
//		System.out.println(PQ.size());
		PQ.add(7, "e7");
//		System.out.println(PQ.root.getPriority());
//		System.out.println(PQ.size());
		PQ.add(100, "e100" );
//		System.out.println(PQ.root.getPriority());
//		System.out.println(PQ.size());
		PQ.add(55, "e55" );
//		System.out.println(PQ.root.getPriority());
//		System.out.println(PQ.size());
		PQ.add(4, "e4" );
//		System.out.println(PQ.root.getPriority());
//		System.out.println(PQ.size());
		PQ.add(12, "e12" );
//		System.out.println(PQ.root.getPriority());
//		System.out.println(PQ.size());
		PQ.add(3, "e3" );
//		System.out.println(PQ.root.getPriority());
//		System.out.println(PQ.size());
		
		
	}
	public void testAdd()
	{
		if(PQ.root.getPriority()!= 100 || !PQ.root.getValue().equals("e100"))
			fail("fail");
		
	}
	public void testSize()
	{
		if(PQ.size()!= 11)
			fail("fail");
	}
	public void testGetHighestPriorityValue()
	{
		if(!PQ.getHighestPriorityValue().equals("e100"))
			fail("fail");
	}
	 
	public void testRemove()
	{
		if(PQ.remove()!= "e100")
			fail("fail");
		if(PQ.remove()!="e55")
			fail("fail");
	}
	public void testIsEmpty()
	{
		if(PriorityQueue.isEmpty(PQ.root))
			fail("fail");
	}
	public void testMerge()
	{
		PriorityQueue PQ1 = new PriorityQueue();
		PriorityQueue PQ2 = new PriorityQueue();
		
		PQ1.add(1, "a1");
		PQ1.add(3, "a3");
		PQ1.add(7, "a7");
		PQ1.add(11, "a11");
		PQ1.add(5, "a5");
		
		PQ2.add(4, "b4");
		PQ2.add(2, "b2");
		PQ2.add(6, "b6");
		PQ2.add(10, "b10");
		PQ2.add(8, "b8");
		
		BT temp =PriorityQueue.merge(PQ1.root,PQ2.root); 
		
		if(temp.getPriority()!= 11 || !temp.getValue().equals("a11"))
			fail("fail");
		
	}
	
	
	
}
