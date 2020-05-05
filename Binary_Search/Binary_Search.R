N = as.integer(readline())
Arr = c()

for (i in 1:N){
	Arr[i] = as.integer(readline())
}

item = as.integer(readline())

binarySearch<-function(Arr,item){
	l = 1;
	h = length(Arr)
	while(l<=h){
		m = floor((l+h)/2)
		if(Arr[m] == item){
			return(m);
		}else if(Arr[m] < item){
		  l = m + 1;
		}else if(Arr[m] > item){
		  h = m - 1;
		}
	}
	
	return(-1);
}

index = binarySearch(Arr,item)
print(index)
