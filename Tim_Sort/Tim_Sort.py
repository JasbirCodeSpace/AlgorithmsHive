RUN = 32

def insertionSort(arr,left,right):
	for i in range(left+1,right+1):
		j = i
		key = arr[i]
		while j>= left+1 and arr[j-1] > key:
			arr[j] = arr[j-1]
			j = j-1
		arr[j] = key

def mergeHalves(arr,temp,leftStart,middle,rightEnd):
	leftEnd = middle
	rightStart = leftEnd + 1
	index = leftStart

	left = leftStart
	right = rightStart

	while left<= leftEnd and right<=rightEnd:
		if arr[left] <= arr[right]:
			temp[index] = arr[left]
			left = left + 1
		else:
			temp[index] = arr[right]
			right = right + 1
		index = index + 1

	copyArray(arr,left,temp,index,leftEnd)
	copyArray(arr,right,temp,index,rightEnd)
	copyArray(temp,leftStart,arr,leftStart,rightEnd)

def copyArray(a,aBegin,b,bBegin,size):
	for i in range(aBegin,size+1):
		b[bBegin] = a[i]
		bBegin = bBegin + 1

def timSort(arr):
	temp = [0]*len(arr)
	for i in range(0,len(arr),RUN):
		insertionSort(arr,i,min(i+RUN-1,len(arr)-1))

	size = RUN
	while size<len(arr):
		left = 0
		while left<len(arr):
			right = min(left+2*size-1,len(arr)-1)
			mid = left + size - 1
			mergeHalves(arr,temp,left,mid,right)
			left += size*2
		size *= 2

n = int(input())
arr = [0]*n

for i in range(0,n):
	arr[i] = n - i

timSort(arr)
print(arr)

