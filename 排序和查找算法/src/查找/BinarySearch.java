package 查找;

public class BinarySearch {
	
	/**
	 * 二分查找
	 * @param arr
	 * @param target
	 * @return
	 */
	public int binarySearch(int[] arr,int target){
		int index = -1;
		int low,mid,high;
		low = 0;
		high = arr.length - 1;
		mid = (low + high)/2;
		
		while(high > low){
			if(target > arr[mid]){
				low = mid + 1;
				mid = (low + high)/2;
			}else if(target < arr[mid]){
				high = mid - 1;
				mid = (low + high)/2;
			}
			
			if(arr[mid] == target){
				return mid;
			}
		}
		return index;
	}
		

}
