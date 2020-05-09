#include<iostream>
using namespace std;

void shellSort(int arr[],int n){

	int temp,i,j;
	for (int gap = n/2 ; gap > 0; gap = gap/2){
		for (i = gap; i < n; ++i){
			temp = arr[i];
			for (j = i; j>=gap && arr[j-gap] > temp; j = j - gap){
				arr[j] = arr[j-gap];
			}
			arr[j] = temp;
		}
	}

	return;
}

	void printArray(int arr[],int n){

	cout<<"[";
	for (int i = 0; i < n; ++i){
		cout<<" "<<arr[i]<<" ";
		if(i<n-1)
			cout<<",";
	}
	cout<<"]";
	return;
}

int main(int argc, char const *argv[]){
	int n;
	cin>>n;
	int arr[n];

	for (int i = 0; i < n; ++i){
		cin>>arr[i];
	}

	shellSort(arr,n);
	printArray(arr,n);
	return 0;
}