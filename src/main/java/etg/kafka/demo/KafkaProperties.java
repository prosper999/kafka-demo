package etg.kafka.demo;

public class KafkaProperties {
    public static final String TOPIC = "test2";
//    public static final String KAFKA_SERVER_URL = "test2";
//    public static final int KAFKA_SERVER_PORT = 9092;
    public static final String BOOTSTRAP_SERVERS = "server2:9092,server3:9092,server4:9092";//bootstrap.servers
    public static final int KAFKA_PRODUCER_BUFFER_SIZE = 64 * 1024;
    public static final int CONNECTION_TIMEOUT = 100000;
    public static final String TOPIC2 = "test2";
    public static final String TOPIC3 = "test2";
    public static final String CLIENT_ID = "SimpleConsumerDemoClient";

}
