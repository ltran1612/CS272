
public class QueueTest {

	public static void main(String[] args) {
		
		System.out.println("Test LinkedQueue");
		testToStringLinkedQueue();
		testEnqueueLinkedQueue();
		testDequeueLinkedQueue();
		testFrontLinkedQueue();
		testSizeLinkedQueue();
		testIsEmptyLinkedQueue();
		
		System.out.println("\n\nTest ArrayQueue");
		testToStringArrayQueue();
		testEnqueueArrayQueue();
		testDequeueArrayQueue();
		testFrontArrayQueue();
		testSizeArrayQueue();
		testIsEmptyArrayQueue();
	}
	
	
	
	public static void testToStringLinkedQueue() {
		LinkedQueue<Integer> nCase = new LinkedQueue<Integer>();
		LinkedQueue<Integer> nCase1 = new LinkedQueue<Integer>();
		LinkedQueue<Integer> empty = new LinkedQueue<Integer>();
		
		for (int i = 1; i < 4; ++i) nCase.enqueue(i);
		System.out.println("Testing toString, enqueued from 1 - 3: "+nCase);
		
		nCase1.enqueue(1);
		System.out.println("Test toString, enqueued one: "+nCase1);
		System.out.println("Test toString, empty queue: "+empty);
	}
	
	public static void testEnqueueLinkedQueue() {
		System.out.println();
		LinkedQueue<Integer> nCase = new LinkedQueue<Integer>();
		LinkedQueue<Integer> nCase1 = new LinkedQueue<Integer>();
		LinkedQueue<Integer> nCase2 = new LinkedQueue<Integer>();
		LinkedQueue<Integer> nCase3 = new LinkedQueue<Integer>();
			
		for (int i = 1; i < 5; ++i) nCase.enqueue(i);
		
		nCase1.enqueue(1); nCase1.enqueue(8); nCase1.enqueue(10);
		nCase1.dequeue();
		
		nCase2.enqueue(1); nCase2.enqueue(3); nCase2.enqueue(8);
		nCase2.dequeue(); nCase2.dequeue(); nCase2.enqueue(99);
		
		System.out.println("Test enqueue, enqueued from 1 - 4: "+nCase);
		System.out.println("Test enqueue, enqueued 1, 8, 10, dequeued once: "+nCase1);
		System.out.println("Test enqueue, enqueued 1, 3, 8, dequeued twice, enqueued 99: "+nCase2);
	   
	}
	
	public static void testDequeueLinkedQueue() {
		System.out.println();
		LinkedQueue<Integer> nCase = new LinkedQueue<Integer>();
		LinkedQueue<Integer> empty = new LinkedQueue<Integer>();
	    LinkedQueue<Integer> nCase1 = new LinkedQueue<Integer>();
	    
		nCase.enqueue(1); nCase.enqueue(9); nCase.enqueue(12);
		
		for (int i = 0; i < 9; ++i) nCase1.enqueue(i);
		try {
			empty.dequeue();
		} catch(RuntimeException e) {
			System.out.println("Test dequeue, dequeue an empty queue, expecting exception: "+e.getMessage());

		}
		System.out.println("Test dequeue , dequeue a queue enqueued 1, 9, 12: "+ nCase+", expecting 1: "+nCase.dequeue()+
				". After that expecting the queue to be 9, 12: "+nCase);		
	
		System.out.println("Test dequeue, queue enqueued 0-8: "+nCase1+
				". Then dequeue: ");
		for (int i = 0; i < 9; ++i) System.out.println("Dequeue: "+nCase1.dequeue());
		System.out.println("After that, the queue: "+nCase1);
	}
	
	public static void testFrontLinkedQueue() {
		System.out.println();
		LinkedQueue<Integer> nCase = new LinkedQueue<Integer>();
		LinkedQueue<Integer> empty = new LinkedQueue<Integer>();
		
		nCase.enqueue(11); nCase.enqueue(111); nCase.enqueue(1111);
		try {
			empty.front();
		} catch(RuntimeException e) {
			System.out.println("Test front, front an empty queue, expecting exception: "+e.getMessage());
		}
		System.out.println("Test front, front an queue enqueud 11, 111, 1111: "+nCase+", expecting 11: "+nCase.front()+
				". After that expecting the queue to be 11, 111, 1111: "+nCase);
	}
	
	public static void testSizeLinkedQueue() {
		System.out.println();
		LinkedQueue<Integer> nCase = new LinkedQueue<Integer>();
		LinkedQueue<Integer> empty = new LinkedQueue<Integer>();
		
		nCase.enqueue(1); nCase.enqueue(8); nCase.enqueue(9);
		
		System.out.println("Test size, size an empty queue, expecting 0: "+empty.size());
		System.out.println("Test size, size an queue enqueued 1, 8, 9: "+nCase+", expecting 3: "+nCase.size());
	}
	
	public static void testIsEmptyLinkedQueue() {
		System.out.println();
		LinkedQueue<Integer> nCase = new LinkedQueue<Integer>();
		LinkedQueue<Integer> empty = new LinkedQueue<Integer>();
		
		nCase.enqueue(8); nCase.enqueue(9); nCase.enqueue(9);
		
		System.out.println("Test isEmpty, isEmpty an empty queue, expecting true: "+empty.isEmpty());
		System.out.println("Test, isEmpty, isEmpty and queue enqueued 8, 9, 9, expecting false: "+nCase.isEmpty());	
	}
	
	
	
	
	public static void testToStringArrayQueue() {
		ArrayQueue<Integer> nCase = new ArrayQueue<Integer>();
		ArrayQueue<Integer> nCase1 = new ArrayQueue<Integer>();
		ArrayQueue<Integer> empty = new ArrayQueue<Integer>();
		
		for (int i = 1; i <=3; ++i) nCase.enqueue(i);
		System.out.println("Test toString ArrayQueue, enqueued 1 - 3: "+nCase);
		
		nCase1.enqueue(1);
		System.out.println("Test toString, enqueued 1: "+nCase1);
		System.out.println("Test toString, empty queue: "+empty);
	
		
	}
	
	public static void testEnqueueArrayQueue() {
		System.out.println();
		System.out.println("Test enqueue, default data length is 3.");
		ArrayQueue<Integer> nCase = new ArrayQueue<Integer>(); 
		ArrayQueue<Integer> sCase1 = new ArrayQueue<Integer>(); // full array
		ArrayQueue<Integer> sCase2 = new ArrayQueue<Integer>(); // front > 0
		ArrayQueue<Integer> sCase3 = new ArrayQueue<Integer>();
		
		nCase.enqueue(2);
		nCase.enqueue(1);
		
		sCase1.enqueue(3); sCase1.enqueue(2); sCase1.enqueue(1);sCase1.enqueue(4); sCase1.enqueue(5);
		
		for (int i = 1; i <= 3; ++i) sCase2.enqueue(i); 
		sCase2.dequeue(); sCase2.enqueue(5); 
		
		sCase3.enqueue(1); sCase3.enqueue(8); sCase3.enqueue(99); 
	    sCase3.dequeue(); sCase3.enqueue(9); sCase3.enqueue(100); 
		System.out.println("Test enqueue, ArrayQueue, normal case where there are still spaces to enqueue, enqueued 2 and 1: "+nCase); 
		System.out.println("Test enqueue, ArrayQueue, special case when the queue enqueued 3, 2, 1, 4, 5: "+sCase1);
		System.out.println("Test enqueue, ArrayQueue, special case when the queue enqueued 1, 2, 3, dequeued once, enqueued 5: "+sCase2);
		System.out.println("Test enqueue, ArrayQueue, special case when the queue enqueued 1, 8, 99, dequeued once, enqueued 9, 100: "+sCase3);

	}
	
	public static void testDequeueArrayQueue() {
		System.out.println();
		ArrayQueue<Integer> nCase = new ArrayQueue<Integer>(); 
		ArrayQueue<Integer> empty = new ArrayQueue<Integer>(); 
		ArrayQueue<Integer> nCase1 = new ArrayQueue<Integer>();
		ArrayQueue<Integer> nCase2 = new ArrayQueue<Integer>();
		ArrayQueue<Integer> sCase = new ArrayQueue<Integer>();
		try {
			empty.dequeue();
		} catch(RuntimeException e) {
			System.out.println("Test dequeue, ArrayQueue, special case when the queue is empty, expecting exception: "+e.getMessage());
		}
		for (int i = 1; i <= 3; ++i) nCase.enqueue(i);
		System.out.println("Test dequeue, ArrayQueue, normal case when the front is at 0, and the size < the length of data: "+
		nCase+". After that, dequeue once: "+nCase.dequeue()+". And the queue is: "+nCase);
		
		for (int i = 1; i <= 4; ++i) nCase1.enqueue(i);
		System.out.println("Test dequeue, ArrayQueue, normal case when the queue added 1, 2, 3, 4: "+
		nCase1+". After that, dequeue once: "+nCase1.dequeue()+". And the queue is: "+nCase1);
		
		for (int i = 1; i <= 5; ++i) nCase2.enqueue(i); 
		System.out.println("Test dequeue, ArrayQueue, normal case when the queue added 1, 2, 3, 4, 5: "+ nCase2+". After that, dequeue: ");
		
		for (int i = 0; i < 5; ++i) System.out.println("Dequeue: "+nCase2.dequeue());
		System.out.println("Then, the queue is, expecting empty: "+nCase2);
		
		for (int i = 0; i < 3; ++i) sCase.enqueue(i); 
		System.out.print("Test dequeue, ArrayQueue, normal case when the queue enqueued 0-2: "+sCase+", then dequeue once: "+sCase.dequeue()+
				". Then enqueue 9, 10, expecting 1, 2, 9, 10: ");
		sCase.enqueue(9); sCase.enqueue(10);
		System.out.println(sCase);
		System.out.println("Then dequeue twice: "+ sCase.dequeue()+" "+ sCase.dequeue());
		System.out.println("Then the queue is, expecting 9, 10: "+sCase);
		
		
	}
	
	public static void testFrontArrayQueue() {
		System.out.println();
		ArrayQueue<Integer> nCase = new ArrayQueue<Integer>(); 
		ArrayQueue<Integer> empty = new ArrayQueue<Integer>(); 
		
		nCase.enqueue(1); nCase.enqueue(9); nCase.enqueue(2);
		try {
			empty.front();
		} catch(RuntimeException e) {
			System.out.println("Test front, ArrayQueue, empty queue, expecting exception: "+e.getMessage());
		}
		System.out.println("Test front, normal case, queue enqueued 1, 9, 2, the queue is: "+nCase);
		System.out.println("Then front once: "+nCase.front()+". And the queue is: "+nCase);
	}
	
	public static void testSizeArrayQueue() {
		System.out.println();
		ArrayQueue<Integer> nCase = new ArrayQueue<Integer>(); 
		ArrayQueue<Integer> nCase1 = new ArrayQueue<Integer>(); 
		ArrayQueue<Integer> nCase2 = new ArrayQueue<Integer>(); 
		ArrayQueue<Integer> empty = new ArrayQueue<Integer>();  
		
		nCase.enqueue(1); nCase.enqueue(3); nCase.enqueue(9);
		
		for (int i = 0; i < 9; ++i) nCase1.enqueue(i);
		
		for (int i = 0; i < 3; ++i) nCase2.enqueue(i); nCase2.dequeue(); nCase2.enqueue(1); nCase2.enqueue(9);
		
		System.out.println("Test size, ArrayQueue, empty case, expecting 0: "+empty.size());
		System.out.println("Test size, ArrayQueue, queue enqueued 1, 3, 9, expecting 3: "+nCase.size());
		System.out.println("Test size, ArrayQueue, queue enqueued 0-8, expecting 9: "+nCase1.size());
		System.out.println("Test size, ArrayQueue, queue enqueued 0-2, dequeued once, enqueued 1, 9, expecting 4: "+nCase2.size());
	}
	
	public static void testIsEmptyArrayQueue() {
		 System.out.println();
		 ArrayQueue<Integer> nCase = new ArrayQueue<Integer>(); 
		 ArrayQueue<Integer> empty = new ArrayQueue<Integer>(); 
		 
		 nCase.enqueue(9); nCase.enqueue(11);
		 
		 System.out.println("Test isEmpty, empty case, expecting true: "+empty.isEmpty());
		 System.out.println("Test isEmpty, queue enqueued 9, 11, expecting false: "+nCase.isEmpty());
	}  
   	

}
