package ua.home.rabbitsmpl.subscriber.configurations;

import org.springframework.amqp.core.ExchangeTypes;
import org.springframework.amqp.rabbit.annotation.Exchange;
import org.springframework.amqp.rabbit.annotation.Queue;
import org.springframework.amqp.rabbit.annotation.QueueBinding;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.context.annotation.Configuration;

/**
 * @author tsv@ciklum.com
 */

@Configuration
public class SubscriberConfiguration{

    @RabbitListener(bindings = @QueueBinding(
            value = @Queue(value = "grabber.queue-1"),
            exchange = @Exchange(value = "fanout.exchange", type = ExchangeTypes.DIRECT),
            key="q1"))
    public void processQueue1(String message) {
        System.out.println("received from queue [1] : " + message);;
    }

    @RabbitListener(bindings = @QueueBinding(
            value = @Queue(value = "grabber.queue-2"),
            exchange = @Exchange(value = "fanout.exchange", type = ExchangeTypes.DIRECT),
            key="q2"))
    public void processQueue2(String message) {
        System.out.println("received from queue [2] : " + message);;
    }
}
