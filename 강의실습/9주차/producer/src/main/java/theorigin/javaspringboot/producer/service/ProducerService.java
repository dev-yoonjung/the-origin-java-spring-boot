package theorigin.javaspringboot.producer.service;

import com.google.gson.Gson;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import theorigin.javaspringboot.producer.model.JobRequest;

import java.util.UUID;

@Service
public class ProducerService {
    private static final Logger logger = LoggerFactory.getLogger(ProducerService.class);

    private final RabbitTemplate rabbitTemplate;
    private final Queue rabbitQueue;
    private final Gson gson;

    public ProducerService(@Autowired RabbitTemplate rabbitTemplate,
                           @Autowired Queue rabbitQueue,
                           @Autowired Gson gson) {
        this.rabbitTemplate = rabbitTemplate;
        this.rabbitQueue = rabbitQueue;
        this.gson = gson;
    }

    public String send() {
        JobRequest jobRequest = new JobRequest(UUID.randomUUID().toString());
        rabbitTemplate.convertAndSend(rabbitQueue.getName(), gson.toJson(jobRequest));
        logger.info("Sent message: {}", gson.toJson(jobRequest));
        return jobRequest.getJobId();
    }
}
