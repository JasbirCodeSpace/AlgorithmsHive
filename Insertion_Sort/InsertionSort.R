N = as.integer(readline())
Arr = c()

for (i in 1:N) {
  Arr[i] = as.integer(readline())
}

insertionSort<-function(Arr){
  for (i in 2:length(Arr)) {
    key = Arr[i]
    j = i
    while(j>=2 && Arr[j-1]>key){
      Arr[j] = Arr[j-1]
      j = j - 1
    }
    Arr[j] = key
    
  }
  
  return(Arr);
}

printArray<-function(Arr){
  output = "["
  for (i in 1:length(Arr)) {
    output = paste(output," ",Arr[i]," ")
    if(i<length(Arr)){output = paste(output,",")}
  }
  output = paste(output,"]")
  print(output)
}

Arr = insertionSort(Arr)
printArray(Arr)


