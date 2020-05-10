import java.util.Scanner;

public class Quick_Sort{

	public static void quickSort(int[] arr){
		quickSort(arr,0,arr.length-1);
	}

	public static void quickSort(int[] arr,int left,int right){
		if(left >= right)
			return;
		int index = partition(arr,left,right);
		quickSort(arr,left,index-1);
		quickSort(arr,index+1,right);
	}

	public static int partition(int[] arr,int left,int right){
		int pivot = arr[(left+right)/2];
		while(left <= right){
			while(arr[left] < pivot)
				left++;
			while(arr[right] > pivot)
				right--;
			if (left <= right) {
				swap(arr,left,right);
				left++;
				right--;
			}
		}
		return left;
	}

	public static void swap(int[] arr,int i,int j){
		int temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
	}

	public static void printArray(int[] arr){
		String output = "[";
		for (int i=0; i<arr.length ;i++ ) {
			output += " "+arr[i]+" ";
			if(i < arr.length-1)
				output += ",";
		}
		output +="]";
		System.out.println(output);
	}
	public static void main(String[] args) {

		Scanner input = new Scanner(System.in);
		int n = input.nextInt();
		int[] arr = new int[n];

		for (int i=0; i<n ; i++) {
			arr[i] = input.nextInt();
		}

		quickSort(arr);
		printArray(arr);
		
	}
}