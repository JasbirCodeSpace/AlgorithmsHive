#include<iostream>
#include<iomanip>
#include<fstream>
#include<sstream>
#include<vector>
#include<string>

using namespace std;
using vec = vector<string>;
using matrix = vector<vec>;


matrix readCSV(string fileName){
	char separator = ',';
	matrix result;
	string row,cell;
	ifstream in(fileName);
	while(getline(in,row)){
		vec R;
		stringstream ss(row);
		while(getline(ss,cell,separator)){
			R.push_back(cell);
		}
		result.push_back(R);
	}
	in.close();
	return result;
}
int main(){
	string fileName = "Iris_Dataset.csv";
	matrix fileData = readCSV(fileName);
	return 0;
}

