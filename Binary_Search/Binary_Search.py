import math

def binarySearch(Arr,item):
	l = 0
	h = len(Arr) - 1
	while l<=h:
		m = math.floor((l+h)/2)
		if Arr[m] == item:
			return m
		elif Arr[m] < item:
			l = m + 1 
		elif Arr[m] > item:
			h = m - 1
	return -1

N  = int(input())
Arr = []
for i in range(0,N):
	Arr.append(int(input()))

item = int(input())

index = binarySearch(Arr,item)
print(index)
	