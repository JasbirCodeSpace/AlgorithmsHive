const RUN = 32

function insertionSort(arr,left,right){
	
	let j,key
	for (var i = left; i <= right; i++) {
		key = arr[i]
		j = i
		while(j>=left+1 && arr[j-1] > key){
			arr[j] = arr[j-1]
			j--
		}
		arr[j] = key
	}
}

function mergeHalves(arr,temp,leftStart,mid,rightEnd){

	let leftEnd = mid
	let rightStart = leftEnd + 1
	let left = leftStart
	let right = rightStart
	let index = leftStart

	while(left <= leftEnd && right<= rightEnd){
		if (arr[left] <= arr[right]) {
			temp[index] = arr[left]
			left++
		} else {
			temp[index] = arr[right]
			right++
		}
		index++
	}

	copyArray(arr,left,temp,index,leftEnd)
	copyArray(arr,right,temp,index,rightEnd)
	copyArray(temp,leftStart,arr,leftStart,rightEnd)
}

function copyArray(a,aBegin,b,bBegin,size){

	for (let i = aBegin,j = bBegin; i <= size; i++,j++) {
		b[j] = a[i]
	}
}

function timSort(arr){
	let temp = []
	let right,mid

	for (let i = 0; i < arr.length; i+= RUN) {
		insertionSort(arr,i,Math.min(i+RUN-1,arr.length-1))
	}

	for (let size = RUN; size < arr.length; size *= 2) {
		for (let left = 0; left < arr.length; left += 2*size) {
			right = Math.min(left+2*size-1,arr.length-1)
			mid  = left + size -1
			mergeHalves(arr,temp,left,mid,right)
		}
	}
}


let n = 100
let arr = []
for (let i = 0; i < n; i++) {
	arr[i] = n - i
}

timSort(arr)
console.log(arr)