#include<iostream>
#include<string>
using namespace std;

int binarySearch(int arr[],int h,int item){
	int l = 0,m=0;
	while(l<h){
		m = (l+h)/2;
		if (arr[m] == item){
			return m;
		}else if(arr[m] < item){
			l = m + 1;
		}else if(arr[m] > item){
			h = m - 1;
		}
	}
	return (item > arr[l])?l+1:l;
}

void binaryInsertionSort(int arr[],int n){

	int selected = 0,j=0,location=0;
	for (int i = 1; i < n; ++i)
	{
		selected = arr[i];
		j = i;
		location = binarySearch(arr,j-1,selected);
		while(j>=1 && j>location){
			arr[j] = arr[j-1];
			j--;
		}
		arr[j] = selected;
	}

	return;
}

void printArray(int arr[],int n){

	cout<<"[";
	for (int i = 0; i < n; ++i)
	{
		cout<<" "<<arr[i]<<" ";
		if (i<n-1)
		{
		cout<<",";
		}
	}

	cout<<"]";

	return;
}

int main(int argc, char const *argv[])
{
	int n=0;
	cin>>n;
	int arr[n];
	for (int i = 0; i < n; ++i)
	{
		cin>>arr[i];
	}

	binaryInsertionSort(arr,n);
	printArray(arr,n);
	return 0;
}