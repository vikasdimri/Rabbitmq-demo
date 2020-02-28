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

@Service
@Slf4j
public class InvokerService {

    private Root root;
    private int offset = 0;
    private int size;

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
        return address;
    }

    private Root readAddressesJson() throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        File jsonFile = new File(getClass().getClassLoader().getResource("addresses.json").getFile());
        Root root = objectMapper.readValue(jsonFile, Root.class);
        log.info(root.toString());
        return root;
    }
}
