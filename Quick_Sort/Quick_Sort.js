function quickSort(arr,left,right) {
	if (left >= right)
		return
	let index = partition(arr,left,right)
	quickSort(arr,left,index-1)
	quickSort(arr,index+1,right)
}

function partition(arr,left,right){
	let pivot = arr[Math.floor((left+right)/2)]

	while(left <= right){
		while(arr[left] < pivot)
			left++
		while(arr[right] > pivot)
			right --
		if (left <= right) {
			swap(arr,left,right)
			left++
			right--
		}
	}
	return left
}

function swap(arr,i,j){
	let temp = arr[i]
	arr[i] = arr[j]
	arr[j] = temp
}

let arr = [10,9,8,7,6,5,4,3,2,1]
quickSort(arr,0,arr.length-1)
console.log(arr)