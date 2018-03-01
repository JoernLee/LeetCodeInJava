package 二叉树;

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
	
	//自己创建一个简单的二叉树
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
	 * 前序遍历（递归）
	 * 1.访问这个节点
	 * 2.调用自身来遍历左子树
	 * 3.调用自身来遍历右子树
	 */
	public void preOrderTraverse(){
		System.out.println("前序遍历:");
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
	 * 前序遍历（非递归）
	 * 1.对于任意节点current，若该节点不为空则访问该节点后再将节点压栈，并将左子树节点置为current，重复此操作，直到current为空。
	 * 2.若左子树为空，栈顶节点出栈，将该节点的右子树置为current 
	 * 3.重复1、2步操作，直到current为空且栈内节点为空。 
	 */
	public void preOrderByStack(){
		System.out.println("前序非递归遍历");
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
	 * 中序遍历(递归)
	 * 1.调用自身来遍历左子树
	 * 2.访问节点
	 * 3.调用自身来遍历右子树
	 */
	public void inOrderTraverse() {  
	    System.out.println("中序遍历:");  
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
	 * 中序遍历（非递归）
	 * 1.对于任意节点current，若该节点不为空则将该节点压栈，并将左子树节点置为current，重复此操作，直到current为空。 
	 * 2.若左子树为空，栈顶节点出栈，访问节点后将该节点的右子树置为current 
	 * 3.重复1、2步操作，直到current为空且栈内节点为空。
	 * 
	 * 
	 */
	public void inOrderByStack() {  
        System.out.println("中序非递归遍历:");  
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
	 * 后序遍历(递归)
	 * 1.调用自身来遍历左子树
	 * 2.调用自身来遍历右子树
	 * 3.访问节点
	 */
	public void postOrderTraverse(){
		System.out.println("后序遍历:");
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
	 * 后序遍历（非递归）
	 * 1.对于任意节点current，若该节点不为空则将节点压栈，并将左子树节点置为current，重复此操作，直到current为空。 
	 * 2.若左子树为空，取栈顶节点的右子树，如果右子树为空或右子树刚访问过，则访问该节点，并将preNode置为该节点 
	 * 3.重复1、2步操作，直到current为空且栈内节点为空。 
	 */
	public void postOrderByStack(){
		System.out.println("后序非递归遍历:");
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
