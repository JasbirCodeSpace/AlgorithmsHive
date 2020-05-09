n = as.integer(readline())
arr = c()

for (i in 1:n) {
	arr[i] = as.integer(readline())
}

mergeSort<-function(arr){
	temp = rep(0,length(arr))
	arr = divide(arr,temp,1,length(arr))
	return(arr)
}

divide<-function(arr,temp,leftStart,rightEnd){

	if(leftStart >= rightEnd)
		return(arr);

	middle = floor((leftStart + rightEnd)/2)
	arr = divide(arr,temp,leftStart,middle)
	arr = divide(arr,temp,middle+1,rightEnd)
	mergeHalves(arr,temp,leftStart,rightEnd)
}

mergeHalves<-function(arr,temp,leftStart,rightEnd){

	leftEnd = floor((leftStart + rightEnd)/2)
	rightStart = leftEnd + 1
	size = rightEnd - leftStart + 1

	left = leftStart
	right = rightStart
	index = leftStart

	while(left<=leftEnd && right<=rightEnd){
		if(arr[left] <= arr[right]){
			temp[index] = arr[left]
			left = left + 1
		}else{
			temp[index] = arr[right]
			right = right + 1
		}
		index = index + 1

	}
	if(left<=leftEnd){
    temp = copyArray(arr,left,temp,index,leftEnd)
	}else{
    temp = copyArray(arr,right,temp,index,rightEnd)
	}
    arr = copyArray(temp,leftStart,arr,leftStart,rightEnd)

}

copyArray<-function(a,aBegin,b,bBegin,size){
  for (i in aBegin:size) {
    b[bBegin] = a[i]
    bBegin = bBegin + 1
  }
  return(b)
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

arr = mergeSort(arr)
printArray(arr)
