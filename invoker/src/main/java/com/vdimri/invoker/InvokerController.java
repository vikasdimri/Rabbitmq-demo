package com.vdimri.invoker;

import com.vdimri.invoker.model.Addresses;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class InvokerController {


    private InvokerService invokerService= new InvokerService();;
    private RestTemplate restTemplate=new RestTemplate();

    private String senderBaseUrl;

    public InvokerController(@Value("${sender.base.url}") String producerBaseUrl) {
        this.senderBaseUrl = producerBaseUrl;
    }

    @Scheduled(fixedDelay = 2000)
    public String addPerson() {
        HttpEntity<Addresses> request = new HttpEntity<>(invokerService.addressGenerator());
        ResponseEntity<String> entity = restTemplate.postForEntity(senderBaseUrl + "/api/add", request, String.class);
        return entity.getBody();
    }
}
