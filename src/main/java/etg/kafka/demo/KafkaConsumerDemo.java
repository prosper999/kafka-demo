package etg.kafka.demo;

public class KafkaConsumerDemo {
    public static void main(String[] args){
//        boolean isAsync = args.length == 0 || !args[0].trim().equalsIgnoreCase("sync");
//        boolean isAsync = false;
//        Producer producer = new Producer(KafkaProperties.TOPIC,isAsync);
//        producer.start();

        Consumer consumerThread = new Consumer(KafkaProperties.TOPIC);
        consumerThread.start();

    }
}
