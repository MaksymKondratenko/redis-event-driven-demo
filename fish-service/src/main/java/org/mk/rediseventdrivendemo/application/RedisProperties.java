package org.mk.rediseventdrivendemo.application;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.ConstructorBinding;

@ConfigurationProperties(prefix = "redis")
@ConstructorBinding
@Getter
@RequiredArgsConstructor
public final class RedisProperties {
    private final Server server;
    private final PubSub pubSub;

    @Getter
    @RequiredArgsConstructor
    static final class Server {
        private final String hostname;
        private final int port;
    }
    @Getter
    @RequiredArgsConstructor
    static final class PubSub {
        private final String topic;
    }
}
