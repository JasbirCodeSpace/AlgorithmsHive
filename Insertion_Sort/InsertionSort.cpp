#include<iostream>
using namespace std;

// Insertion Sort Method
void insertionSort(int Arr[],int N){

	int key = 0;
	int j=0;
	for (int i = 1; i < N; ++i)
	{
		key = Arr[i];
		j = i;
		 while(j>=1 && Arr[j-1] > key){
		 	Arr[j] = Arr[j-1];
		 	j--;
		 }
		 Arr[j] = key;

	}
	return;
}

void printArray(int Arr[],int N){

	cout<<"[";
	for (int i = 0; i < N; ++i)
	{
		cout<<" "<<Arr[i]<<" ";
		if(i<N-1)cout<<",";
	}
	cout<<"]";
	return;
}

int main(int argc, char const *argv[])
{
	int N;
	cin>>N;
	int Arr[N];
	for (int i = 0; i < N; ++i)
	{
		cin>> Arr[i];
	}
	insertionSort(Arr,N);
	printArray(Arr,N);
	return 0;
}

