package org.mk.rediseventdrivendemo.application;

import org.mk.rediseventdrivendemo.application.ports.Agent;
import org.mk.rediseventdrivendemo.domain.fish.adapters.FishLuredAgent;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisStandaloneConfiguration;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.listener.ChannelTopic;

@Configuration
@EnableConfigurationProperties(RedisProperties.class)
@RequiredArgsConstructor
public class RedisConfig {
    private final RedisProperties redisProps;

    @Bean
    JedisConnectionFactory jedisConnectionFactory() {
        RedisStandaloneConfiguration redisServerConfig = new RedisStandaloneConfiguration(redisProps.getServer().getHostname(), redisProps.getServer().getPort());
        return new JedisConnectionFactory(redisServerConfig);
    }

    @Bean
    public RedisTemplate<String, Object> redisTemplate() {
        RedisTemplate<String, Object> template = new RedisTemplate<>();
        template.setConnectionFactory(jedisConnectionFactory());
        return template;
    }

    @Bean
    public ChannelTopic topic() {
        return new ChannelTopic(redisProps.getPubSub().getTopic());
    }

    @Bean
    public Agent fishLuredEventPublisher() {
        return new FishLuredAgent(redisTemplate(), topic());
    }
}
