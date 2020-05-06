function swap(arr,i,j){
	let temp = arr[i]
	arr[i] = arr[j]
	arr[j] = temp

	return
}

function bubbleSort(arr){

	let isSorted = false
	let lastUnsorted = arr.length-1
	while(!isSorted){
		isSorted = true
		for (var i = 0; i < lastUnsorted; i++) {
			if (arr[i] > arr[i+1]) {
				swap(arr,i,i+1);
				isSorted = false
			}
		}
		lastUnsorted--
	}
	return
}


let arr = [5,4,3,2,1]
bubbleSort(arr)
console.log(arr)