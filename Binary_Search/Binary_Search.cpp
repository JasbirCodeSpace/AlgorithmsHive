#include<iostream>
using namespace std;


int binarySearch(int Arr[],int n,int item){
	int l = 0;
	int h = n-1;
	int m = 0;
	while(l<=h){
		m = l + (h-l)/2;
		if (Arr[m] == item){
			return m;

		}else if(Arr[m] < item){
			l = m + 1;
		}else if(Arr[m] > item){
			h = m - 1;
		}
	}

	return -1;
}
int main(int argc, char const *argv[])
{
	int n;
	cin>>n;
	int Arr[n];
	for (int i = 0; i < n; ++i)
	{
		cin>>Arr[i];
	}

	int item;
	cin>>item;
	int index = binarySearch(Arr,n,item);
	cout<<index;
	return 0;
}