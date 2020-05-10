#include<iostream>
using namespace std;

void quickSort(int arr[],int n);
void quickSort(int arr[],int left,int right);
int partition(int arr[],int left,int right);
void swap(int arr[],int i,int j);
void printArray(int arr[],int n);

int main(int argc, char const *argv[])
{
	int n;
	cin>>n;

	int arr[n];
	for (int i = 0; i < n; ++i)
	{
		cin>>arr[i];
	}

	quickSort(arr,n);
	printArray(arr,n);
	return 0;
}


void quickSort(int arr[],int n){
	quickSort(arr,0,n-1);
}

void quickSort(int arr[],int left,int right){
	if(left >= right)
		return;
	int index = partition(arr,left,right);
	quickSort(arr,left,index-1);
	quickSort(arr,index,right);

}

int partition(int arr[],int left,int right){

	int pivot = arr[(left+right)/2];
	while(left <= right){

		while(arr[left] < pivot)
			left++;
		while(arr[right] > pivot)
			right--;
		if (left <= right){
			swap(arr,left,right);
			left++;
			right--;
		}
	}

	return left;
}

void swap(int arr[],int i,int j){
	int temp = arr[i];
	arr[i] = arr[j];
	arr[j] = temp;
}

void printArray(int arr[],int n){
	cout<<"[";
	for (int i = 0; i < n; ++i)
	{
		cout<<" "<<arr[i]<<" ";
		if(i<n-1)
			cout<<",";
	}
	cout<<"]";

	return;
}