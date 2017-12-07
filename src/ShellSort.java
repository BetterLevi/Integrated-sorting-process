package acm;
/*ϣ������
 * 2017.11.22
 * ϣ�������㷨��С������ļ���ٽ����������ν�����ȥ��������Щ����ʱ��������֮��ļ������Ϊ������ϰ��������ĸh����ʾ���������
 * ���õ�h������Knuth����������д�1��ʼ��ͨ�����¹�ʽ������h = 3 * h +1
*/
class ShelSot {
	static void shellSort(int[] ary){
		int h = 1;
		//����h��ȡ�����ֵ
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
					System.out.println("");//����
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
