package org.mk.rediseventdrivendemo.application.adapters


import org.mk.rediseventdrivendemo.domain.fish.Fish
import org.springframework.data.keyvalue.core.KeyValueOperations
import org.springframework.data.keyvalue.repository.support.SimpleKeyValueRepository
import org.springframework.data.repository.core.EntityInformation

class TestRepo extends SimpleKeyValueRepository<Fish, String> implements RedisFishStorage {

    TestRepo(EntityInformation<Fish, String> metadata, KeyValueOperations operations) {
        super(metadata, operations)
    }
}