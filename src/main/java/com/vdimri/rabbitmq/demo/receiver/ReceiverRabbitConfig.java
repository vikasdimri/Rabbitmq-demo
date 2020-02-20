package com.vdimri.rabbitmq.demo.receiver;

import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableBinding(Messaging.class)
public class ReceiverRabbitConfig {
}
