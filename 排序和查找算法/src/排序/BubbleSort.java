package ����;

public class BubbleSort {
	
	/**
	 * ð������
	 * 1.��һ��ѭ��ȷ���ж��ٸ�Ԫ����Ҫð��
	 * 2.�ڶ���ѭ���Ӻ���ǰ���бȽϣ�������ľͽ���������С������������Ǹ�С�ļ���ð�ݣ�
	 * 3.������һ��flag��־λ�����һ��ð�ݶ�û�н����ģ������Ѿ��ź��򣬲���Ҫ��һ���ѭ����
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
