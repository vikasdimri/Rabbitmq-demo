package com.vdimri.invoker;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.vdimri.invoker.model.Addresses;
import com.vdimri.invoker.model.Root;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.io.File;
import java.io.IOException;
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
        try {
            if (root == null) {
                root = readAddressesJson();
            }
            address = getAddress();
        } catch (IOException e) {
            log.error("Error in reading file");
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
        File jsonFile = new File(getClass().getClassLoader().getResource("addresses.json").getFile());
        Root root = objectMapper.readValue(jsonFile, Root.class);
        log.info(root.toString());
        return root;
    }
}
