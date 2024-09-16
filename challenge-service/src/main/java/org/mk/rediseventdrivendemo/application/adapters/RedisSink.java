package org.mk.rediseventdrivendemo.application.adapters;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.mk.rediseventdrivendemo.domain.challenge.CommitToChallengeUseCase;
import org.springframework.data.redis.connection.Message;
import org.springframework.data.redis.connection.MessageListener;

import java.util.Arrays;

@Slf4j
@RequiredArgsConstructor
public class RedisSink implements MessageListener {

    private final CommitToChallengeUseCase commitToChallengeUseCase;

    @Override
    public void onMessage(Message message, byte[] pattern) {
        log.info("Message read. {}", message.toString());
        commitToChallengeUseCase.runWith(Arrays.toString(message.getBody()));
        log.info("Commit to challenge use case completed. Message processing completed.");
    }
}
