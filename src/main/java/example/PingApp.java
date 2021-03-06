package example;

import com.github.broker.BrokerClient;
import com.github.broker.BrokerClientConfig;

import java.util.stream.IntStream;

public class PingApp {

    private static class Message {
        private final String value = "OK";
    }

    public static void main(String[] args) {

        BrokerClientConfig defaultConfig;
        BrokerClient defaultBrokerClient;
        defaultConfig = new BrokerClientConfig();
        defaultBrokerClient = new BrokerClient(defaultConfig);
        defaultBrokerClient.connect();

        final String EVENT = "PING";
        final Message MESSAGE = new Message();

        IntStream.rangeClosed(1, 5)
            .forEach(x -> defaultBrokerClient.produce(EVENT, MESSAGE));

        defaultBrokerClient.close();
    }
}
