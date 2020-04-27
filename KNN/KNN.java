import java.io.*;
import java.net.*;
import java.util.*;
import java.lang.Math;

public class KNN {
	private List<String[]> File;
	private String[] Headers;
	private List<String[]> Train_Set;
	private List<String[]> Test_Set;

	public double distance(String[] trainSample,String[] testSample){
		double dist = 0;
		for (int i=0; i<trainSample.length-1; i++) {
			dist += Math.pow((Double.parseDouble(trainSample[i])-Double.parseDouble(testSample[i])),2);
		}
		return dist;
	}


	public String KNN_Algo(String[] test_sample,int N){
		Double[] dist = new Double[this.Train_Set.size()];
		int[] indices = new int[this.Train_Set.size()];

		TreeMap<Double,String> distMap = new TreeMap<Double,String>();
			for (int j=0; j < this.Train_Set.size(); j++) {
				distMap.put(distance(this.Train_Set.get(j),test_sample)
					,this.Train_Set.get(j)[this.Train_Set.get(j).length-1]);
			}


			String[] Labels = new String[N];
			int j=0;
			     // Get a set of the entries on the sorted map
    Set set = distMap.entrySet();
 
    // Get an iterator
    Iterator i = set.iterator();
 
    // Display elements
    while(i.hasNext()) {
    	if(j==N){break;}
      Map.Entry me = (Map.Entry)i.next();
      Labels[j++] = me.getValue().toString();
    }
  return Mode(Labels);


	}

	public String Mode(String[] arr){
		if(arr.length ==0 ){return null;}
		String maxEl = "";
		int maxCount = 0;
		for (int i=0;i<arr.length ; i++) {
			int count =0;
			for (int j=0; j < arr.length; j++) {
				if(arr[i]==arr[j]) count++;
			}
			if(count>maxCount){
				maxCount = count;
				maxEl = arr[i];
			}
		}

		return maxEl;
	}

	public void splitSamples(double ratio){
		Collections.shuffle(this.File,new Random());
		this.Train_Set = new ArrayList<>(this.File.subList(0,(int)(this.File.size()*ratio)));
		this.Test_Set = new ArrayList<>(this.File.subList(this.Train_Set.size(),this.File.size()));
		System.out.println(this.Train_Set.size()+" "+this.Test_Set.size());
	}
	public void csvToArray(String csvFile,boolean headerPresent){
		BufferedReader br = null;
		String line = "";
		String separator = ",";
		this.File = new ArrayList<>();
		try{
			br = new BufferedReader(new FileReader(csvFile));
			while((line = br.readLine()) != null){
				this.File.add(line.split(separator));
			}
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			if(br!=null){
				try{
				br.close();
				}catch(Exception e){
					e.printStackTrace();
				}
			}
		}

		if(headerPresent){
			this.Headers = this.File.get(0);
			this.File = this.File.subList(1,this.File.size());
		}else{
			this.Headers = null;
		}

	}

	public void printFileData(){
		for (String[] row : this.File) {
			for (int i=0; i< row.length ; i++) {
				System.out.print(row[i]+" ");
			}
			System.out.println();
		}

		return;
	}
	
	public static void main(String[] args) {
		String csvFile = "Iris_Dataset.csv";
		double splitRatio = 0.8;
		boolean headerPresent = true;
		int N = 7;

		KNN object = new KNN();
		object.csvToArray(csvFile,headerPresent);
		object.splitSamples(splitRatio);

		String[][] Labels = new String[object.Test_Set.size()][2];
		for (int i=0;i<object.Test_Set.size() ;i++ ) {
			Labels[i][0] = object.Test_Set.get(i)[object.Test_Set.get(i).length-1];
			Labels[i][1] = object.KNN_Algo(object.Test_Set.get(i),N);
		}

		System.out.println("Actual Class"+"\t\tPredicted Class");
		for (String[] row : Labels) {
			for (String col : row) {
				System.out.print(col+"\t\t\t");
			}
			System.out.println();
		}
		
	}

}