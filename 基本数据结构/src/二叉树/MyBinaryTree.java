package ������;

import java.util.Stack;

public class MyBinaryTree {
	
	private Node root = null;  
	
	private class Node{
		int data;
		Node lChild;
		Node rChild;
		
		public Node(int data){
			this.data = data;
		}
		
		public void display() {  
	        System.out.print(this.data + "\t");  
	    }  
	  
	    @Override  
	    public String toString() {  
	        // TODO Auto-generated method stub  
	        return String.valueOf(data);  
	    }  
	}
	
	public MyBinaryTree(int value){
		root = new Node(value);
		root.lChild = null;
		root.rChild = null;
	}
	
	//�Լ�����һ���򵥵Ķ�����
	public void createTestBiTree(){
		Node l = new Node(1);
		Node r = new Node(2);
		Node ll = new Node(3);
		Node lr = new Node(4);
		Node rl = new Node(5);
		Node rr = new Node(6);
		
		root.lChild = l;
		root.rChild = r;
		l.lChild = ll;
		l.rChild = lr;
		r.lChild = rl;
		r.rChild = rr;
	}
	
	/**
	 * ǰ��������ݹ飩
	 * 1.��������ڵ�
	 * 2.��������������������
	 * 3.��������������������
	 */
	public void preOrderTraverse(){
		System.out.println("ǰ�����:");
		preOrderTraverse(root);
		System.out.println();
	}
	
	public void preOrderTraverse(Node node){
		if(node == null){
			return ;
		}
		node.display();
		preOrderTraverse(node.lChild);
		preOrderTraverse(node.rChild);
	}
	/**
	 * ǰ��������ǵݹ飩
	 * 1.��������ڵ�current�����ýڵ㲻Ϊ������ʸýڵ���ٽ��ڵ�ѹջ�������������ڵ���Ϊcurrent���ظ��˲�����ֱ��currentΪ�ա�
	 * 2.��������Ϊ�գ�ջ���ڵ��ջ�����ýڵ����������Ϊcurrent 
	 * 3.�ظ�1��2��������ֱ��currentΪ����ջ�ڽڵ�Ϊ�ա� 
	 */
	public void preOrderByStack(){
		System.out.println("ǰ��ǵݹ����");
		Stack<Node> stack = new Stack<Node>();
		Node current =root;
		while(current != null || !stack.isEmpty()){
			while(current != null){
				stack.push(current);
				current.display();
				current = current.lChild;	
			}
			if(!stack.isEmpty()){
				current = stack.pop();
				current = current.rChild;
			}
			
		}
		System.out.println();
	}
	
	/**
	 * �������(�ݹ�)
	 * 1.��������������������
	 * 2.���ʽڵ�
	 * 3.��������������������
	 */
	public void inOrderTraverse() {  
	    System.out.println("�������:");  
	    inOrderTraverse(root);  
	    System.out.println();  
	}  
	  
	private void inOrderTraverse(Node node) {  
	    if (node == null)   
	        return ;  
	      
	    inOrderTraverse(node.lChild);  
	    node.display();  
	    inOrderTraverse(node.rChild);  
	} 
	
	/**
	 * ����������ǵݹ飩
	 * 1.��������ڵ�current�����ýڵ㲻Ϊ���򽫸ýڵ�ѹջ�������������ڵ���Ϊcurrent���ظ��˲�����ֱ��currentΪ�ա� 
	 * 2.��������Ϊ�գ�ջ���ڵ��ջ�����ʽڵ�󽫸ýڵ����������Ϊcurrent 
	 * 3.�ظ�1��2��������ֱ��currentΪ����ջ�ڽڵ�Ϊ�ա�
	 * 
	 * 
	 */
	public void inOrderByStack() {  
        System.out.println("����ǵݹ����:");  
        Stack<Node> stack = new Stack<Node>();  
        Node current = root;  
        while (current != null || !stack.isEmpty()) {  
            while (current != null) {  
                stack.push(current);  
                current = current.lChild;  
            }  
              
            if (!stack.isEmpty()) {  
                current = stack.pop();  
                current.display();  
                current = current.rChild;  
            }  
        }  
        System.out.println();  
    }  
	
	/**
	 * �������(�ݹ�)
	 * 1.��������������������
	 * 2.��������������������
	 * 3.���ʽڵ�
	 */
	public void postOrderTraverse(){
		System.out.println("�������:");
		postOrderTraverse(root);
		System.out.println();
	}
	
	public void postOrderTraverse(Node node){
		if(node == null){
			return ;
		}
		postOrderTraverse(node.lChild);
		postOrderTraverse(node.rChild);;
		node.display();
	}
	
	/**
	 * ����������ǵݹ飩
	 * 1.��������ڵ�current�����ýڵ㲻Ϊ���򽫽ڵ�ѹջ�������������ڵ���Ϊcurrent���ظ��˲�����ֱ��currentΪ�ա� 
	 * 2.��������Ϊ�գ�ȡջ���ڵ�������������������Ϊ�ջ��������շ��ʹ�������ʸýڵ㣬����preNode��Ϊ�ýڵ� 
	 * 3.�ظ�1��2��������ֱ��currentΪ����ջ�ڽڵ�Ϊ�ա� 
	 */
	public void postOrderByStack(){
		System.out.println("����ǵݹ����:");
		Node preNode = null;
		Node current = root;
		Stack<Node> stack = new Stack<Node>();
		while(current != null || !stack.isEmpty()){
			while(current != null){
				stack.push(current);
				current =current.lChild;
			}
			
			if(!stack.isEmpty()){
				current = stack.peek().rChild;
				if(current == null || current == preNode){
					current = stack.pop();
					current.display();
					preNode = current;
					current = null;
				}
			}
		}
		System.out.println();
	}
}
