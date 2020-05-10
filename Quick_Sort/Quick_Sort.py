def quickSort(arr,left,right):
	if left >= right:
		return
	index = partition(arr,left,right)
	quickSort(arr,left,index-1)
	quickSort(arr,index+1,right)

def partition(arr,left,right):
	pivot = arr[int((left+right)/2)]
	while left <= right:
		while arr[left] < pivot:
			left += 1
		while arr[right] > pivot:
			right -= 1
		if left<=right:
			arr[left],arr[right] = arr[right],arr[left]
			left += 1
			right -= 1
	return left

n = int(input())
arr = []

for i in range(0,n):
	arr.append(int(input()))

quickSort(arr,0,len(arr)-1)
print(arr)
