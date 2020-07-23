/*Kymberlee Sables 
 This program inserts integers into a queue and print out its contents. After printing out the contents, a method (dequeue)
 is called and removes one element at a time from the front of the queue. After every 5 elements are removed, the queue and
 its contents are reprinted. This happens until the queue is empty.*/

//TestQueue Class
public class TestQueueSables {
	// Main Method
	public static void main(String[] args) {
		// Instance of class Queue with initial capacity of 8.
		QueueSables queue = new QueueSables(8);

		// Calling enqueue method and inserting integers 1 through 20.
		for (int i = 1; i <= 20; i++) {
			queue.enqueue(i);
		}

		// Calling empty method to check if any elements has been inserted into the
		// queue. If not, the program will exit.
		if (queue.empty() == false)
			;
		else {
			System.out.println("The queue is empty. There is nothing to print. Please try again.");
			System.exit(0);
		}

		// Printing the contents of the queue.
		System.out.printf("Initial Queue Contents:   (Queue Size = %d)\n", queue.getSize());
		for (int i = 0; i < queue.getSize(); i++) {
			System.out.printf("%d ", queue.getElements(i));
		}

		// Calling dequeue repeatedly until the queue empties. Additionally, this
		// iteration prints queue contents after removing 5 elements.
		int count = 0;
		int size = queue.getSize();

		if (queue.empty() == false) {
			for (int i = 0; i < queue.getSize(); i++) {
				queue.dequeue();
				count++;
				size--;
				if (count % 5 == 0) {
					System.out.printf("\n");
					System.out.printf("Queue contents after removing 5 elements:   (Queue Size = %d)\n", size);
					for (int j = 0; j < queue.getSize(); j++) {
						if ((queue.getElements(j) != 0))
							System.out.printf("%d ", queue.getElements(j));
					}
					if (size == 0) {
						System.out.println("The queue is now empty.");
					}
				}
			}
		}
	}
}

//Queue Class
class QueueSables {
	// variables (data field)
	private int size;
	private int[] elements;
	private static final int DEFAULT_CAPACITY = 0;

	/*
	 * Default Constructor (no-args constructor) - sets the queue's default capacity
	 * to 0.
	 */
	public QueueSables() {
		this(DEFAULT_CAPACITY);
	}

	/* Constructor (queue capacity) - sets the queue's specified capacity. */
	public QueueSables(int capacity) {
		elements = new int[capacity];
	}

	/*
	 * Enqueue Method (setter) - this method inserts the elements of the queue. If
	 * the number of elements exceed the capacity of the array, the array size
	 * doubles.
	 */
	public void enqueue(int v) {
		if (size >= elements.length) {
			int[] temp = new int[elements.length * 2];
			System.arraycopy(elements, 0, temp, 0, elements.length);
			elements = temp;
		}
		elements[size++] = v;
	}

	/*
	 * Dequeue Method (setter) - This method removes the element at the front of the
	 * queue and shifts the whole array one position to the left.
	 */
	public int dequeue() {
		int temp = elements[0];
		for (int i = 0; i < elements.length - 1; i++) {
			elements[i] = elements[i + 1];
		}
		elements[elements.length - 1] = 0;
		return temp;
	}

	/* Empty Method - This method checks if the queue is empty or not. */
	public boolean empty() {
		return size == 0;
	}

	/*
	 * Get Size Method (getter) - This method returns the current size of the array.
	 */
	public int getSize() {
		return size;
	}

	/*
	 * Get Elements Method (getter) - This method gives indirect access of the
	 * elements when called in the main method. This is necessary to be able to
	 * print the queue contents.
	 */
	public int getElements(int position) {
		return elements[position];
	}
}