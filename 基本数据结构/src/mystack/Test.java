package mystack;

public class Test {

	public static void main(String[] args) {
		MyStack stack = new MyStack();
		stack.pop();
		stack.push(10);
		stack.push(20);
		stack.push(30);
		stack.pop();
		stack.pop();
		stack.pop();
		stack.display();
	}

}
