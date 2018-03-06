package 排序;


public class ShellSort {
	
	/**
	 * 1.基本原理:将待排序的数组元素分成多个子序列，使得每个子序列的元素个数相对较少，
	 * 然后对各个子序列分别进行直接插入排序，待整个待排序列“基本有序”后，最后在对所有元素进行一次直接插入排序。
	 * 2.希尔排序的关键并不是随便分组后各自排序，而是将相隔某个“增量”的记录组成一个子序列，实现跳跃式移动，使得排序的效率提高。需要注意的是，增量序列的最后一个增量值必须等于1才行。另外，由于记录是跳跃式的移动，希尔排序并不是一种稳定的排序算法。 
	 * 3.希尔排序最好时间复杂度和平均时间复杂度都是这里写图片描述，最坏时间复杂度为这里写图片描述。
	 * 4.其实就是在插入排序基础上添加了增量移动，减少了平均比较次数
	 * @param arr
	 */
	
	public void shellSort(int[] arr){
		int j = 0;
		int temp = 0;
		for(int increment = arr.length/2;increment > 0;increment/=2){
			temp = arr[j];
			for(int i = increment; i < arr.length;i++){
				temp = arr[i];
				for(j = i - increment;j >= 0;j-=increment){
					if(arr[j] > temp){
						arr[j+increment] = arr[j];
					}else{
						break;
					}
				}
				arr[j+increment] = temp;
			}
		}
		
	}

}
