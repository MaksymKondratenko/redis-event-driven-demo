package org.mk.rediseventdrivendemo.application;

import lombok.RequiredArgsConstructor;
import org.mk.rediseventdrivendemo.domain.challenge.CommitToChallengeUseCase;
import org.mk.rediseventdrivendemo.application.adapters.RedisSink;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisStandaloneConfiguration;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.data.redis.listener.ChannelTopic;
import org.springframework.data.redis.listener.RedisMessageListenerContainer;
import org.springframework.data.redis.listener.adapter.MessageListenerAdapter;

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
    public ChannelTopic topic() {
        return new ChannelTopic(redisProps.getPubSub().getTopic());
    }

    @Bean
    public MessageListenerAdapter messageListener(CommitToChallengeUseCase useCase) {
        return new MessageListenerAdapter(new RedisSink(useCase));
    }

    @Bean
    public RedisMessageListenerContainer redisContainer(MessageListenerAdapter messageListener) {
        RedisMessageListenerContainer container
                = new RedisMessageListenerContainer();
        container.setConnectionFactory(jedisConnectionFactory());
        container.addMessageListener(messageListener, topic());
        return container;
    }
}
