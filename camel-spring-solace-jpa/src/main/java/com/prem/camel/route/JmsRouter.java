package com.prem.camel.route;

import org.apache.camel.builder.RouteBuilder;
import org.springframework.stereotype.Component;

@Component
public class JmsRouter extends RouteBuilder {
    @Override
    public void configure() throws Exception {

        from("jms:q-atlantis-gold-tunnel").routeId("jms-consumer-1")
                .process(exchange -> {
                    String message = exchange.getIn().getBody(String.class);
                    log.info("Payload: {}", message);
                }).to("stream:out");

    }
}
