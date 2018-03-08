package 查找;

import 查找.TreeSearch.TreeNode;

public class Test {

	public static void main(String[] args) {
		int[] testSortArray = new int[]{1,2,6,10,15,20,50,66,77,90};
		int[] testArray = new int[]{6,2,7,12,10,95,25,150};
		
		//testBinarySearch(testSortArray);
		//testTreeSeach(testArray);

	}

	private static void testTreeSeach(int[] testArray) {
		TreeSearch tree = new TreeSearch();  
		for(int i = 0;i < testArray.length;i++){
			tree.addNode(testArray[i]);
		}
		
		TreeNode target = tree.findNode(25);
		System.out.println(target);
		System.out.println(target.parent);
		System.out.println(target.left);
		System.out.println(target.right);
		
		System.out.println("=============================="+"采用递归的中序遍历开始"+"==============================");  
        tree.inOrderTraverseD(tree.root);
	}

	private static void testBinarySearch(int[] testSortArray) {
		int index = new BinarySearch().binarySearch(testSortArray, 90);
		System.out.println(index);
	}

}
