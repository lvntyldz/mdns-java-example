package com.mdns.examples;

import lombok.extern.slf4j.Slf4j;

import javax.jmdns.ServiceEvent;
import javax.jmdns.ServiceListener;

@Slf4j
public class ListenerHandler implements ServiceListener {

    @Override
    public void serviceAdded(ServiceEvent event) {
        log.info("new service added. info : {} ", event.getInfo());
    }

    @Override
    public void serviceRemoved(ServiceEvent event) {
        log.info("Service removed! info : {} ", event.getInfo());
    }

    @Override
    public void serviceResolved(ServiceEvent event) {
        log.info("Service Name Resolved. info : {}", event.getInfo());
    }
}
