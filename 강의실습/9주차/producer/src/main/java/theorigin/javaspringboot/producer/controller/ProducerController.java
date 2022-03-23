package theorigin.javaspringboot.producer.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import theorigin.javaspringboot.producer.model.JobProcess;
import theorigin.javaspringboot.producer.service.ProducerService;
import theorigin.javaspringboot.producer.service.RedisService;

@RestController
public class ProducerController {

    private final ProducerService producerService;
    private final RedisService redisService;

    public ProducerController(@Autowired ProducerService producerService,
                              @Autowired RedisService redisService) {
        this.producerService = producerService;
        this.redisService = redisService;
    }

    @GetMapping("/")
    public String sendMessage() {
        return producerService.send();
    }

    @GetMapping("/{jobId}")
    public JobProcess getResult(@PathVariable("jobId") String jobId) {
        return redisService.retrieveJob(jobId);
    }

}
