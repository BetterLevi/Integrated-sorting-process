package acm;
/*基数排序*/
class RadxSort {
	public void RSort(int[] ary){
		int length = ary.length;
		int[][] bucket = new int[length][10];//桶用来存放按位排序的数
		int[] order = new int[10];		//记录一个桶中有多少个元素
		int time = 1;//记录排序次数，即最大数的位数
		int n = 1;
		int k = 0;
		while(time<=maxDigit(ary)){
		
			for(int i:ary){
				int digit = (i/n)%10; //从个位依次往上每位上的数
				bucket[order[digit]][digit] = i;
				order[digit]++;//把桶中的个数加一	
			}
			for(int i=0;i<10;i++){
				if(order[i]!=0){
					for(int j=0;j<order[i];j++){
						ary[k] = bucket[j][i];//把同一个桶中的数据全读出来，即从上往下读
						k++;
					}
				}
				order[i] = 0; //将记录个数清零，用以下一次排序
			}
			n*=10;
			k = 0;
			time++;
		}
	}
	//找出数组中最大数有多少位
	int maxDigit(int[] ary){
		int max=0;
		int n = 1;
		for(int i=0;i<ary.length;i++){
			if(max<ary[i])
				max = ary[i];
		}
		//System.out.println(max);
		while(max/10 != 0){
			max = max/10;
			n++;
			//System.out.println("f");
		}
		return n;
	}

}
public class RadixSort{
	public static void main(String[] args){
		int[] ary = new int[]{87,15,2,47,456,987,4561,5};
		RadxSort RS = new RadxSort();
		RS.RSort(ary);
		System.out.println(RS.maxDigit(ary));
		for(int num:ary){
			System.out.print(num+",");
		}
	}
}
