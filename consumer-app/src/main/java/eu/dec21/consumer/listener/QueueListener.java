package eu.dec21.consumer.listener;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

@Component
public class QueueListener {

    private static final Logger log = LoggerFactory.getLogger(QueueListener.class);

    // listens to the same queue name used by producer
    @JmsListener(destination = "${app.queue-name}")
    public void onMessage(String payload) {
        log.info("Received message from queue: {}", payload);
    }
}
