package 查找;

import java.util.Stack;


public class TreeSearch {

	/**
	 * 二叉树节点
	 * 
	 * @author Joern
	 *
	 */
	 class TreeNode {
		public Integer data;

		// 父节点
		public TreeNode parent;
		// 左子节点
		public TreeNode left;
		// 右子节点
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
	 * 往树中添加节点
	 * 
	 * @param data
	 * @return boolean
	 */
	public boolean addNode(Integer data) {
		if (root == null) {
			root = new TreeNode(data);
			System.out.println("数据成功插入到二叉树");
			return true;
		}
		TreeNode newNode = new TreeNode(data);
		TreeNode currentNode = root;
		TreeNode parentNode;

		while (true) {
			// 保存
			parentNode = currentNode;
			// 当前数据更小-插入到左子树
			if (data < currentNode.data) {
				currentNode = currentNode.left;
				// 当前父节点的左子节点为空-插入
				if (currentNode == null) {
					parentNode.left = newNode;
					newNode.parent = parentNode;
					System.out.println("数据成功插入到二叉查找树");
					size++;
					return true;
				}
				// 左子节点非空就不用处理，继续循环判断。

			} else if (data > currentNode.data) {
				// 当前数据更大-插入到右子树
				currentNode = currentNode.right;
				if (currentNode == null) {
					parentNode.right = newNode;
					newNode.parent = parentNode;
					System.out.println("数据成功插入到二叉查找树");
					size++;
					return true;
				}
			} else {
				System.out.println("当前数据已经存在");
				return false;
			}

		}

	}
	
	/**
	 * 查找数据
	 * @param data
	 * @return TreeNode
	 */
	public TreeNode findNode(Integer data){
		TreeNode targetNode = null;
		if(root == null){
			System.out.println("查找失败---二叉查找树为空");
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
				System.out.println("查找成功");
				return targetNode;
			}	
		}
		return null;
	}
	
	/**
	 * 前序遍历-递归
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
	 * 前序遍历-非递归
	 * @param current
	 */
	public static void preOrderTraverseND(TreeNode current){
		if(current != null){
			//需要一个栈作为辅助结构
			Stack<TreeNode> stack = new Stack<>();
			stack.push(current);
			while(!stack.isEmpty()){
				TreeNode temp = stack.pop();
				System.out.println(temp.data + " ");
				//右子节点不为空，先放
				if(temp.right != null){
					stack.push(temp.right);
					
				}
				//放完右子节点放左子节点，下次先取
				if(temp.left != null){
					stack.push(temp.left);
				}
			}
		}
	}
	
	/**
	 * 中序遍历递归-最重要-打印顺序就是排序的顺序
	 */
	public void inOrderTraverseD(TreeNode node) {  
	    if (node == null)   
	        return ;  
	      
	    inOrderTraverseD(node.left);  
	    System.out.println(node.data + "  ");
	    inOrderTraverseD(node.right);  
	} 
	
	 /** 
     * 循环实现中序遍历 
     * @param treeNode 
     */  
    public static void inOrderTraverseND(TreeNode treeNode){      
        Stack<TreeNode> stack = new Stack<TreeNode>();    
        TreeNode current = treeNode;    
        while (current != null || !stack.isEmpty()) {   
        	//先一直遍历左子树直到为空
            while(current != null) {    
                stack.push(current);    
                current = current.left;    
            }
            if (!stack.isEmpty()) { 
            	//当左子树遍历完成，取出打印-并开始对右子节点进行左遍历
                current = stack.pop();    
                System.out.print(current.data+"  ");    
                current = current.right;    
            }    
        }         
    }  
    
    /**
	 * 后序遍历(递归)
	 * 1.调用自身来遍历左子树
	 * 2.调用自身来遍历右子树
	 * 3.访问节点
	 */
	
	public void postOrderTraverseD(TreeNode node){
		if(node == null){
			return ;
		}
		postOrderTraverseD(node.left);
		postOrderTraverseD(node.right);
		System.out.println(node.data + "  ");
	}
    
    //后序的循环调用就不贴了，可以参看基本数据结构包下的BinaryTree里面有

}
