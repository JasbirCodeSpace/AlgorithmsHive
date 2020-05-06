<?php

function swap(&$arr,$i,$j){

	$temp = $arr[$i];
	$arr[$i] = $arr[$j];
	$arr[$j] = $temp;

	return;
}

function bubbleSort(&$arr){
	$isSorted = false;
	$lastUnsorted = count($arr)-1;
	while(!$isSorted) {
		$isSorted = true;
		for ($i=0; $i < $lastUnsorted; $i++) { 
			if ($arr[$i] > $arr[$i+1]) {
				swap($arr,$i,$i+1);
				$isSorted = false;
			}
		}
		$lastUnsorted--;
	}
	return;
}

function printArray($arr){
	$output = "[";
	for ($i=0; $i < count($arr); $i++) { 
		$output .= " ".$arr[$i]." ";
		if ($i<count($arr)-1) {
			$output .= ",";
		}
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

bubbleSort($arr);
printArray($arr);

?>