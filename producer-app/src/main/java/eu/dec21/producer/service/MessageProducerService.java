package eu.dec21.producer.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Service;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Service
public class MessageProducerService {

    private final JmsTemplate jmsTemplate;
    private final String queueName;
    private static final Logger log = LoggerFactory.getLogger(MessageProducerService.class);

    public MessageProducerService(JmsTemplate jmsTemplate,
                                  @Value("${app.queue-name}") String queueName) {
        this.jmsTemplate = jmsTemplate;
        this.queueName = queueName;
    }

    public void sendText(String text) {
        log.info("Sending message to queue: {}", text);
        jmsTemplate.convertAndSend(queueName, text);
    }
}
