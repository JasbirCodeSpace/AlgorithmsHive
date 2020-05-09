import java.util.Scanner;

public class Shell_Sort{

	public static void shellSort(int[] arr){

		int temp,j;

		for (int gap = arr.length/2; gap > 0; gap /=2) {
			for (int i=gap; i<arr.length; i++) {

				temp = arr[i];

				for (j=i; j>= gap && arr[j-gap]>temp; j-=gap) {
					arr[j] = arr[j-gap];
				}
				arr[j] = temp;
			}
		}

		return;
	}

	public static void printArray(int[] arr){

		String output = "[";
		for (int i=0; i< arr.length; ++i) {
			output += " "+arr[i]+" ";
			if(i < arr.length - 1)
				output += ",";
		}
		output += "]";

		System.out.println(output);
	}

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);

		int n = input.nextInt();
		int[] arr = new int[n];

		for (int i=0; i< n ; ++i) {
			arr[i] = input.nextInt();
		}

		shellSort(arr);
		printArray(arr);
	}

}