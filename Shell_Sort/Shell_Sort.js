function shellSort(arr) {
	
	let temp,j

	for (let gap = Math.floor(arr.length/2); gap > 0; gap = Math.floor(gap/2)) {
		for (let i = gap; i < arr.length; i++) {
			
			temp = arr[i]
			for (j = i; j >=gap && arr[j-gap] > temp; j-=gap) {
				arr[j] = arr[j-gap]
			}
			arr[j] = temp
		}
	}
}

let arr = [10,9,8,7,6,5,4,3,2,1]
shellSort(arr)
console.log(arr)