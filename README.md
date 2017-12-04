
### To create matric:

#### POST http://localhost:8080/egencodechallange/matric/create

#### BODY:

{
  "personId": 3,
  "weight": 180,
  "name": "Test3",
  "recordTime": "2017-04-15 17:04:42.896026"
}

### Reads all the metrics:

#### GET http://localhost:8080/egencodechallange/matric/read

### reads all the metrics that were created between the given two timestamps:

#### GET http://localhost:8080/egencodechallange/matric/readByTimeRange?startTime="yyyy-MM-dd HH:mm:ss.SSS", endTime="yyyy-MM-dd HH:mm:ss.SSS"

### reads all alerts:

#### GET http://localhost:8080/egencodechallange/alert/read

### reads all alerts that are created between the given two timestamps:

#### GET http://localhost:8080/egencodechallange/alert/readByTimeRange?startTime="yyyy-MM-dd HH:mm:ss.SSS", endTime="yyyy-MM-dd HH:mm:ss.SSS"

### Considering person having weight more than 150 or less than 100 is creating overweight/underweight alert

