import pandas as pd
import math

def distance(train,test):
    dist =0
    for i in range(1,len(train)-1):
    	dist+=pow((train[i] - test[i]), 2)
    return dist
def KNN(train_samples,test_data,N):
	dist = pd.DataFrame(columns=["Index","Label","Dist"])
	i=0
	for train_row in train_samples.itertuples():
		dist.loc[i] = [train_row[0],train_row[len(train_row)-1],distance(train_row,test_data)]
		i = i+1
	dist  = dist.sort_values(["Dist"],ascending=(True))
	dist = dist[:N]
	return dist.loc[:,"Label"].mode()[0]


data = pd.read_csv("https://raw.githubusercontent.com/JasbirCodeSpace/AlgorithmsHive/master/KNN/Iris_Dataset.csv")
train_samples = data.sample(frac=0.8,random_state=1223)
test_samples = data.drop(train_samples.index)

result = pd.DataFrame(columns=["Actual","Predicted"])
i=0
count = 0
for test_row in test_samples.itertuples():
	actual = test_row[len(test_row)-1]
	predicted = KNN(train_samples,test_row,7)
	if actual == predicted:
		count = count +1
	result.loc[i] = [actual,predicted]
	i = i+1
print("Accuracy :: "+format((count/len(result))*100,'.2f')+"%")
print(result)







