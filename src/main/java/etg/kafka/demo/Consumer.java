package etg.kafka.demo;

import kafka.utils.ShutdownableThread;
import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.apache.kafka.clients.consumer.KafkaConsumer;

import java.util.Collections;
import java.util.Properties;

public class Consumer extends ShutdownableThread {
    private final KafkaConsumer<Integer,String> consumer;
    private final String topic;

    public Consumer(String topic){
        super("KafkaConsumerExample",false);
        Properties props = new Properties();
//        props.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, KafkaProperties.BOOTSTRAP_SERVERS);
//        props.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, "192.168.21.130:9092,192.168.21.131:9092,192.168.21.132:9092");
        props.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, "server2:9092,server3:9092,server4:9092");
//        props.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, "server4:9092");
        props.put(ConsumerConfig.GROUP_ID_CONFIG, "DemoConsumer");
        props.put(ConsumerConfig.ENABLE_AUTO_COMMIT_CONFIG, "true");
        props.put(ConsumerConfig.AUTO_COMMIT_INTERVAL_MS_CONFIG, "1000");
        props.put(ConsumerConfig.SESSION_TIMEOUT_MS_CONFIG, "30000");
        props.put(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG, "org.apache.kafka.common.serialization.IntegerDeserializer");
        props.put(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG, "org.apache.kafka.common.serialization.StringDeserializer");

        consumer = new KafkaConsumer<Integer, String>(props);
        this.topic = topic;
    }

    public void doWork() {
        consumer.subscribe(Collections.singletonList(this.topic));
        ConsumerRecords<Integer,String> records = consumer.poll(1000);
        for(ConsumerRecord<Integer,String> record:records){
            System.out.println("Received message:(" + record.key() + ", " + record.value() +
                    ") at partition " + record.partition() + " offset " + record.offset());
        }
    }
}
