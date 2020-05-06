import java.util.Scanner;

public class Bubble_Sort{

	public static void swap(int[] arr, int i, int j){
		int temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
	}

	public static void bubbleSort(int[] arr){

		boolean isSorted = false;
		int lastUnsorted = arr.length-1;
		while(!isSorted){
			isSorted = true;
			for (int i=0;i<lastUnsorted;i++ ) {
				if(arr[i] > arr[i+1]){
					swap(arr,i,i+1);
					isSorted = false;
				}
			}
			lastUnsorted--;
		}

		return;

	}

	public static void printArray(int[] arr){
		String output = "[";
		for (int i=0;i<arr.length;i++) {
			output += " "+arr[i]+" ";
			if(i<arr.length-1){
				output +=",";
			}
		}
		output +="]";
		System.out.println(output);
		return;
	}

	public static void main(String[] args) {
		
		Scanner input = new Scanner(System.in);
		int n = input.nextInt();
		int[] arr = new int[n];

		for (int i=0;i<n ;i++ ) {
			arr[i] = input.nextInt();
		}
		bubbleSort(arr);
		printArray(arr);
	}
}