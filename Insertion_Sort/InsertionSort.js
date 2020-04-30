function insertionSort(Arr){
	for (var i = 0; i < Arr.length; i++) {
		let key = Arr[i];
		let j = i;
		while(j>=1 && Arr[j-1]>key){
			Arr[j] = Arr[j-1];
			j--;
		}
		Arr[j] = key;
	}
}

function printArray(Arr){
	let output = "[";
	for (var i = 0; i < Arr.length; i++) {
		output+= " "+Arr[i]+" ";
		if (i<Arr.length-1) {output+=",";}
	}
	output += "]";

	console.log(output);
}

let Arr = [6,3,1,8,3,0,5];
insertionSort(Arr);
printArray(Arr);