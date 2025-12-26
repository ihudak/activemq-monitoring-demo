package eu.dec21.producer.web;

import eu.dec21.producer.service.MessageProducerService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@RestController
@RequestMapping("/api/messages")
public class SendController {

    private final MessageProducerService service;
    private static final Logger log = LoggerFactory.getLogger(SendController.class);

    public SendController(MessageProducerService service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<String> send(@RequestBody String body) {
        log.info("Preparing a message to queue: {}", body);
        service.sendText(body);
        return ResponseEntity.ok("Sent to queue: " + body);
    }
}
