n = as.integer(readline())
arr = c()

for (i in 1:n) {
	arr[i] = as.integer(readline())
}

selectionSort<-function(arr){
	for (i in 1:(length(arr)-1)) {
		min = i
		for (j in (i+1):length(arr)) {
			if(arr[j] < arr[min]){
				min = j
			}
		}
		if(min != i){
			arr[c(min,i)] = arr[c(i,min)]
		}
	}

	return(arr);
}

printArray<-function(arr){

	output = "[";
	for (i in 1:length(arr)) {
		output = paste(output," ",arr[i]," ")
		if(i<length(arr)-1)
			output = paste(output,",")
	}
	output = paste(output,"]")

	print(output)
}

arr = selectionSort(arr)
printArray(arr)
