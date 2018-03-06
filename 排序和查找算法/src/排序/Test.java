package 排序;

import java.util.Arrays;


public class Test {

	public static void main(String[] args) {
		//临时测试一下字符串一个问题，不用管
		//testOther();
		
		int[] testArray = new int[]{1,1,22,15,18,4,10,8,9,55,33,0,6};
		//各种排序方法的简单测试
		//testBubble(testArray);
		
		//testSelectSort(testArray);
		
		//testInsertSort(testArray);
		
		//testShellSort(testArray);
		
		//testHeapSort(testArray);
		
		//testMergeSort(testArray);
		
		//testQuickSort(testArray);
		
	}

	private static void testQuickSort(int[] testArray) {
		new QuickSort().quickSort(testArray);
		System.out.println(Arrays.toString(testArray));
	}

	private static void testMergeSort(int[] testArray) {
		int[] newArray = new MergeSort().mergeSort(testArray, 0, testArray.length-1);
		System.out.println(Arrays.toString(newArray));
	}

	private static void testHeapSort(int[] testArray) {
		new HeapSort().heapSort(testArray);
		System.out.println(Arrays.toString(testArray));
	}

	private static void testShellSort(int[] testArray) {
		new ShellSort().shellSort(testArray);
		System.out.println(Arrays.toString(testArray));
	}

	private static void testOther() {
		String str1 = "helloworld";
		String str2 = new String("helloworld");
		String str3 = "hello"+"world";
		String str4 = "world";
		String str5 = "hello"+str4;
		System.out.println(str1==str2);
		System.out.println(str1==str3);
		System.out.println(str1==str5);
		System.out.println(str1==str1.intern());
	}

	private static void testInsertSort(int[] testArray) {
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
