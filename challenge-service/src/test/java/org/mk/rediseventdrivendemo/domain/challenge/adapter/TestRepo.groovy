package org.mk.rediseventdrivendemo.domain.challenge.adapter

import org.mk.rediseventdrivendemo.domain.challenge.Challenge
import org.mk.rediseventdrivendemo.domain.challenge.adapters.RedisChallengeStorage
import org.springframework.data.keyvalue.core.KeyValueOperations
import org.springframework.data.keyvalue.repository.support.SimpleKeyValueRepository
import org.springframework.data.repository.core.EntityInformation

class TestRepo extends SimpleKeyValueRepository<Challenge, String> implements RedisChallengeStorage {

    TestRepo(EntityInformation<Challenge, String> metadata, KeyValueOperations operations) {
        super(metadata, operations)
    }
}