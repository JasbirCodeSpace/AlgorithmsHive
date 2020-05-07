import java.util.Scanner;

public class Selection_Sort{

	static void swap(int[] arr,int i,int j){
		int temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;

		return;
	}

	static void selectionSort(int[] arr){

		int min =0;
		for (int i=0; i<arr.length-1; i++) {
			min = i;
			for (int j=i+1; j<arr.length; j++) {
				if (arr[j]  < arr[min]) {
					min = j;
				}
			}
			if(i!=min){
				swap(arr,i,min);
			}
		}
		return;

	}
	static void printArray(int[] arr){
		String output = "[";

		for (int i=0; i<arr.length; i++) {
			output += " "+arr[i]+" ";
			if (i<arr.length-1) {
				output += ",";
			}
		}

		output += "]";

		System.out.println(output);
		return;

	}
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		int n = input.nextInt();

		int[] arr = new int[n];
		for (int i=0; i<n ; i++) {
			arr[i] = input.nextInt();
		}

		selectionSort(arr);
		printArray(arr);
		
	}
}