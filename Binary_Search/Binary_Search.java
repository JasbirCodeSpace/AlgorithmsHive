import java.util.Scanner;

public class Binary_Search{

	static int binarySearch(int[] Arr, int item){
		int l = 0;
		int h = Arr.length-1;
		int m = 0;
		while(l<=h){
			m = (int)Math.floor((l+h)/2);
			if(Arr[m] == item){
				return m;
			}
			if(Arr[m] < item){
				l = m + 1;
			}else if(Arr[m] > item){
				h = m - 1;
			}
		}
		return -1;
	}
	public static void main(String[] args) {
		
		Scanner input = new Scanner(System.in);
		int n = input.nextInt();
		int[] Arr = new int[n];

		for (int i=0; i<n ; i++) {
			Arr[i] = input.nextInt();
		}

		int item = input.nextInt();
		int index = binarySearch(Arr,item);
		System.out.println(index);
	}
}