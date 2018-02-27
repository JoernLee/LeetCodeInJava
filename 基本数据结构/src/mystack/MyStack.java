package mystack;

class StackNode {
	Object data;
	StackNode next;
	
	public StackNode(Object data){
		this.data = data;
	}
}

/**
 * 实现栈，包括栈的展示，弹栈，出栈
 * @author Joern
 *
 */
public class MyStack {
	
	private StackNode first = null;
	
	private int length = 0;
	
	public void push(Object obj){
		StackNode newNode = new StackNode(obj);
		newNode.next = first;
		first = newNode;
		length++;
	}
	
	public void pop(){
		if(length==0){
			System.out.println("empty");
			return;
		}
		first = first.next;
		length--;
	}
	
	public void display(){
		if(first == null)  
            System.out.println("empty");  
        System.out.print("top -> bottom : | ");  
        StackNode cur = first;  
        while(cur != null){  
            System.out.print(cur.data.toString() + " | ");  
            cur = cur.next;  
        }  
        System.out.print("\n");  
	}
	
}
