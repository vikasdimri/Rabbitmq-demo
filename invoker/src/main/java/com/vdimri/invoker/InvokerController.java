package com.vdimri.invoker;

import com.vdimri.invoker.model.Addresses;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Slf4j
@Component
public class InvokerController {


    private InvokerService invokerService= new InvokerService();;
    private RestTemplate restTemplate=new RestTemplate();

    private String senderBaseUrl;

    public InvokerController(@Value("${sender.base.url}") String senderBaseUrl) {
        this.senderBaseUrl = senderBaseUrl;
    }

    @Scheduled(fixedDelay = 10000)
    public String addPerson() {
        log.debug("SenderBaseUrl :::::::::::::::::::"+senderBaseUrl);
        HttpEntity<Addresses> request = new HttpEntity<>(invokerService.addressGenerator());
        log.debug("Request body::::::::::::::"+request.getBody());
        log.debug("Request header::::::::::::::"+request.getHeaders());
        ResponseEntity<String> entity = restTemplate.postForEntity(senderBaseUrl + "/api/add", request, String.class);
        return entity.getBody();
    }
}
