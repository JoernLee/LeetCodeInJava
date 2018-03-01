package myqueue;

public class Test {

	public static void main(String[] args) {
		MyQueue<Integer> myQueue = new MyQueue<>();
		myQueue.enQueue(10);
		myQueue.enQueue(5);
		myQueue.enQueue(1);
		myQueue.deQueue();
		myQueue.deQueue();
		myQueue.display();
	}

}
