#include <iostream>
#include <algorithm>
using namespace std;

const int RUN = 32;

void timSort(int arr[],int n){

	for (int i = 0; i < n; i += RUN)
	{
		insertionSort(arr,i,min((i+31),n-1))
	}

	for (int size = RUN ; size < n; size *= 2)
	{
		for (int left = 0; left < n; left += 2*size)
		{
			mergeSort();
		}
	}

}

int main(int argc, char const *argv[])
{
	int n;
	cin >>n;

	int arr[n];

	for (int i = 0; i < n; ++i)
	{
		cin>>arr[i];
	}

	timSort(arr,n);
	printArray(arr,n);

	return 0;
}