package com.prem.camel.config;

import com.prem.camel.bean.SolaceProperties;
import com.solacesystems.jms.SolConnectionFactory;
import com.solacesystems.jms.SolJmsUtility;
import org.apache.camel.component.jms.JmsComponent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.jms.support.JmsUtils;

import javax.jms.ConnectionFactory;

@Configuration
public class AppConfig {

    @Autowired
    private Environment environment;

    @Bean
    @ConfigurationProperties(prefix = "solace.prime")
    public SolaceProperties solaceProperties(){
        return new SolaceProperties();
    }

    @Bean
    public ConnectionFactory connectionFactory(SolaceProperties properties) throws Exception {
        // Create the connection factory
        SolConnectionFactory connectionFactory = SolJmsUtility.createXAConnectionFactory();
        connectionFactory.setHost(properties.getHost());
        connectionFactory.setVPN(properties.getVpn());
        connectionFactory.setUsername(properties.getUsername());
        connectionFactory.setPassword(properties.getPassword());
        connectionFactory.setClientID(properties.getClientId());
        return connectionFactory;
    }

    @Bean("jms")
    public JmsComponent jmsComponent(ConnectionFactory connectionFactory){
        JmsComponent jmsComponent = JmsComponent.jmsComponent(connectionFactory);
        return jmsComponent;
    }

}
