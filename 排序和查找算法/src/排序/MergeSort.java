package ����;

public class MergeSort {
	
	/**
	 * 1.�鲢����������ù鲢��˼��ʵ�ֵ����򷽷������ҳ����������ȫ�����������������дͼƬ���������ԣ����Ч�ʱȽϸߡ�
	 * 2.����ԭ�����£����ڸ�����һ���¼�����õݹ�����μ������������л��ֳ�ΪԽ��ԽС�İ��ӱ��ڶ԰��ӱ�����������õݹ鷽�����ź���İ��ӱ�ϲ���ΪԽ��Խ����������С� 
	 * 3.һ�˹鲢��Ҫ������ a[]�����ڵĳ���Ϊh���������н��������鲢.��������ŵ�temp[]�У�����Ҫ�����������е����м�¼ɨ��һ�飬��˺ķ�O(n)
	 * ������ȫ����������ȿ�֪�������鲢������Ҫ���У�����дͼƬ�������Σ�����ܵ�ʱ�临�Ӷ�ΪO(nlogn)���������ǹ鲢�����㷨����á����ƽ����ʱ�����ܡ�
	 * 4.���ڹ鲢�����ڹ鲢��������Ҫ��ԭʼ����ͬ�������Ĵ洢�ռ��Ź鲢����Լ��ݹ�ʱ���Ϊ����дͼƬ������ջ�ռ䣬��˿ռ临�Ӷ�ΪO(n+logn). 
	 * 5.�Դ��������ϸ�о�������merge��������if (a[i] < a[j]) ����䣬˵������Ҫ�����Ƚϣ���������Ծ����˹鲢������һ���ȶ��������㷨�� 
		Ҳ����˵���鲢������һ�ֱȽ�ռ�ڴ棬��ȴЧ�ʸ����ȶ����㷨��
	 * @param arr
	 * @param low
	 * @param high
	 */
	
	public int[] mergeSort(int[] arr,int low,int high){
		int mid = (low + high)/2;
		if(low < high){
			mergeSort(arr,low,mid);
			mergeSort(arr,mid+1,high);
			//���ҹ鲢
			merge(arr,low,mid,high);
		}
		return arr;
		
		
		
	}
	/**
	 * �Ѹ���low��mid��high�±꣬������������ݴ�С�ƶ���������
	 * @param arr
	 * @param low
	 * @param mid
	 * @param high
	 */
	private void merge(int[] arr, int low, int mid, int high) {
		int[] temp = new int[high-low+1];
		int i = low;
		int j = mid + 1;
		int k = 0;
		//�ѽ�С�������ƶ�������---(�ƶ�������֮ǰ�����ҵ��������Ȼ������ģ����Ƿָ��С״̬���ٺϲ��ģ�����ģ��һ��)
		while(i <= mid && j <= high){
			if(arr[i] < arr[j]){
				temp[k++] = arr[i];
				i++;
			}else{
				temp[k++] = arr[j];
				j++;
			}
		}
		 // �����ʣ������������� 
        while(i<=mid){
            temp[k++] = arr[i++];
        }
        // ���ұ߱�ʣ�������������
        while(j<=high){
            temp[k++] = arr[j++];
        }
        for(int x = 0;x < temp.length;x++){
        	arr[x + low] = temp[x];
        }
		
	}

}
