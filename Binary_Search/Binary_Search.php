<?php

function binarySearch($Arr,$item){

	$l = 0;
	$h = count($Arr) - 1;
	$m = 0;
	while ($l <= $h) {
		$m = floor(($l+$h)/2);
		if ($Arr[$m] == $item) {
			return $m;
		}elseif ($Arr[$m] < $item) {
			$l = $m + 1;
		}elseif ($Arr[$m] > $item) {
			$h = $m - 1;
		}
	}
	return -1;
}

$N = (int)readline();
$Arr = array();
for ($i=0; $i < $N; $i++) { 
	$Arr[$i] = (int)readline();
}

$item = (int)readline();
$index = binarySearch($Arr,$item);
echo $index;
?>