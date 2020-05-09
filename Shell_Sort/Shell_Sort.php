<?php

function shellSort(&$arr){

	for ($gap=floor(count($arr)/2); $gap > 0; $gap= floor($gap/2)) { 
		for ($i=$gap; $i < count($arr); $i++) { 
			
			$temp = $arr[$i];
			$j = $i;
			for (; $j >= $gap && $arr[$j - $gap] > $temp; $j -= $gap) { 
				$arr[$j] = $arr[$j - $gap];
			}
			$arr[$j] = $temp;
		}
	}
}

function printArray($arr){

	$output = "[";
	for ($i=0; $i < count($arr); $i++) { 
		$output .=" ".$arr[$i]." ";
		if($i < count($arr) - 1)
			$output .=",";
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

shellSort($arr);
printArray($arr);


?>