n = as.integer(readline())
arr = c()

for (i in 1:n) {
	arr[i] = as.integer(readline())
}

binarySearch<-function(arr,h,item){
	l = 1
	while(l<h){
		m = floor((l+h)/2)
		if(arr[m] == item){
			return(m+1)
		}else if(arr[m] > item){
			h = m - 1
		}else if(arr[m] < item){
			l = m + 1
		}
	}

	return(ifelse(arr[l]<item,l+1,l))
}

binaryInsertionSort<-function(arr){

	for (i in 2:length(arr)) {
		selected = arr[i]
		j = i
		location = binarySearch(arr,j-1,selected)
		while(j>=2 && j > location){
			arr[j] = arr[j-1]
			j = j - 1
		}
		arr[j] = selected
	}
  
  return(arr)
}

printArray<-function(arr){
	output = "["

	for (i in 1:length(arr)) {
		output = paste(output," ",arr[i]," ")
		if(i<length(arr)){
			output = paste(output,",")
		}
	}
	output = paste(output,"]")

	print(output)
}

arr = binaryInsertionSort(arr)
printArray(arr)
