<?php

function swap(&$arr,$i,$j){
	$temp = $arr[$i];
	$arr[$i] = $arr[$j];
	$arr[$j] = $temp;

	return;
}
function selectionSort(&$arr)
{
	$min = 0;
	for ($i=0; $i < count($arr)-1; $i++) { 
		$min = $i;
		for ($j=$i+1; $j < count($arr); $j++) { 
			if ($arr[$j] < $arr[$min]) {
				$min = $j;
			}
		}
		if ($min != $i) {
			swap($arr,$i,$min);
		}
	}
	return;
}

function printArray($arr){

	$output = "[";
	for ($i=0; $i <count($arr); $i++) { 
		$output .= " ".$arr[$i]." ";
		if ($i<count($arr)-1) {
			$output .=",";
		}
	}
	$output .="]";
	echo $output;

	return;
}

$n = (int)readline();
$arr = array();

for ($i=0; $i < $n; $i++) { 
	$arr[$i] = (int)readline();
}

selectionSort($arr);
printArray($arr);
?>