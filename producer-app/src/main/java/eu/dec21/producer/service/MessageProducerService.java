package eu.dec21.producer.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Service;

@Service
public class MessageProducerService {

    private final JmsTemplate jmsTemplate;
    private final String queueName;

    public MessageProducerService(JmsTemplate jmsTemplate,
                                  @Value("${app.queue-name}") String queueName) {
        this.jmsTemplate = jmsTemplate;
        this.queueName = queueName;
    }

    public void sendText(String text) {
        jmsTemplate.convertAndSend(queueName, text);
    }
}
