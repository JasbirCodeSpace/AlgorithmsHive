import java.util.Scanner;

public class Tim_Sort{

	private static final int RUN = 32;

	public static void insertionSort(int[] arr,int left,int right){
		int key,j;
		for (int i=left+1;i<arr.length; i++) {
			key = arr[i];
			j = i;
			while(j>=left+1 && arr[j-1] > key){
				arr[j] = arr[j-1];
				j--;
			}
			arr[j] = key;
		}
	}

	public static void mergeHalves(int[] arr,int[] temp,int leftStart,int mid,int rightEnd){

		int leftEnd = mid;
		int rightStart = leftEnd+1;
		int left = leftStart;
		int right = rightStart;
		int index = leftStart;
		int size = rightEnd - leftStart + 1;

		while(left<=leftEnd && right<=rightEnd){
			if(arr[left] <= arr[right]){
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

	}

	public static void timSort(int[] arr){

		int[] temp = new int[arr.length];
		int right,mid;

		for (int i=0; i<arr.length ; i+=RUN) {
			insertionSort(arr,i,Math.min((i+RUN-1),(arr.length-1)));
		}

		for (int size = RUN; size < arr.length ; size *= 2) {
			for (int left = 0; left<arr.length ; left+=2*size) {
				
				right = Math.min((left + 2*size -1),(arr.length-1));
				mid = left + size - 1;
				mergeHalves(arr,temp,left,mid,right);
			}
			
		}
	}

	public static void printArray(int[] arr){

		String output = "[";
		for (int i=0; i<arr.length ; i++) {
			output += " "+arr[i]+" ";
			if (i<arr.length-1) {
				output +=",";
			}
		}
		output +="]";

		System.out.println(output);

	}
	public static void main(String[] args) {
		
		int n;
		Scanner input = new Scanner(System.in);
		n = input.nextInt();

		int[] arr = new int[n];

		for (int i=0; i<n; i++) {
			arr[i] = n-i;
		}

		timSort(arr);
		printArray(arr);
	}
}