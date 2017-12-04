
### To create matric:

#### POST http://localhost:8080/egencodechallange/matric/create

#### BODY:

{
  "timeStamp": "1458062848734", 
  "value": "153"
}

### Reads all the metrics:

#### GET http://localhost:8080/egencodechallange/matric/read

### reads all the metrics that were created between the given two timestamps:

#### GET http://localhost:8080/egencodechallange/matric/readByTimeRange?startTime="TimeInMillis", endTime="TimeInMillis"

### reads all alerts:

#### GET http://localhost:8080/egencodechallange/alert/read

### reads all alerts that are created between the given two timestamps:

#### GET http://localhost:8080/egencodechallange/alert/readByTimeRange?startTime="TimeInMillis", endTime="TimeInMillis"


