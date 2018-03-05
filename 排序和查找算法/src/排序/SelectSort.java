package 排序;

public class SelectSort {
	
	/**
	 * 选择排序
	 * 1.第一轮循环是次数（数组长度）
	 * 2.第二轮循环通过比较找到最小值下标，和第一个换一下
	 */
	public void selectSort(int[] array){
		int i,j,min;
		for(i = 0;i < array.length;i++ ){
			min = i;
			for(j = i + 1; j < array.length;j++){
				if(array[min] > array[j]){
					min = j;
				}
			}
			if(i != min){
				swap(array,i,min);
			}
		}
	}
	
	private void swap(int[] array, int j,int i) {
		int temp = array[j];
		array[j] = array[i];
		array[i] = temp;
	}
}
