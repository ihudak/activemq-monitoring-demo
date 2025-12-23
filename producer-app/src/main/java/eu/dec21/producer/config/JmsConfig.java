package eu.dec21.producer.config;

import jakarta.jms.ConnectionFactory;
import org.apache.activemq.ActiveMQConnectionFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jms.core.JmsTemplate;

@Configuration
public class JmsConfig {

    @Bean
    public ActiveMQConnectionFactory connectionFactory(
            @Value("${spring.activemq.broker-url}") String brokerUrl,
            @Value("${spring.activemq.user}") String user,
            @Value("${spring.activemq.password}") String password) {
        ActiveMQConnectionFactory cf = new ActiveMQConnectionFactory(user, password, brokerUrl);
        cf.setTrustAllPackages(true); // optional tuning
        return cf;
    }

    @Bean
    public JmsTemplate jmsTemplate(ActiveMQConnectionFactory cf) {
        JmsTemplate template = new JmsTemplate((ConnectionFactory) cf);
        template.setPubSubDomain(false); // queue (not topic)
        return template;
    }
}
