package acm;
/*希尔排序
 * 2017.11.22
 * 希尔排序算法减小数据项的间隔再进行排序，依次进行下去，进行这些排序时的数据项之间的间隔被称为增量，习惯上用字母h来表示这个增量。
 * 常用的h序列由Knuth提出，该序列从1开始，通过如下公式产生：h = 3 * h +1
*/
class ShelSot {
	static void shellSort(int[] ary){
		int h = 1;
		//计算h可取的最大值
		while(h <= ary.length/3){
			h = 3*h+1;
		}		
		while(h>0){
			for(int i=h;i<ary.length;i+=h){
				if(ary[i]<ary[i-h]){
					int temp = ary[i];
					int j = i-h;
					while(j>=0 && ary[j]>temp){
						ary[j+h] = ary[j];
						j-=h;
					}
					ary[j+h] = temp;
					/*for(int ele:ary){
						System.out.print(ele+",");
					}
					System.out.println("");//换行
					*/
				}	
			}
			h = (h-1)/3;
		}
		
	}

	

}
public class ShellSort{
	
	public static void main(String[] args){
		ShelSot ssot = new ShelSot();
		int[] ary = new int[]{49,38,65,97,76,13,27,49,55,4};
		ssot.shellSort(ary);
		for(int ele:ary){
			System.out.print(ele+",");
			}
	}
}
