function swap(arr,i,j){

	let temp = arr[i]
	arr[i] = arr[j]
	arr[j] = temp
	return;
}

function selectionSort(arr){

	let min = 0
	for (let i = 0; i < arr.length-1; i++) {
		min = i
		for (let j = i+1; j < arr.length; j++) {
			if (arr[j] < arr[min]) {
				min = j
			}
		}
		if (min !== i) {
			swap(arr,min,i)
		}
	}
	return;
}

let arr = [5,4,3,2,1]
selectionSort(arr)

console.log(arr)