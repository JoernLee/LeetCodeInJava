package ¶þ²æÊ÷;

public class Test {

	public static void main(String[] args) {
		MyBinaryTree myBinaryTree = new MyBinaryTree(0);
		myBinaryTree.createTestBiTree();
		myBinaryTree.preOrderTraverse();
		myBinaryTree.inOrderTraverse();
		myBinaryTree.postOrderTraverse();
		
		myBinaryTree.preOrderByStack();
		myBinaryTree.inOrderByStack();
		myBinaryTree.postOrderByStack();

	}

}
