package org.mk.rediseventdrivendemo.domain.fish.adapters


import org.mk.rediseventdrivendemo.application.ports.Agent

class TestPublisher implements Agent {

    @Override
    void publish(String event) {
        // do nothing
    }
}