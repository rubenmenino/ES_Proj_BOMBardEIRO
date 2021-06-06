import pandas as pd  
from influxdb import InfluxDBClient

client= InfluxDBClient (host= "localhost",port=8086)
client.switch_database("baeldung")

df=pd.read_csv("a1_env_test.csv")
df.dropna(inplace=True)
print (df.shape)

for rwo_pk, row in df.iloc[1:].iterrows():

 json_body=[{
 "measurement": "testEnv",
 "tags": {"battery":row[8]},
 "fields": {
 "CO":row[1],
 "TEMP":row[2],
 "HGT": row[3],
 "NO2": row[5]
 
 }
 }]
 client.write_points(json_body)
 print("done")