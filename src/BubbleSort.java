package acm;
/*ц╟ещеепР*/
public class BubbleSort {
	public static void main(String[] args){
		int[] ary = new int[]{45,12,48,14,69,32,74,0};
		int temp;
		for(int i=0;i<ary.length;i++){
			for(int j=1;j<ary.length-i;j++){
				if(ary[j-1]>ary[j]){
					temp = ary[j];
					ary[j] = ary[j-1];
					ary[j-1] = temp;
				}
			}
		}
		for(int i=0;i<ary.length;i++){
			System.out.print(ary[i]+",");
		}
	}
}
