import java.util.Arrays;
public class SumMaxMin{
	public static void main(String[] args){
		int[] arr=new int[args.length];
		int sum=0;
		int min=0;
		int max=0;
		for(int i=0;i<args.length;i++){
			int x=Integer.parseInt(args[i]);
			arr[i]=x;
			sum+=x;
		}
		Arrays.sort(arr);
		min=arr[0];
		max=arr[arr.length-1];
		System.out.println("Sum = "+sum);
		System.out.println("Max = "+max);
		System.out.println("Min = "+min);
		
	}
}