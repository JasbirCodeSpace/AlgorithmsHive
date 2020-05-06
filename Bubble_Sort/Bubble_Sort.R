n = as.integer(readline())
arr = c()

for (i in 1:n) {
	arr[i] = as.integer(readline())
}


bubbleSort<-function(arr){
	isSorted = FALSE
	lastUnsorted = length(arr)-1
	while(!isSorted){
		isSorted = TRUE
		if(lastUnsorted>0){
		for (i in 1:lastUnsorted) {
		  cat(arr[i],arr[i+1],i,i+1,"\n")
			if(arr[i] > arr[i+1]){
				arr[c(i,i+1)] = arr[c(i+1,i)]
				isSorted = FALSE
			}
		}
		lastUnsorted = lastUnsorted - 1
		}
	}

	return(arr)

}

printArray<-function(arr){
	output = "["
	for (i in 1:length(arr)) {
		output = paste(output," ",arr[i]," ")
		if(i<length(arr))
			output = paste(output,",")
	}
	output = paste(output,"]")

	print(output)
}

arr = bubbleSort(arr)
printArray(arr)
