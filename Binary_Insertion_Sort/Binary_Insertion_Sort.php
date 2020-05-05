<?php

function binarySearch($arr,$h,$item){
	$l = 0;
	while($l<$h){
		$m = floor(($l+$h)/2);
		if($arr[$m] == $item){
			return $m+1;
		}
		elseif ($arr[$m] > $item) {
			$h = $m - 1;
		}elseif($arr[$m] < $item){
			$l = $m + 1;
		}
	}

	return ($item > $arr[$l])?$l+1:$l;
}

function binaryInsertionSort($arr){
	for ($i=0; $i <count($arr); $i++) { 
		$selected = $arr[$i];
		$j = $i;
		$location = binarySearch($arr,$j-1,$selected);
		while ($j>=1 && $j>$location) {
			$arr[$j] = $arr[$j-1];
			$j--;
		}
		$arr[$j] = $selected;
	}

	return $arr;
}

function printArray($arr){
	$output="[";
	for ($i=0; $i < count($arr); $i++) { 
		$output.=" ".$arr[$i]." ";
		if ($i<count($arr)-1) {
			$output.=",";
		}
	}
	$output.="]";

	echo $output;
}

$n = (int)readline();
$arr = array();

for ($i=0; $i < $n; $i++) { 
	$arr[$i] = (int)readline();
}

$arr = binaryInsertionSort($arr);
printArray($arr);

?>