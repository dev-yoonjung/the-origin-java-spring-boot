package theorigin.javaspringboot.publisher.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.core.FanoutExchange;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.concurrent.atomic.AtomicInteger;

@Service
public class PublisherService {
    private static final Logger logger = LoggerFactory.getLogger(PublisherService.class);

    private final RabbitTemplate rabbitTemplate;
    private final FanoutExchange fanoutExchange;

    public PublisherService(@Autowired RabbitTemplate rabbitTemplate,
                            @Autowired FanoutExchange fanoutExchange) {
        this.rabbitTemplate = rabbitTemplate;
        this.fanoutExchange = fanoutExchange;
    }

    AtomicInteger count = new AtomicInteger(0);

    public void publishMessage() {
        String message = "Message Count: " + count.incrementAndGet();
        rabbitTemplate.convertAndSend(
                fanoutExchange.getName(),
                "",
                message
        );
    }
}
