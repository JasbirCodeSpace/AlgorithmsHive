def shellSort(arr):
	gap = int(len(arr)/2)
	while(gap > 0):
		for i in range(gap,len(arr)):
			temp = arr[i]
			j = i
			while j>=gap and arr[j-gap] > temp:
				arr[j] = arr[j - gap]
				j = j - gap

			arr[j] = temp
			
		gap = int(gap/2)
	return

n = int(input())
arr = []

for i in range(0,n):
	arr.append(int(input()))

shellSort(arr)
print(arr)