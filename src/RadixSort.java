package acm;
/*��������*/
class RadxSort {
	public void RSort(int[] ary){
		int length = ary.length;
		int[][] bucket = new int[length][10];//Ͱ������Ű�λ�������
		int[] order = new int[10];		//��¼һ��Ͱ���ж��ٸ�Ԫ��
		int time = 1;//��¼������������������λ��
		int n = 1;
		int k = 0;
		while(time<=maxDigit(ary)){
		
			for(int i:ary){
				int digit = (i/n)%10; //�Ӹ�λ��������ÿλ�ϵ���
				bucket[order[digit]][digit] = i;
				order[digit]++;//��Ͱ�еĸ�����һ	
			}
			for(int i=0;i<10;i++){
				if(order[i]!=0){
					for(int j=0;j<order[i];j++){
						ary[k] = bucket[j][i];//��ͬһ��Ͱ�е�����ȫ�����������������¶�
						k++;
					}
				}
				order[i] = 0; //����¼�������㣬������һ������
			}
			n*=10;
			k = 0;
			time++;
		}
	}
	//�ҳ�������������ж���λ
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
