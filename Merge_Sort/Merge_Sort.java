import java.util.Scanner;

public class Merge_Sort{

	public static void mergeSort(int[] arr){

		mergeSort(arr,new int[arr.length],0,arr.length-1);
	}
	public static void mergeSort(int[] arr,int[] temp,int leftStart,int rightEnd){
		if(leftStart >= rightEnd)
			return;
		int middle = (leftStart+rightEnd)/2;
		mergeSort(arr,temp,leftStart,middle);
		mergeSort(arr,temp,middle+1,rightEnd);
		mergeHalves(arr,temp,leftStart,rightEnd);
	}

	public static void mergeHalves(int[] arr,int[] temp,int leftStart,int rightEnd){

		int leftEnd = (leftStart+rightEnd)/2;
		int rightStart = leftEnd+1;

		int left = leftStart;
		int right = rightStart;
		int index = left;
		int size = rightEnd-leftStart+1;

		while(left<=leftEnd && right<=rightEnd){
			if (arr[left] <= arr[right]) {
				temp[index] = arr[left];
				left++;
			}else{
				temp[index] = arr[right];
				right++;
			}
			index++;
		}

		System.arraycopy(arr,left,temp,index,leftEnd-left+1);
		System.arraycopy(arr,right,temp,index,rightEnd-right+1);
		System.arraycopy(temp,leftStart,arr,leftStart,size);

		return;
	}

	public static void printArray(int[] arr){

		String output = "[";
		for (int i=0; i<arr.length ; i++) {
			output +=" "+arr[i]+" ";
			if(i<arr.length-1)
				output +=",";
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

		mergeSort(arr);
		printArray(arr);

		return;

	}
}