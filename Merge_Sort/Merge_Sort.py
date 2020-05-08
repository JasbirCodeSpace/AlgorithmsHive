def mergeSort(arr):
	temp = [0]*len(arr)
	divide(arr,temp,0,len(arr)-1)
	del temp

def divide(arr,temp,leftStart,rightEnd):
	if leftStart>=rightEnd:
		return
	middle = int((leftStart + rightEnd)/2)

	divide(arr,temp,leftStart,middle)
	divide(arr,temp,middle+1,rightEnd)
	mergeHalves(arr,temp,leftStart,rightEnd)

def mergeHalves(arr,temp,leftStart,rightEnd):
	leftEnd = int((leftStart + rightEnd)/2)
	rightStart = leftEnd + 1

	size = rightEnd - leftStart + 1
	left = leftStart
	right = rightStart
	index = leftStart

	while left<=leftEnd and right<=rightEnd:
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



n = int(input())
arr = []

for i in range(0,n):
	arr.append(int(input()))

mergeSort(arr)
print(arr)

