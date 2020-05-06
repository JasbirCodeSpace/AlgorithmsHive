import math

def binarySearch(arr,h,item):
	l = 0
	while l<h:
		m = math.floor((l+h)/2)
		if arr[m] == item:
			return m+1
		elif arr[m] > item:
			h = m - 1
		elif arr[m] < item:
			l = m + 1
	index = (l+1) if (arr[l] < item) else l
	return index

def binaryInsertionSort(arr):

	for i in range(1,len(arr)):
		selected = arr[i]
		j = i
		location = binarySearch(arr,j-1,selected)
		while j>=1 and j > location:
			arr[j] = arr[j-1]
			j = j - 1
		arr[j] = selected


n = int(input())
arr = []

for i in range(0,n):
	arr.append(int(input()))

binaryInsertionSort(arr)
print(arr)
	