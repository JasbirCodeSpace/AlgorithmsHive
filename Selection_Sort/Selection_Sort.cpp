#include <iostream>
using namespace std;

void swap(int arr[],int i,int j){
	int temp = arr[i];
	arr[i] = arr[j];
	arr[j] = temp;

	return;

}

void selectionSort(int arr[],int n){
	int min = 0;
	for (int i = 0; i < n-1; ++i)
	{
		min = i;
		for (int j = i+1; j < n; ++j)
		{
			if(arr[j] < arr[min]){
				min = j;
			}
		}
		if (min != i){
			swap(arr,min,i);
		}
	}

	return;

}

void printArray(int arr[],int n){
	cout<<"[";
	for (int i = 0; i < n; ++i){
		cout<<" "<<arr[i]<<" ";
		if (i<n-1){
			cout<<",";
		}
	}
	cout<<"]";

	return;
}

int main(int argc, char const *argv[])
{
	int n;
	cin>>n;
	int arr[n];
	for (int i = 0; i < n; ++i)
	{
		cin>>arr[i];
	}
	selectionSort(arr,n);
	printArray(arr,n);
	return 0;
}