package org.mk.rediseventdrivendemo.domain.fish.adapters;

import org.mk.rediseventdrivendemo.domain.fish.Fish;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RedisFishStorage extends CrudRepository<Fish, String> {
}
