package acm;
/*ºÚµ•—°‘Ò≈≈–Ú*/
public class SimpleSelectSort {
	public static void main(String[] args){
		int[] ary = new int[]{42,15,36,85,28,41,97,4};
		int temp;
		for(int i=0;i<ary.length-1;i++){
			for(int j=i+1;j<ary.length;j++){
				if(ary[i]>ary[j]){
					temp = ary[i];
					ary[i] = ary[j];
					ary[j] = temp;
				}
			}
		}
		for(int i=0;i<ary.length;i++)
			System.out.print(ary[i]+",");
		
	}
}
