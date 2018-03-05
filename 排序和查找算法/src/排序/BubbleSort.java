package 排序;

public class BubbleSort {
	
	/**
	 * 冒泡排序
	 * 1.第一个循环确定有多少个元素需要冒泡
	 * 2.第二个循环从后向前进行比较，遇到大的就交换，遇到小的则继续（用那个小的继续冒泡）
	 * 3.加入了一个flag标志位，如果一轮冒泡都没有交换的，代表已经排好序，不需要第一层的循环了
	 * @param array
	 */
	public void BubbleSort0(int[] array){
		for(int i = 1;i < array.length;i++ ){
			for(int j = array.length - 1; j >= i ; j--){
				if(array[j] < array[j-1]){
					swap(array, j);
				}
			}
		}
	}
	
	public void BubbleSort1(int[] array){
		boolean flag = true;
		for(int i = 1;i < array.length && flag;i++ ){
			flag = false;
			for(int j = array.length - 1; j >= i ; j--){
				if(array[j] < array[j-1]){
					flag = true;
					swap(array, j);
				}
			}
		}
	}

	private void swap(int[] array, int j) {
		int temp = array[j];
		array[j] = array[j-1];
		array[j-1] = temp;
	}
	
	

}
