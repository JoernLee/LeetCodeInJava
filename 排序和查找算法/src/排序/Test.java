package ����;

import java.util.Arrays;

public class Test {

	public static void main(String[] args) {
		int[] testArray = new int[]{1,1,22,15,18,4,10,8,9,55,33,0,6};
		//�������򷽷��ļ򵥲���
		//testBubble(testArray);
		
		//testSelectSort(testArray);
		
		//insertSort(testArray);
	}

	private static void insertSort(int[] testArray) {
		new InsertSort().insertSort(testArray);
		System.out.println(Arrays.toString(testArray));
	}

	private static void testSelectSort(int[] testArray) {
		new SelectSort().selectSort(testArray);
		System.out.println(Arrays.toString(testArray));
	}

	private static void testBubble(int[] testArray) {
		new BubbleSort().BubbleSort1(testArray);
		System.out.println(Arrays.toString(testArray));
	}

}
