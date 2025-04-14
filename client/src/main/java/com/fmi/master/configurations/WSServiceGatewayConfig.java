package com.fmi.master.configurations;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.oxm.jaxb.Jaxb2Marshaller;
import org.springframework.ws.client.core.support.WebServiceGatewaySupport;


@Configuration
public class WSServiceGatewayConfig extends WebServiceGatewaySupport {

    @Bean
    public Jaxb2Marshaller marshaller() {
        Jaxb2Marshaller marshaller = new Jaxb2Marshaller();
        marshaller.setContextPath("com.fmi.master.models");
        return marshaller;
    }

    @Bean
    public SoapClient soapClient(final Jaxb2Marshaller marshaller) {
        final SoapClient client = new SoapClient();
        client.setDefaultUri("http://localhost:8091/ws");
        client.setMarshaller(marshaller);
        client.setUnmarshaller(marshaller);
        return client;
    }
}

