#include<iostream>
using namespace std;

void swap(int arr[],int i,int j){
	int temp = arr[i];
	arr[i] = arr[j];
	arr[j] = temp;

	return;
}

void bubbleSort(int arr[],int n){
	bool isSorted = false;
	int lastUnsorted = n-1;
	while(!isSorted){
		isSorted = true;
		for (int i = 0; i < lastUnsorted; ++i)
		{
			if(arr[i] > arr[i+1]){
				swap(arr,i,i+1);
				isSorted = false;
			}
		}
		lastUnsorted--;
	} 
	return;
}

void printArray(int arr[],int n){

	cout<<"[";
	for (int i = 0; i < n; ++i)
	{
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

	bubbleSort(arr,n);
	printArray(arr,n);
	return 0;
}