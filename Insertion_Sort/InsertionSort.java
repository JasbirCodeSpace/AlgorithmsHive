import java.util.Scanner;

public class InsertionSort{

	public static void insertionSort(int[] Arr,int N){

		int key,j;
		for (int i=1;i<N;i++) {
			key = Arr[i];
			j=i;
			while(j>=1 && Arr[j-1] > key){
				Arr[j] = Arr[j-1];
				j--;
			}
			Arr[j] = key;
		}

		return;
	}

	public static void printArray(int[] Arr,int N){
		print("[");
		for (int i=0;i<N;i++) {
			print(" "+Arr[i]+" ");
			if(i<N-1)
				print(",");
		}
		print("]");
		return;
	}

	public static void print(String str){
		System.out.print(str);
	}

	public static void main(String[] args) {
		
		Scanner input = new Scanner(System.in);
		int N = input.nextInt();
		int[] Arr = new int[N];

		for (int i=0;i<N;i++) {
			Arr[i] = input.nextInt();
		}

		insertionSort(Arr,N);
		printArray(Arr,N);
	}
}