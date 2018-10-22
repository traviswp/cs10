// SortedArrayMinPriorityQueue.java
// Class demo by THC.
// Modified by Scot Drysdale to eliminate decreaseKey, to check 
//   for empty queue on minimum and extractMin, and to sort in
//   reverse order so extractMin is O(1).
// Class to implement a min-priority queue with a sorted array.
// Each array element supports the Comparable interface.

@SuppressWarnings("unchecked")

public class SortedArrayMinPriorityQueue implements MinPriorityQueue {
  private int size;       // number of elements currently in the priority queue
  private Comparable [] array; // array of queue items
  
  // Constructor, takes max number of elements that will be in the priority queue.
  public SortedArrayMinPriorityQueue(int n) {
    size = 0;
    array = new Comparable[n];
  }
  
  // Return true if the queue is empty, false if not empty.
  public boolean isEmpty() {
    return size <= 0;
  }
  
  // Insert an element into the queue.  Does nothing if queue
  // already full.
  public void insert(Comparable element) {
  	if (size < array.length) {
      // Place the element at the appropriate location in the array.
      size++;      // One more item in the queue
      int p;       // Current position in the array
      
      for (p = size-1; p > 0 && array[p-1].compareTo(element) < 0; p--)
      	array[p] = array[p-1];    // Shift to the right
    
      array[p] = element;
  	}
  }


  // Return the element with the minimum key, without removing it from the queue.
  // Returns null if queue empty.
  public Comparable minimum() {
  	if (size <= 0)
  		return null;
  	else
      return array[size-1];  // Last item is smallest
  }
  
  // Return the element with the minimum key, and remove it from the queue.
  // Returns null if queue empty.
  public Comparable extractMin() {
  	if (size <= 0)
  		return null;
  	else {
  		size--;                       // Shrink the size
      return array[size];           // and return the smallest element
  	}
  }
  
  // A testing program
  public static void main (String [] args)  {
  	MinPriorityQueue pq = new SortedArrayMinPriorityQueue(20);
  	pq.insert("cat");
  	pq.insert("dog");
  	pq.insert("bee");
  	System.out.println("Smallest is: " + pq.minimum());
  	System.out.println("Smallest again: " + pq.extractMin());
  	System.out.println("Next smallest is: " + pq.extractMin());
  	System.out.println("Is it empty? : " + pq.isEmpty());
  	pq.insert("eagle");
  	System.out.println("Next smallest is: " + pq.extractMin());
  	System.out.println("Next smallest is: " + pq.extractMin());
  	System.out.println("Is it empty? : " + pq.isEmpty());
  	System.out.println("Min of empty queue: " + pq.minimum());
  	System.out.println("Remove min of empty queue: " + pq.extractMin());
  	pq.insert("bear");
  	System.out.println("Smallest is: " + pq.minimum());
  	System.out.println("Smallest again: " + pq.extractMin());
  	pq.insert("cat");
  	pq.insert("dog");
  	pq.insert("sheep");
  	pq.insert("cow");
  	pq.insert("eagle");
  	pq.insert("bee");
  	pq.insert("lion");
  	pq.insert("tiger");
  	pq.insert("zebra");
  	pq.insert("ant");
  	System.out.println("Bigger example:");
  	System.out.println("Smallest is: " + pq.extractMin());
  	System.out.println("Next smallest is: " + pq.extractMin());
  	System.out.println("Next smallest is: " + pq.extractMin());
  	System.out.println("Next smallest is: " + pq.extractMin());
  	System.out.println("Next smallest is: " + pq.extractMin());
  	System.out.println("Next smallest is: " + pq.extractMin());
  	System.out.println("Next smallest is: " + pq.extractMin());
  	System.out.println("Next smallest is: " + pq.extractMin());
  	System.out.println("Next smallest is: " + pq.extractMin());
  	System.out.println("Next smallest is: " + pq.extractMin());
  	System.out.println("Next smallest is: " + pq.extractMin());
  }
}