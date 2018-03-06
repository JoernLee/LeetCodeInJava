package 排序;

public class MergeSort {
	
	/**
	 * 1.归并排序就是利用归并的思想实现的排序方法。而且充分利用了完全二叉树的深度是这里写图片描述的特性，因此效率比较高。
	 * 2.基本原理如下：对于给定的一组记录，利用递归与分治技术将数据序列划分成为越来越小的半子表，在对半子表排序，最后再用递归方法将排好序的半子表合并成为越来越大的有序序列。 
	 * 3.一趟归并需要将数组 a[]中相邻的长度为h的有序序列进行两两归并.并将结果放到temp[]中，这需要将待排序列中的所有记录扫描一遍，因此耗费O(n)
	 * 而又完全二叉树的深度可知，整个归并排序需要进行（这里写图片描述）次，因此总的时间复杂度为O(nlogn)，而且这是归并排序算法中最好、最坏、平均的时间性能。
	 * 4.由于归并排序在归并过程中需要与原始序列同样数量的存储空间存放归并结果以及递归时深度为这里写图片描述的栈空间，因此空间复杂度为O(n+logn). 
	 * 5.对代码进行仔细研究，发现merge函数中有if (a[i] < a[j]) 的语句，说明它需要两两比较，不存在跳跃，因此归并排序是一种稳定的排序算法。 
		也就是说，归并排序是一种比较占内存，但却效率高且稳定的算法。
	 * @param arr
	 * @param low
	 * @param high
	 */
	
	public int[] mergeSort(int[] arr,int low,int high){
		int mid = (low + high)/2;
		if(low < high){
			mergeSort(arr,low,mid);
			mergeSort(arr,mid+1,high);
			//左右归并
			merge(arr,low,mid,high);
		}
		return arr;
		
		
		
	}
	/**
	 * 把根据low，mid，high下标，把左右数组根据大小移动到新数组
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
		//把较小的数先移动新数组---(移动新数组之前的左右单独数组必然是有序的，这是分割到最小状态后再合并的，可以模拟一下)
		while(i <= mid && j <= high){
			if(arr[i] < arr[j]){
				temp[k++] = arr[i];
				i++;
			}else{
				temp[k++] = arr[j];
				j++;
			}
		}
		 // 把左边剩余的数移入数组 
        while(i<=mid){
            temp[k++] = arr[i++];
        }
        // 把右边边剩余的数移入数组
        while(j<=high){
            temp[k++] = arr[j++];
        }
        for(int x = 0;x < temp.length;x++){
        	arr[x + low] = temp[x];
        }
		
	}

}
