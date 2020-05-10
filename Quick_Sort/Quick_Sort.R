n = as.integer(readline())
arr = c()

for (i in 1:n) {
	arr[i] = as.integer(readline())
}

quickSort<-function(arr,left,right){
  print(arr)
	if(left >= right)
		return(arr)
	listVal = partition(arr,left,right)
	index = listVal$index
	arr = listVal$arr
	arr = quickSort(arr,left,index-1)
	arr = quickSort(arr,index+1,right)
}

partition<-function(arr,left,right){
	pivot = arr[floor((left+right)/2)]
	while(left <= right){
		while(arr[left] < pivot)
			left = left + 1
		while(arr[right] > pivot)
			right = right - 1
		if(left <= right){
			arr[c(left,right)] = arr[c(right,left)]
			left = left + 1
			right = right - 1
		}

	}
	return(list("index"=left,"arr"=arr))
}

printArray<-function(arr){
	output = "["
	for (i in 1:length(arr)) {
		output = paste(output," ",arr[i]," ")
		if(i < length(arr))
			output = paste(output,",")
	}
	output = paste(output,"]")
	print(output)
}
arr = quickSort(arr,1,length(arr))
printArray(arr)
