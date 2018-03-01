package myqueue;



public class MyQueue<E> {
	
	class Node<E>{
		E data;
		Node<E> next;
		
		public Node(E data){
			this.data = data;
		}
	}
	
	private Node<E> front;
	private Node<E> rear;
	private int length;
	
	public MyQueue(){
		front = null;
		rear = null;
		length = 0;
	}
	
	public boolean isEmpty() {
        return front == null;
    }
	
	public void enQueue(E data){
		Node<E> newNode = new Node<E>(data);
		if(length == 0){
			rear = newNode;
			front = newNode;
			length++;
		}else{
			rear.next = newNode;
			rear = newNode;
			length++;
		}
	}
	
	public E deQueue(){
		if(length == 0){
			System.out.println("该队列为空,无元素可以出列");
			return null;
		}else{
			E data = front.data;
			front = front.next;
			length--;
			return data;
		}
	}
	
	public void display(){
		Node<E> temp = front;
		while(temp != null){
			System.out.println(temp.data);
			temp = temp.next;
		}
	}
	
	
	
	
	
	

}
