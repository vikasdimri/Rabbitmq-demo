package com.vdimri.sender;

import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableBinding(Messaging.class)
public class SenderRabbitConfig {
}
