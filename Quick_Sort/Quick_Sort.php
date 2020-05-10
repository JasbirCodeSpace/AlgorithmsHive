<?php

function quickSort(&$arr,$left,$right){
	if ($left >= $right)
		return;
	$index = partition($arr,$left,$right);
	quickSort($arr,$left,$index-1);
	quickSort($arr,$index+1,$right);
	return;
}

function partition(&$arr,$left,$right){

	$pivot = $arr[(int)(($left+$right)/2)];
	while ($left <= $right) {
		while ($arr[$left] < $pivot)
			$left++;
		while($arr[$right] > $pivot)
			$right--;

		if ($left <= $right) {
			swap($arr,$left,$right);
			$left++;
			$right--;

		}
	}
	return $left;
}

function swap(&$arr,$i,$j){
	$temp = $arr[$i];
	$arr[$i] = $arr[$j];
	$arr[$j] = $temp;
	return;
}

function printArray($arr){
	$output = "[";
	for ($i=0; $i < count($arr); $i++) { 
		$output .=" ".$arr[$i]." ";
		if($i < count($arr)-1)
			$output .=",";
	}
	$output .= "]";

	echo $output;
	return;
}

$n = (int)readline();
$arr = array();

for ($i=0; $i < $n; $i++) { 
	$arr[$i] = (int)readline();
}

quickSort($arr,0,count($arr)-1);
printArray($arr);

?>