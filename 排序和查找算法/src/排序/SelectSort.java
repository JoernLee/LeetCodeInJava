package ����;

public class SelectSort {
	
	/**
	 * ѡ������
	 * 1.��һ��ѭ���Ǵ��������鳤�ȣ�
	 * 2.�ڶ���ѭ��ͨ���Ƚ��ҵ���Сֵ�±꣬�͵�һ����һ��
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
