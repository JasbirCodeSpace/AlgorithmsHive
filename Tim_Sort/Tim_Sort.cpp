#include <iostream>
#include <algorithm>
using namespace std;

const int RUN = 32;

void insertionSort(int arr[],int left,int right);
void mergeHalves(int arr[],int temp[],int leftStart,int mid,int rightEnd);
void copyArray(int a[],int aBegin,int b[],int bBegin,int size);
void timSort(int arr[],int n);
void printArray(int arr[],int n);

int main(int argc, char const *argv[])
{
	int n;
	cin >>n;

	int arr[n];

	for (int i = 0; i < n; ++i)
	{
		arr[i] = n-i;
	}

	timSort(arr,n);
	printArray(arr,n);

	return 0;
}

void insertionSort(int arr[],int left,int right){

	int j,key;
	for (int i = left+1; i <=right; ++i)
	{
		j = i;
		key = arr[i];
		while(j>=left+1 && arr[j-1]>key){
			arr[j] = arr[j-1];
			j--;
		}
		arr[j] = key;

	}
	return;
}

void copyArray(int a[],int aBegin,int b[],int bBegin,int size){

	for (int i = aBegin,j=bBegin; i <=size; ++i,++j){
		b[j] = a[i];
	}
	return;
}

void mergeHalves(int arr[],int temp[],int leftStart,int mid,int rightEnd){

	int leftEnd = mid;
	int rightStart = leftEnd+1;
	int left = leftStart;
	int right = rightStart;
	int index = leftStart;

	while(left <= leftEnd && right<=rightEnd){
		if (arr[left] <= arr[right]){
			temp[index] = arr[left];
			left++;
		}else{
			temp[index] = arr[right];
			right++;
		}
		index++;
	}

	copyArray(arr,left,temp,index,leftEnd);
	copyArray(arr,right,temp,index,rightEnd);
	copyArray(temp,leftStart,arr,leftStart,rightEnd);
	return;
}



void timSort(int arr[],int n){

	int right,mid;
	int temp[n] = {};

	for (int i = 0; i < n; i += RUN)
	{
		insertionSort(arr,i,min(i+RUN-1,n-1));
	}

	for (int size = RUN ; size < n; size *= 2)
	{
		for (int left = 0; left < n; left += 2*size)
		{
			right = min(left+2*size-1,n-1);
			mid = left+size-1;
			mergeHalves(arr,temp,left,mid,right);
		}
	}
	return;

}

void printArray(int arr[],int n){
	cout<<"[";
	for (int i = 0; i < n; ++i)
	{
		cout<<" "<<arr[i]<<" ";
		if (i<n-1)
			cout<<",";
	}
	cout<<"]";
}