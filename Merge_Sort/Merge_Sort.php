<?php

function mergeSort(&$arr){
	$temp = new SplFixedArray(count($arr));
	divide($arr,$temp,0,count($arr)-1);
}

function divide(&$arr,&$temp,$leftStart,$rightEnd){

	if ($leftStart>=$rightEnd) {
		return;
	}

	$middle = floor(($leftStart+$rightEnd)/2);

	divide($arr,$temp,$leftStart,$middle);
	divide($arr,$temp,$middle+1,$rightEnd);
	mergeHalves($arr,$temp,$leftStart,$rightEnd);

}

function mergeHalves(&$arr,&$temp,$leftStart,$rightEnd){

	$leftEnd = floor(($leftStart+$rightEnd)/2);
	$rightStart = $leftEnd + 1;

	$size = $rightEnd - $leftStart + 1;
	$left = $leftStart;
	$right = $rightStart;
	$index = $leftStart;

	while ($left<=$leftEnd and $right<=$rightEnd) {
		if ($arr[$left] <= $arr[$right]) {
			$temp[$index] = $arr[$left];
			$left++;
		}else{
			$temp[$index] = $arr[$right];
			$right++;
		}
		$index++;
	}

	copyArray($arr,$left,$temp,$index,$leftEnd);
	copyArray($arr,$right,$temp,$index,$rightEnd);
	copyArray($temp,$leftStart,$arr,$leftStart,$rightEnd);

}

function copyArray(&$a,$aBegin,&$b,$bBegin,$size){
	for ($i=$aBegin,$j=$bBegin; $i <=$size ; $i++,$j++) { 
		$b[$j] = $a[$i];
	}

}
function printArray($arr){
	$output = "[";
	for ($i=0; $i < count($arr); $i++) { 
		$output .= " ".$arr[$i]." ";
		if($i<count($arr)-1)
			$output .= ",";
	}
	$output .="]";

	echo $output;

}

$n = (int)readline();
$arr = array();

for ($i=0; $i <$n; $i++) { 
	$arr[$i] = (int)readline();
}

mergeSort($arr);
printArray($arr);
?>