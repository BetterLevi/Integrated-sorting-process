package acm;
//堆排序
class HpSort {
	
	public void sort(int[] ary){
		int length = ary.length;
		if(length<1) return;
		for(int i=length/2-1;i>=0;i--){
			maxHeapify(ary,i,length);			
		}
		for(int i=length-1;i>0;i--){
			swap(ary,0,i);
			maxHeapify(ary,0,length--);
		}
	}
	public static int getLeft(int index){
		return 2*index+1;   //因为数组从0开始放数据
	}
	public static int getRight(int index){
		return 2*index+2;
	}
	
	public static void swap(int[] ary,int before,int after){
		int temp = ary[before];
		ary[before] = ary[after];
		ary[after] = temp;
	}
	public static void maxHeapify(int[] ary,int index,int length){
		//初始化大顶堆
		if(ary.length<=0 || length<=1)
			return;
		int largest = index;
		int left = getLeft(index);
		int right = getRight(index);
		if(left<length-1 && ary[index]<ary[left]){
			largest = left;
		}
		if(right<length-1 && ary[largest]<ary[right]){
			largest = right;
		}
		if(largest!=index){
			swap(ary,largest,index);
			maxHeapify(ary,largest,length);
		}
		
	}
}
public class HeapSort{
	public static void main(String[] args){
		int[] ary = new int[]{15,78,65,2,14,789,45,11,0,1564,78,1545,35,65,1,448875,24};
		HpSort hps = new HpSort();
		hps.sort(ary);
		for(int i:ary){
			System.out.print(i+",");
		}
	}
}
