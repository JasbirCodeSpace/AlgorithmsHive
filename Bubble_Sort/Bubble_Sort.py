def swap(arr,i,j):
	temp = arr[i]
	arr[i] = arr[j]
	arr[j] = temp
	return

def bubbleSort(arr):
	isSorted = False
	lastUnsorted = len(arr)-1
	while not isSorted:
		isSorted = True
		for i in range(0,lastUnsorted):
			if arr[i] > arr[i+1]:
				swap(arr,i,i+1)
				isSorted = False
		lastUnsorted = lastUnsorted -1
	return

n = int(input())
arr = []

for i in range(0,n):
	arr.append(int(input()))

bubbleSort(arr)
print(arr)


		