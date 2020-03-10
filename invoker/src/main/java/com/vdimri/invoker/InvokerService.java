package com.vdimri.invoker;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.vdimri.invoker.model.Addresses;
import com.vdimri.invoker.model.Root;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.Random;

import static java.lang.Integer.*;

@Service
@Slf4j
public class InvokerService {

    private Root root;
    private int offset = 0;
    private int size;
    private int position = 0;

    public Addresses addressGenerator() {
        Addresses address = null;
        if (root == null) {
            try {
                root = readAddressesJson();
                address = getAddress();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return address;
    }

    private Addresses getAddress() {
        Addresses address = null;
        List<Addresses> addresses = root.getAddresses();
        if (!CollectionUtils.isEmpty(addresses)) {
            size = root.getAddresses().size();
            address = addresses.get(offset);
            offset++;
        }
        if (size == offset) {
            addressFactory();
        }
        return address;
    }

    private void addressFactory() {
        offset = 0;
        position++;
        Random random = new Random();
        for (Addresses addressToChange : root.getAddresses()) {
            addressToChange.setPostalCode(String.valueOf(random.nextInt(99999)));
        }
    }

    private Root readAddressesJson() throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        Resource resource = new ClassPathResource("classpath:addresses.json");
        InputStream inputStream = resource.getInputStream();
        return objectMapper.readValue(inputStream, Root.class);
    }
}
