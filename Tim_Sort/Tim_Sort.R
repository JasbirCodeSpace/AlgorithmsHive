n = as.integer(readline())
arr = c()
RUN = 32

for (i in 1:n) {
  arr[i] = n - i
}

insertionSort<-function(arr,left,right){
  for (i in (left+1):right) {
    j = i
    key = arr[i]
    while (j>=left+1 && arr[j-1] > key) {
      arr[j] = arr[j-1]
      j = j - 1
    }
    arr[j] = key
  }
  
  return(arr)
}

mergeHalves<-function(arr,temp,leftStart,middle,rightEnd){
  leftEnd = middle
  rightStart = leftEnd + 1
  left = leftStart
  right = rightStart
  index = leftStart
  
  while (left<=leftEnd && right<=rightEnd) {
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
  
  return(arr)
  
}

copyArray<-function(a,aBegin,b,bBegin,size){

  i = aBegin
  while(i <= size){
    b[bBegin] = a[i]
    bBegin = bBegin + 1
    i = i+1
  }
  
  return(b)
}

timSort<-function(arr){
  temp = rep(0,length(arr))
  i = 1
  while(i <= length(arr)){
    arr = insertionSort(arr,i,min(i+RUN,length(arr)))
    i = i+RUN
  }
  
  size = RUN
  while (size <= length(arr)) {
    left = 1
    while(left <= length(arr)){
      right = min(left+2*size,length(arr))
      middle = left + size - 1
      arr = mergeHalves(arr,temp,left,middle,right)
      left = left + 2 * size
    }
    size = size * 2
  }
  
  return(arr)
}

printArray<- function(arr){
  
  output = "["
  for (i in 1:length(arr)) {
    output = paste(output," ",arr[i]," ")
    if(i < length(arr)){
      output = paste(output,",")
    }
  }
  output = paste(output,"]")
  print(output)
}

arr = timSort(arr)
printArray(arr)





