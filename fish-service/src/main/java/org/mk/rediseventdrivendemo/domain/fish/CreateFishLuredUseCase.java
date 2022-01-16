package org.mk.rediseventdrivendemo.domain.fish;

import org.mk.rediseventdrivendemo.application.ports.Agent;
import lombok.RequiredArgsConstructor;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class CreateFishLuredUseCase {
    private final CrudRepository<Fish, String> fishRepo;
    private final Agent agent;

    public Fish runWith(Fish fish) {
        Fish savedFish = fishRepo.save(fish);
        agent.publish(fish.getId());
        return savedFish;
    }
}
