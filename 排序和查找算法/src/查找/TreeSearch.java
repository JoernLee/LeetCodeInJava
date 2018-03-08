package ����;

import java.util.Stack;


public class TreeSearch {

	/**
	 * �������ڵ�
	 * 
	 * @author Joern
	 *
	 */
	 class TreeNode {
		public Integer data;

		// ���ڵ�
		public TreeNode parent;
		// ���ӽڵ�
		public TreeNode left;
		// ���ӽڵ�
		public TreeNode right;

		public TreeNode(Integer data) {
			this.data = data;
		}

		@Override
		public String toString() {
			return "TreeNode[data =" + data + "]";
		}
	}

	public TreeNode root;

	public long size;

	/**
	 * ��������ӽڵ�
	 * 
	 * @param data
	 * @return boolean
	 */
	public boolean addNode(Integer data) {
		if (root == null) {
			root = new TreeNode(data);
			System.out.println("���ݳɹ����뵽������");
			return true;
		}
		TreeNode newNode = new TreeNode(data);
		TreeNode currentNode = root;
		TreeNode parentNode;

		while (true) {
			// ����
			parentNode = currentNode;
			// ��ǰ���ݸ�С-���뵽������
			if (data < currentNode.data) {
				currentNode = currentNode.left;
				// ��ǰ���ڵ�����ӽڵ�Ϊ��-����
				if (currentNode == null) {
					parentNode.left = newNode;
					newNode.parent = parentNode;
					System.out.println("���ݳɹ����뵽���������");
					size++;
					return true;
				}
				// ���ӽڵ�ǿվͲ��ô�������ѭ���жϡ�

			} else if (data > currentNode.data) {
				// ��ǰ���ݸ���-���뵽������
				currentNode = currentNode.right;
				if (currentNode == null) {
					parentNode.right = newNode;
					newNode.parent = parentNode;
					System.out.println("���ݳɹ����뵽���������");
					size++;
					return true;
				}
			} else {
				System.out.println("��ǰ�����Ѿ�����");
				return false;
			}

		}

	}
	
	/**
	 * ��������
	 * @param data
	 * @return TreeNode
	 */
	public TreeNode findNode(Integer data){
		TreeNode targetNode = null;
		if(root == null){
			System.out.println("����ʧ��---���������Ϊ��");
			return null;
		}
		TreeNode currentNode = root;
		
		while(currentNode != null){
			if(data < currentNode.data){
				currentNode = currentNode.left;
			}else if(data > currentNode.data){
				currentNode = currentNode.right;
			}else{
				targetNode = currentNode;
				System.out.println("���ҳɹ�");
				return targetNode;
			}	
		}
		return null;
	}
	
	/**
	 * ǰ�����-�ݹ�
	 * @param current
	 */
	public static void preOrderTraverseD(TreeNode current){
		if(current == null){
			return ;
		}
		System.out.println(current.data + "  ");
		preOrderTraverseD(current.left);
		preOrderTraverseD(current.right);
	}
	/**
	 * ǰ�����-�ǵݹ�
	 * @param current
	 */
	public static void preOrderTraverseND(TreeNode current){
		if(current != null){
			//��Ҫһ��ջ��Ϊ�����ṹ
			Stack<TreeNode> stack = new Stack<>();
			stack.push(current);
			while(!stack.isEmpty()){
				TreeNode temp = stack.pop();
				System.out.println(temp.data + " ");
				//���ӽڵ㲻Ϊ�գ��ȷ�
				if(temp.right != null){
					stack.push(temp.right);
					
				}
				//�������ӽڵ�����ӽڵ㣬�´���ȡ
				if(temp.left != null){
					stack.push(temp.left);
				}
			}
		}
	}
	
	/**
	 * ��������ݹ�-����Ҫ-��ӡ˳����������˳��
	 */
	public void inOrderTraverseD(TreeNode node) {  
	    if (node == null)   
	        return ;  
	      
	    inOrderTraverseD(node.left);  
	    System.out.println(node.data + "  ");
	    inOrderTraverseD(node.right);  
	} 
	
	 /** 
     * ѭ��ʵ��������� 
     * @param treeNode 
     */  
    public static void inOrderTraverseND(TreeNode treeNode){      
        Stack<TreeNode> stack = new Stack<TreeNode>();    
        TreeNode current = treeNode;    
        while (current != null || !stack.isEmpty()) {   
        	//��һֱ����������ֱ��Ϊ��
            while(current != null) {    
                stack.push(current);    
                current = current.left;    
            }
            if (!stack.isEmpty()) { 
            	//��������������ɣ�ȡ����ӡ-����ʼ�����ӽڵ���������
                current = stack.pop();    
                System.out.print(current.data+"  ");    
                current = current.right;    
            }    
        }         
    }  
    
    /**
	 * �������(�ݹ�)
	 * 1.��������������������
	 * 2.��������������������
	 * 3.���ʽڵ�
	 */
	
	public void postOrderTraverseD(TreeNode node){
		if(node == null){
			return ;
		}
		postOrderTraverseD(node.left);
		postOrderTraverseD(node.right);
		System.out.println(node.data + "  ");
	}
    
    //�����ѭ�����þͲ����ˣ����Բο��������ݽṹ���µ�BinaryTree������

}
