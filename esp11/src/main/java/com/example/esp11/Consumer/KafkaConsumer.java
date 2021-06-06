package com.example.esp11.Consumer;

import com.mysql.fabric.jdbc.FabricMySQLConnectionProxy;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.support.Acknowledgment;
import org.springframework.stereotype.Component;
import org.influxdb.InfluxDB;
import org.influxdb.InfluxDBFactory;
import org.influxdb.dto.BatchPoints;
import org.influxdb.dto.Point;
import org.influxdb.dto.Pong;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.TimeUnit;


@Component
public class KafkaConsumer {
    private List<String> messages = new LinkedList<>();
    Logger log = LoggerFactory.getLogger(InfluxDBFactory.class);

    // https://www.baeldung.com/java-influxdb
    @KafkaListener(topics = "esp11_hr", groupId = "group_id")
    public void consume(ConsumerRecord<String, String> consumerRecord){

        String value = consumerRecord.value();
        /*
        //System.out.println("messageHERE = " + value);
        InfluxDB influxDB = InfluxDBFactory.connect("http://localhost:8086", "admin", "secret");

        Pong response = influxDB.ping();
        if (response.getVersion().equalsIgnoreCase("unknown")) {
            log.error("Error pinging server.");
            return;
        } else {
            System.out.println("connected");
        }

        influxDB.createDatabase("baeldung");
        influxDB.createRetentionPolicy(
                "defaultPolicy", "baeldung", "30d", 1, true);
        influxDB.setLogLevel(InfluxDB.LogLevel.BASIC);
        influxDB.enableBatch(100, 200, TimeUnit.MILLISECONDS);
        influxDB.setRetentionPolicy("defaultPolicy");
        influxDB.setDatabase("baeldung");

        BatchPoints batchPoints = BatchPoints
                .database("baeldung")
                .retentionPolicy("defaultPolicy")
                .build();

        messages.add(value.toString());
        //System.out.println("MESSAGENS: "  + messages);
    */


    }






}
