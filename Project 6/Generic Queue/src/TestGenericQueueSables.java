/*Kymberlee Sables  
 This Java program functions by reading contents from a file and adding those contents to a queue. The program
 proceeds to print the queue after every five elements have been removed until the queue is empty. This was achieved
 through Generics, since one queue is of type String and the other queue is of type Integer (wrapper type).*/

//imports
import java.util.ArrayList; 
import java.util.Scanner;
import java.io.*;

//TestGenericQueue Class
public class TestGenericQueueSables {
	// main method
	public static void main(String[] args) {
		// Creating two instances of GenericQueueSables class. One of type String, and
		// the other of type Integer.
		GenericQueueSables<String> queue1 = new GenericQueueSables<String>();
		GenericQueueSables<Integer> queue2 = new GenericQueueSables<Integer>();

		System.out.println("Initial Queue Contents: ");

		// Reading file contents and filling the first queue of type String.
		try (Scanner scan = new Scanner(new FileReader("people.dat"))) {
			while (scan.hasNextLine()) {
				queue1.enqueue(scan.nextLine());
			}
			scan.close();
		} catch (Exception e) {
			System.out.println(e);
		}

		// Printing the initial queue contents.
		queue1.printQueue();

		// While the queue is not empty, dequeue method is called until queue is empty.
		// Prints queue after every 5 elements removed.
		while (queue1.queueEmpty() == true) {
			queue1.dequeue();
			if (queue1.size() == 5) {
				System.out.println("The queue contents after removing 5 elements: ");
				queue1.printQueue();
			} else if (queue1.queueEmpty() == false) {
				System.out.println("The queue is now empty: ");
				queue1.printQueue();
			}
		}

		System.out.println("Initial Queue Contents: ");

		/*
		 * NOTE: Since the contents of the second queue are still of type String, it
		 * needs to be converted to type Integer (wrapper).
		 */

		// Temporary String array made to hold contents of the second queue.
		ArrayList<String> stringTemp = new ArrayList<String>();

		// Reading file contents and filling the temporary queue.
		try (Scanner scan2 = new Scanner(new FileReader("numbers.dat"))) {
			while (scan2.hasNextLine()) {
				stringTemp.add(scan2.next());
			}
			scan2.close();
		} catch (Exception e) {
			System.out.println(e);
		}

		// Transferring temporary array contents to queue2 while converting the contents
		// to type Integer using parseInt.
		for (int i = 0; i < stringTemp.size(); i++) {
			queue2.enqueue(Integer.parseInt(stringTemp.get(i)));
		}
		// Printing the initial queue contents.
		queue2.printQueue();

		// While the queue is not empty, dequeue method is called until queue is empty.
		// Prints queue after every 5 elements removed.
		while (queue2.queueEmpty() == true) {
			queue2.dequeue();
			if (queue2.size() == 5) {
				System.out.println("The queue contents after removing 5 elements: ");
				queue2.printQueue();
			} else if (queue2.queueEmpty() == false) {
				System.out.println("The queue is now empty: ");
				queue2.printQueue();
			}
		}
	}
}

//GenericQueue Class - Extends ArrayList Class (Generic Type)
class GenericQueueSables<E> extends ArrayList<E> {
	private static final long serialVersionUID = 1L;

	/* Enqueue Method - this method generically adds elements to the queue */
	public void enqueue(E element) {
		this.add(element);
	}

	/* Dequeue Method - this method generically removes elements from the queue */
	public E dequeue() {
		return this.remove(0);
	}

	/*
	 * queueEmpty Method - checks if queue is empty or not. Returns if the queue is
	 * NOT empty
	 */
	public boolean queueEmpty() {
		return !this.isEmpty();
	}

	/* printQueue Method - prints out the queue contents */
	public void printQueue() {
		System.out.println(this.toString());
	}
}