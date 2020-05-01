<?php

function insertionSort($Arr){

	for ($i=1; $i < count($Arr); $i++) { 
		$key = $Arr[$i];
		$j = $i;
		while ($j>=1 && ($Arr[$j-1] > $key)) {
			$Arr[$j] = $Arr[$j-1];
			$j--;
		}
		$Arr[$j] = $key;
	}
	return $Arr;
}

function printArray($Arr){
	$output = "[";
	for ($i=0; $i < count($Arr); $i++) { 
		$output.= " ".$Arr[$i]." ";
		if ($i<count($Arr)-1) {
			$output.=",";
		}
	}
	$output.="]";
	echo $output;
}

$N = readline();
$Arr = array();
for ($i=0; $i < $N; $i++) { 
	$Arr[$i] = readline();
}
$Arr = insertionSort($Arr);
printArray($Arr);

?>