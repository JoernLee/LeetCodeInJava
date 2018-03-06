package 排序;

public class QuickSort {
	
	/**
	 * 1.快速排序是我们之前学习的冒泡排序的升级，他们都属于交换类排序，都是采用不断的比较和移动来实现排序的。
	 * 快速排序是一种非常高效的排序算法，它的实现，增大了记录的比较和移动的距离，将关键字较大的记录从前面直接移动到后面，关键字较小的记录从后面直接移动到前面，从而减少了总的比较次数和移动次数。
	 * 2.对于给定的一组记录，选择一个基准元素,通常选择第一个元素或者最后一个元素,通过一趟扫描，将待排序列分成两部分,一部分比基准元素小,一部分大于等于基准元素,此时基准元素在其排好序后的正确位置,然后再用同样的方法递归地排序划分的两部分，直到序列中的所有记录均有序为止。
	 * 3.最坏情况是指每次区间划分的结果都是基准关键字的左边（或右边）序列为空，而另一边区间中的记录仅比排序前少了一项，即选择的关键字是待排序记录的最小值或最大值。最坏情况下快速排序的时间复杂度为这里写图片描述。 
	 * 最好情况是指每次区间划分的结果都是基准关键字的左右两边长度相等或者相差为1，即选择的基准关键字为待排序的记录的中间值。此时进行比较次数总共为 nlogn，所以最好情况下快速排序的时间复杂度为这里写图片描述。 
	 * 快速排序的平均时间复杂度为这里写图片描述。在所有平均时间复杂度为O(nlogn)的算法中，快速排序的平均性能是最好的。 
	 * 4.快速排序的过程中需要一个栈空间来实现递归。最好情况，递归树的深度为这里写图片描述，其空间复杂度也就是O(nlogn)；最坏情况下，需要进行 n-1次递归，其空间复杂度为O(n)；平均情况，空间复杂度为O(nlogn). 
	 * 5.第一种：三者取中。将序列首、尾和中间位置上的记录进行比较，选择三者中值作为基准关键字。 
		    第二种：取left和right之间的一个随机数这里写图片描述，用n[m]作为基准关键字。采用这种方法得到的快速排序一般称为随机的快速排序。
	   6.
	 * @param arr
	 */
	
	public void quickSort(int[] arr){
		sort(arr,0,arr.length-1);
	}

	private void sort(int[] arr, int low, int high) {
		int i,j,index;
		if(low > high){
			return;
		}
		
        
		
		i = low;
		j = high;
		//三数取中
		index=selectIndex(arr, low, high);
		//index= arr[i];//用子表第一个记录做基准
		while(i < j){
			//从表两端交替向中间扫描
			while(i < j && arr[j] >= index){
				j--;
			}
			if(i < j){
				arr[i] = arr[j];
				i++;
			}
			while(i < j && arr[i] < index){
				i++;
			}
			if(i < j){
				arr[j] = arr[i];
				j--;
			}
		}
		arr[i] = index ; //将基准数值替换回更新好的位置
		sort(arr,low,i - 1); //左子表递归排序
		sort(arr,i+1,high);
	}

	private int selectIndex(int[] arr, int low, int high) {
		//三数取中，mid，low，high选择里面大小为中间值的一个
        int mid=low+(high-low)/2;
        if(arr[mid]>arr[high]){
            swap(arr[mid],arr[high]);
        }
        if(arr[low]>arr[high]){
            swap(arr[low],arr[high]);
        }
        if(arr[mid]>arr[low]){
            swap(arr[mid],arr[low]);
        }
        return arr[low];
	}
	
	private static void swap(int a,int b){
        int temp=a;
        a=b;
        b=temp;
    }

}
