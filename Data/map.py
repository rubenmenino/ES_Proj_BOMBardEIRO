import pandas as pd  
from influxdb import InfluxDBClient

client= InfluxDBClient (host= "localhost",port=8086)
client.switch_database("baeldung")

df=pd.read_csv("gps_data.csv")
df.dropna(inplace=True)
print (df.shape)

for rwo_pk, row in df.iloc[1:].iterrows():

 json_body=[{
 "measurement": "test",
 "tags": {"GPS_TIME_TAG":row[3]},
 "fields": {
 "latitude":row[1],
 "longitude":row[2],
 "metric": row[4]
 
 }
 }]
 client.write_points(json_body)
 print("done")