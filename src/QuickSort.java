package acm;
/*��������
 *1>.ѡ��һ����׼Ԫ�أ�ͨ��ѡ���һ��Ԫ�ػ������һ��Ԫ��
 *2>.ͨ��һ�����򽫴�����ļ�¼�ָ�ɶ����������֣�����һ���ּ�¼��Ԫ�ض��Ȼ�׼Ԫ��С����һ���ּ�¼��Ԫ�ض��Ȼ�׼Ԫ�ش�
 *3>.��ʱ�Ļ�׼Ԫ�������ź������ȷλ��
 *4>.Ȼ��ֱ���ͬ���ķ������������ֽ�������ֱ��������������
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
		//�ú�����������ֱ������һ�����鼴�ɷ���������
		quickSort(array,0,(array.length-1));
	} 
	//���õݹ�˼���������
	static void quickSort(int[] ary,int low,int high){
		if(low<high){
			int segment = partition(ary,low,high);
			quickSort(ary,low,segment-1);
			quickSort(ary,segment+1,high);
		}	
	}	
	//�ҵ��ָ�Ԫ�����յ�λ��
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

