package acm;
/*快速排序
 *1>.选择一个基准元素，通常选择第一个元素或者最后一个元素
 *2>.通过一趟排序将待排序的记录分割成独立的两部分，其中一部分记录的元素都比基准元素小，另一部分记录的元素都比基准元素大。
 *3>.此时的基准元素在其排好序的正确位置
 *4>.然后分别用同样的方法对这两部分进行排序，直到整个序列有序
*/
public class QuickSort {	
	public static void main(String[] args){
		int[] ary = new int[]{5,3,1,9,8,2,4,7};
		//System.out.print("test1");
		Sort1 qs = new Sort1();
		//System.out.print("test2");
		qs.quicksork(ary);
		//System.out.println("3");
		for(int i=0;i<ary.length;i++){
			System.out.print(ary[i]+",");
		}
	}
}
class Sort1{
	public static void quicksork(int[] array){
		//该函数的作用是直接输入一个数组即可返回排序结果
		quickSort(array,0,(array.length-1));
	} 
	//利用递归思想进行排序
	static void quickSort(int[] ary,int low,int high){
		if(low<high){
			int segment = partition(ary,low,high);
			quickSort(ary,low,segment-1);
			quickSort(ary,segment+1,high);
		}	
	}	
	//找到分割元素最终的位置
	static int partition(int[] arr,int low,int high){
		int pivot = arr[low];
		while(low<high){
			while(low<high && pivot<=arr[high]) high--;
			arr[low] = arr[high];
			while(low<high && pivot>=arr[low]) low++;
			arr[high] = arr[low];
		}
		arr[low] = pivot;	
		return low;	
	}
	
}

