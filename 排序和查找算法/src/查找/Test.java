package ≤È’“;

public class Test {

	public static void main(String[] args) {
		int[] testSortArray = new int[]{1,2,6,10,15,20,50,66,77,90};
		int[] testArray = new int[]{6,2,7,12,10,95,25,150};
		
		//testBinarySearch(testSortArray);

	}

	private static void testBinarySearch(int[] testSortArray) {
		int index = new BinarySearch().binarySearch(testSortArray, 90);
		System.out.println(index);
	}

}
