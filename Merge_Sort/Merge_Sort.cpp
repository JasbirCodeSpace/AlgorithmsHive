#include<iostream>
#include <algorithm>
using namespace std;

// functions declarations
void mergeSort(int arr[],int n);
void mergeSort(int arr[],int temp[],int leftStart,int rightEnd);
void mergeHalves(int arr[],int temp[],int leftStart,int rightEnd);
void copyArray(int a[],int aBegin,int b[],int bBegin,int size);
void printArray(int arr[],int n);

int main(int argc, char const *argv[])
{
	int n=0;
	cin>>n;
	int arr[n];
	for (int i = 0; i < n; ++i)
	{
		cin>>arr[i];
	}

	mergeSort(arr,n);
	printArray(arr,n);
	return 0;
}


// functions definitions 

void mergeSort(int arr[],int n){
	int temp[n] = {};
	mergeSort(arr,temp,0,n-1);
}

void mergeSort(int arr[],int temp[],int leftStart,int rightEnd){
	if (leftStart >= rightEnd)
		return;

	int middle = (leftStart+rightEnd)/2;

	mergeSort(arr,temp,leftStart,middle);
	mergeSort(arr,temp,middle+1,rightEnd);
	mergeHalves(arr,temp,leftStart,rightEnd);
}

void mergeHalves(int arr[],int temp[],int leftStart,int rightEnd){

	int leftEnd = (leftStart+rightEnd)/2;
	int rightStart = leftEnd+1;
	int size = rightEnd - leftStart + 1;

	int left = leftStart;
	int right = rightStart;
	int index = left;

	while(left<=leftEnd && right<=rightEnd){
		if (arr[left] <= arr[right]){
			temp[index] = arr[left];
			left++;
		}else{
			temp[index] = arr[right];
			right++;
		}
		index++;
	}

	// copy(arr+left,arr+left+(leftEnd-left+1),temp+index);
	// copy(arr+right,arr+right+(rightEnd-right+1),temp+index);
	// copy(temp+leftStart,temp+size,arr+leftStart);

	copyArray(arr,left,temp,index,leftEnd-left+1);
	copyArray(arr,right,temp,index,rightEnd-right+1);
	copyArray(temp,leftStart,arr,leftStart,size);
	return;
}

void copyArray(int a[],int aBegin,int b[],int bBegin,int size){

	for (int i = aBegin; i <= size; ++i)
	{
		b[bBegin] = a[i];
		bBegin++;
	}
	return;
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
