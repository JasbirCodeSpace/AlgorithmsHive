<?php
error_reporting(0);
$data = file_get_contents("https://datahub.io/machine-learning/iris/r/iris.csv");
$rows = explode("\n",$data);
$csvData = array();
foreach($rows as $row) {
    // $csvData[] = str_getcsv($row);
    $csvData[] = explode(",", $row);
}
$csvData = array_slice($csvData,1,count($csvData));
preProcessing($csvData);



function preProcessing($csvData){
shuffle($csvData);
$testDataSize = ceil(count($csvData)*0.9);
$train_data = array_slice($csvData,1,$testDataSize);
$test_data = array_slice($csvData,$testDataSize,count($csvData));

$numOfColumns = count($train_data[0]);
$predictive_labels = [];
$actual_labels = [];

for($i=0;$i<count($test_data);$i++) {
  $predictive_labels[] = KNN($train_data, $test_data[$i],$numOfColumns,7);
  $actual_labels[] = $test_data[$i][$numOfColumns-1]?$test_data[$i][$numOfColumns-1]:"";
}
echo "Actual Labels :";
print_r($actual_labels);

echo "Predective Labels :";
print_r($predictive_labels);

$acc = Accuracy($predictive_labels,$actual_labels);
echo "Accuracy : ".$acc." %";

}

function distance($train,$test) {
  $dist = 0;
  for ($i=0; $i < count($train)-1; $i++) {
    $dist = $dist + pow(($train[$i] - $test[$i]), 2);
  }
  return sqrt($dist);
}

function KNN($train_sample,$test,$numOfColumns,$N) {
  $dist_array = array();
  for ($i=0; $i < count($train_sample); $i++) {
    $dist_array[$i][0] = $i;
    $dist_array[$i][1] = distance($train_sample[$i], $test);
    $dist_array[$i][2] = $train_sample[$i][$numOfColumns-1];

  }
  usort($dist_array,function($elem1,$elem2){
    return $elem1[1]-$elem2[2];
  });


  $labels = array();
  for ($i = 0; $i < $N; $i++) {
    $labels[$i] = $train_sample[$dist_array[$i][0]][$numOfColumns-1];

  }

  $arr_freq = array_count_values($labels);
  return array_keys($arr_freq)[0];

}

function Accuracy($predictedLabels,$actualLabels){
$sum=0;
  for ($i=0; $i < count($actualLabels); $i++) { 
    if ($actualLabels[$i] == $predictedLabels[$i]) {
      $sum++;
    }
  }

  return number_format(($sum/count($actualLabels))*100,2);

}
 ?>

