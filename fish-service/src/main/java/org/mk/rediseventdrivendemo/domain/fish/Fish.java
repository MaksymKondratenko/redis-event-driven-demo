package org.mk.rediseventdrivendemo.domain.fish;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.data.redis.core.RedisHash;

import java.io.Serializable;

@Getter
@RequiredArgsConstructor
@RedisHash("Fish")
public class Fish implements Serializable {
    private final String id;
    private final String kind;
    private final float length;
    private final float weight;
}
