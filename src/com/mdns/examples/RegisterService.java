package com.mdns.examples;

import lombok.extern.slf4j.Slf4j;

import javax.jmdns.JmDNS;
import javax.jmdns.ServiceInfo;
import java.io.IOException;
import java.net.InetAddress;

@Slf4j
public class RegisterService {

    private static void register(JmDNS jmdns) throws IOException {

        // Register a service
        ServiceInfo serviceInfo = ServiceInfo.create(Constants.TYPE, Constants.NAME, Constants.PORT, Constants.TEXT);
        log.info("ServiceInfo : {} ", serviceInfo);
        jmdns.registerService(serviceInfo);

    }

    private static void unRegisterAll(JmDNS jmdns) {

        // Unregister all services
        jmdns.unregisterAllServices();

    }

    public static void main(String[] args) throws InterruptedException {

        try {

            log.info("Starting to register...");

            // Create a JmDNS instance
            JmDNS jmdns = JmDNS.create(InetAddress.getLocalHost());

            register(jmdns);

            // Unregister after 60S
            Thread.sleep(60000);

            unRegisterAll(jmdns);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
