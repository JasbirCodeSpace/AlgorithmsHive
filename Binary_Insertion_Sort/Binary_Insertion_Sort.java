import java.util.Scanner;

public class Binary_Insertion_Sort{
	static int binarySearch(int[] arr,int h,int item){
		int l = 0;
		int m = 0;
		while(l<h){
			m = (int)Math.floor((l+h)/2);
			if (arr[m] == item) {
				return m+1;
			}else if(arr[m] > item){
				h = m - 1;
			}else if(arr[m] < item){
				l = m + 1;
			}
		}
		return (item > arr[l])?l+1:l;
	}

	static int[] binaryInsertionSort(int[] arr){
		int selected,location,j;
		for (int i=1;i<arr.length ;i++ ) {
			selected = arr[i];
			j = i;
			location = binarySearch(arr,j-1,selected);

			while(j>=1 && j > location){
				arr[j] = arr[j-1];
				j--;
			}
			arr[j] = selected; 
		}
		return arr;
	}

	static void printArray(int[] arr){
		String output = "[";
		for (int i=0;i<arr.length ;i++ ) {
			output+=" "+arr[i]+" ";
			if(i<arr.length-1)output+=",";
		}
		output+="]";

		System.out.println(output);
	}

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		int n = input.nextInt();
		int[] arr = new int[n];

		for (int i=0;i<n;i++ ) {
			arr[i] = input.nextInt();
		}

		arr = binaryInsertionSort(arr);

		printArray(arr);
	}
}