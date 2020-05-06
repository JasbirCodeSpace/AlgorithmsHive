function binarySearch(arr,h,item){
	let l = 0
	while(l<h){
		m = Math.floor((l+h)/2)
		if (arr[m] === item){
			return m+1
		}else if(arr[m] > item){
			h = m - 1
		}else if(arr[m] < item){
			hl = m + 1
		}
	}
	return (arr[l] > item)?l:l+1
}

function binaryInsertionSort(arr){
	let selected = 0,j=0,location=0
	for (var i = 1; i < arr.length; i++) {
		selected = arr[i]
		j = i
		location = binarySearch(arr,j-1,selected)
		while(j>=1 && j > location){
			arr[j] = arr[j-1]
			j--
		}
		arr[j] = selected
	}
}

let arr = [5,4,3,2,1]
binaryInsertionSort(arr)
console.log(arr)