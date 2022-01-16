package org.mk.rediseventdrivendemo.domain.challenge;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.data.redis.core.RedisHash;

import java.io.Serializable;

@Getter
@RequiredArgsConstructor
@RedisHash("Challenge")
public class Challenge implements Serializable {
    private final String id;
    private final String name;
    private final int targetPoints;
    private final int currentPoints;

    public boolean isAccomplished() {
        return currentPoints == targetPoints;
    }

    public boolean doesQualify(String event) {
        return true;
    }

    public Challenge commitPoints(int pointsToCommit) {
        return new Challenge(id, name, targetPoints, currentPoints + pointsToCommit);
    }
}
