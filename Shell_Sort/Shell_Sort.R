n = as.integer(readline())
arr = c()

for (i in 1:n) {
	arr[i] = as.integer(readline())
}

shellSort<-function(arr){

  gap = floor(length(arr)/2)
	while(gap > 0){

		for (i in gap:length(arr)) {

			temp = arr[i]
			j = i

			while(j >= gap && arr[j-gap+1] > temp){
				arr[j] = arr[j - gap + 1]
				j = j - gap + 1
			}
			arr[j] = temp
		}
    gap = floor(gap/2)
	}

	return(arr)
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

arr = shellSort(arr)
printArray(arr)
