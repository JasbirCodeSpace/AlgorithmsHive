<?php

define('RUN', 32);

function insertionSort(&$arr,$left,$right)
{
	for ($i=$left+1; $i <=$right; $i++) { 
		$j = $i;
		$key = $arr[$i];
		while ($j>=$left+1 && $arr[$j-1]> $key) {
			$arr[$j] = $arr[$j-1];
			$j--;
		}
		$arr[$j] = $key;
	}
}

function mergeHalves(&$arr,$temp,$leftStart,$mid,$rightEnd){

	$leftEnd = $mid;
	$rightStart = $leftEnd + 1;
	$left = $leftStart;
	$right = $rightStart;
	$index = $leftStart;

	while ($left<=$leftEnd && $right<=$rightEnd) {
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

function timSort(&$arr){
	$temp = new SplFixedArray(count($arr));
	for ($i=0; $i < count($arr); $i += RUN) { 
		insertionSort($arr,$i,min($i+RUN-1,count($arr)-1));
	}

	for ($size=RUN; $size < count($arr); $size *= 2) { 
		for ($left=0; $left < count($arr); $left+=$size*2) { 
			$right = min($left+2*$size-1,count($arr)-1);
			$mid = $left + $size -1;
			mergeHalves($arr,$temp,$left,$mid,$right);
		}
	}
}
function copyArray($a,$aBegin,&$b,$bBegin,$size){
	for ($i=$aBegin,$j=$bBegin; $i <=$size; $i++,$j++) { 
		$b[$j] = $a[$i];
	}
}

function printArray($arr){

	$output = "[";
	for ($i=0; $i < count($arr); $i++) { 
		$output .=" ".$arr[$i]." ";
		if ($i < count($arr)-1) {
			$output .=",";
		}
	}
	$output .="]";
	echo $output;
}

$n = (int)readline();
$arr = new SplFixedArray($n);
for ($i=0; $i < $n; $i++) { 
	$arr[$i] = $n-$i;
}

timSort($arr);
printArray($arr);

?>