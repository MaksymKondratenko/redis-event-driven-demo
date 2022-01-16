package org.mk.rediseventdrivendemo.domain.challenge.adapters;

import org.mk.rediseventdrivendemo.domain.challenge.Challenge;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RedisChallengeStorage extends CrudRepository<Challenge, String> {
}
