DataSet = read.csv("https://datahub.io/machine-learning/iris/r/iris.csv", header = TRUE)

train_size = floor(0.80 * nrow(DataSet))
set.seed(1223)
train_index = sample(1:nrow(DataSet), size = train_size)

train_sample = DataSet[train_index, ]
test_sample = DataSet[-train_index, ]
test_index = as.numeric(row.names(test_sample))
train_label = train_sample[, 5]

# distance calculation method
distance <- function(train, test) {
  dist = 0
  for (i in 2:ncol(train) - 1) {
    dist = dist + (train[, i] - test[, i])**2
  }
  return(sqrt(dist))
}

# KNN Method
KNN <- function(test, N) {
  dist_array = data.frame()
  i=1
  for (j in train_index) {
    dist_array[i, 1] =  j
    dist_array[i, 2] = distance(DataSet[j, ], test[1,])
    dist_array[i,3] = DataSet[j,ncol(train_sample)]
    i = i+1
  }
  dist_array = dist_array[order(dist_array$V2), ]

  labels = data.frame()
  for (i in 1:N) {
    labels[i, 1] = DataSet[dist_array[i, 1], 5]
    
  }
  table_data = table(labels)
  new_label = names(table_data)[which(table_data == max(table_data))]
  return(new_label)
}

labels_frame = data.frame()
j=1
for (i in test_index) {
test_data = test_sample[i, ]
new_label = KNN(test_data, 7)
labels_frame[j,1] = test_data[,5]
print(test_data[,5])
print(labels_frame[j,1])
labels_frame[j,2] = new_label
}

print(labels_frame)

