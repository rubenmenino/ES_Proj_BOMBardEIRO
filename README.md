# ES_Proj_BOMBardEIRO
https://rubenmenino.github.io/rubenmenino.github.io_ES-projeto-BOMBardEIRO/

correr localmente::

  fazer o docker-compose up    (esta para o kafka só, ainda n tem db)

  criar os topicos   (bin/kafka-topics.sh --create --topic esp11_hr --zookeeper localhost:2181 --partitions 1 --replication-factor 1)
                     (bin/kafka-topics.sh --create --topic esp11_gps --zookeeper localhost:2181 --partitions 1 --replication-factor 1)
                     (bin/kafka-topics.sh --create --topic esp11_env --zookeeper localhost:2181 --partitions 1 --replication-factor 1)
                     
  correr o producer.py
  
  correr o programa no intelij
  
  
