package etg.kafka.demo;

public class KafkaProducerDemo {
    public static void main(String[] args) {
//        boolean isAsync = args.length == 0 || !args[0].trim().equalsIgnoreCase("sync");
        boolean isAsync = true;
        Producer producer = new Producer(KafkaProperties.TOPIC, isAsync);
        producer.start();

    }
}
