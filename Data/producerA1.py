from kafka import KafkaProducer
from kafka.errors import KafkaError
import json 
import csv
import pprint
import time
from datetime import datetime

from os import listdir
from os.path import isfile, join

onlyfiles = [f for f in listdir('./dataset/') if isfile(join('./dataset/', f)) and f.split('_')[0].split('.')[0] == 'a1']

firefighter = {'a1': {'gps': [], 'env':[], 'hr': []}}

def convert_to_timestamp(datestring):
    date = datestring.split('/')
    a, b = date.index(datestring.split('/')[0]), date.index(datestring.split('/')[1])
    date[b], date[a] = date[a], date[b]
    date = '/'.join(date)
    return datetime.timestamp(datetime.strptime(date,'%m/%d/%Y %H:%M'))

for f in onlyfiles:
    type_ = f.split('_')[1].split('.')[0]
    if type_ == 'gps':
       
        with open('./dataset/' + f, encoding='utf-8-sig', newline='') as csvfile:
            spamreader = csv.reader(csvfile, delimiter=',', quotechar='|')
            for row in spamreader:
                firefighter[f.split('_')[0]][type_].append({
                    'name': f.split('_')[0],
                    'type' : type_,
                    'date': convert_to_timestamp(row[0]),
                    'gps_tag_lat': row[1],
                    'gps_tag_long': row[2],
                    'gps_time_tag': row[3],
                    'gps_alt_tag': row[4]
                })
    elif type_ == 'env':
        with open('./dataset/' + f, encoding='utf-8-sig',newline='') as csvfile:
            spamreader = csv.reader(csvfile, delimiter=',', quotechar='|')
            for row in spamreader:
                firefighter[f.split('_')[0]][type_].append({
                    'name': f.split('_')[0],
                    'type' : type_,
                    'date': convert_to_timestamp(row[0]),
                    'co': row[1],
                    'temp': row[2],
                    'hgt': row[3],
                    'no2': row[4],
                    'hum': row[5],
                    'lum': row[6],
                    'battery': row[7]
                })
    elif type_ == 'hr':
        with open('./dataset/' + f, encoding='utf-8-sig',newline='') as csvfile:
            spamreader = csv.reader(csvfile, delimiter=',', quotechar='|')
            for row in spamreader:
                firefighter[f.split('_')[0]][type_].append({
                    'name': f.split('_')[0],
                    'type' : type_,                    
                    'date': convert_to_timestamp(row[0]),
                    'hr': row[1],
                })

gps = firefighter['a1']['gps'] + firefighter['a1']['env'] + firefighter['a1']['hr']
      

new = sorted(gps, key = lambda i: i['date']) 
pprint.pprint(new)

producer = KafkaProducer(bootstrap_servers=['localhost:9092:9092'],value_serializer=lambda m: json.dumps(m).encode('ascii'))
for item in new:
    
    if item['type'] == 'gps':
        producer.send('esp11_gps', item)
    elif item['type'] == 'env':
        producer.send('esp11_env', item)
    elif item['type'] == 'hr':
        producer.send('esp11_hr', item)
    time.sleep(0.03)

# # produce asynchronously
# for _ in range(100):
#     producer.send('Flights', b'msg')

def on_send_success(record_metadata):
    print(record_metadata.topic)
    print(record_metadata.partition)
    print(record_metadata.offset)

def on_send_error(excp):
    log.error('I am an errback', exc_info=excp)
    # handle exception

# produce asynchronously with callbacks
#producer.send('Flights', b'raw_bytes').add_callback(on_send_success).add_errback(on_send_error)

# block until all async messages are sent
producer.flush()

# configure multiple retries
producer = KafkaProducer(retries=5)