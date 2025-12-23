package eu.dec21.producer.web;

import eu.dec21.producer.service.MessageProducerService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/messages")
public class SendController {

    private final MessageProducerService service;

    public SendController(MessageProducerService service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<String> send(@RequestBody String body) {
        service.sendText(body);
        return ResponseEntity.ok("Sent to queue: " + body);
    }
}
