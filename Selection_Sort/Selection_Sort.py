def swap(arr,i,j):
	temp = arr[i]
	arr[i] = arr[j]
	arr[j] = temp

def selectionSort(arr):
	min = 0
	for i in range(0,len(arr)-1):
		min = i
		for j in range(i+1,len(arr)):
			if arr[j]<arr[min]:
				min = j
		if min!=i:
			swap(arr,i,min)
	return

n = int(input())
arr = []

for i in range(0,n):
	arr.append(int(input()))

selectionSort(arr)
print(arr)