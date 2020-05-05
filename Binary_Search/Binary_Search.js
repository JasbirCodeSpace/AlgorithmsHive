function binarySearch(Arr,item){

	let l = 0;
	let h = Arr.length-1;
	let m = 0;
	while(l<=h){
	m = Math.floor((l+h)/2)
	if(Arr[m] === item){
		return m
	}else if (Arr[m]<item){
		l = m+1
	}else if(Arr[m]>item){
		h = m-1
	}
	}
	return -1

}

let Arr = [-5,-3,5,32,54,65,79]
console.log(binarySearch(Arr,1))