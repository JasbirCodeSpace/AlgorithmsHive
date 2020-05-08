function mergeSort(arr){
	let temp = new Array()
	divide(arr,temp,0,arr.length-1)
}

function divide(arr,temp,leftStart,rightEnd){
	if (leftStart >= rightEnd) {
		return
	}

	let middle = Math.floor((leftStart+rightEnd)/2)
	divide(arr,temp,leftStart,middle)
	divide(arr,temp,middle+1,rightEnd)
	mergeHalves(arr,temp,leftStart,rightEnd)
}

function mergeHalves(arr,temp,leftStart,rightEnd){

	let leftEnd = Math.floor((leftStart+rightEnd)/2)
	let rightStart = leftEnd + 1
	let size = rightEnd - leftStart + 1

	let index = leftStart
	let left = leftStart
	let right = rightStart

	while(left<=leftEnd && right<=rightEnd){
		if (arr[left] <= arr[right]) {
			temp[index] = arr[left]
			left++
		}else{
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

	for (let i = aBegin,j=bBegin; i <=size; i++,j++) {
		b[j] = a[i]
	}
}

let arr = [10,9,8,7,6,5,4,3,2,1]
mergeSort(arr)
console.log(arr)