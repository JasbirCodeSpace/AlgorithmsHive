def insertionSort(Arr):
	for i in range(1,len(Arr)):
		key = Arr[i]
		j = i
		while j>=1 and Arr[j-1] > key:
			Arr[j] = Arr[j-1]
			j = j - 1
		Arr[j] = key

def printArray(Arr):
	output=[]
	output.append("[")
	for i in range(0,len(Arr)):
		output.append(" "+Arr[i]+" ")
		if i<len(Arr)-1:
			output.append(",")
	output.append("]")
	print(''.join(output))


N = int(input())
Arr = []

for i in range(0,N):
	Arr.append(input())

insertionSort(Arr)
printArray(Arr)



		