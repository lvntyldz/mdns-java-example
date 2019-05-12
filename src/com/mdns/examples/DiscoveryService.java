package com.mdns.examples;

import lombok.extern.slf4j.Slf4j;

import javax.jmdns.JmDNS;
import java.io.IOException;
import java.net.InetAddress;
import java.net.UnknownHostException;


@Slf4j
public class DiscoveryService {

    public static void main(String[] args) throws InterruptedException {

        try {
            // Create a JmDNS instance
            JmDNS jmdns = JmDNS.create(InetAddress.getLocalHost());
            log.info("JmDNS created. JmDNS : {} ", jmdns);

            // Add a service listener
            jmdns.addServiceListener(Constants.TYPE, new ListenerHandler());
            log.info("Service Listener Added To JmDNS");

            // Wait a bit
            Thread.sleep(60000);

        } catch (UnknownHostException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
