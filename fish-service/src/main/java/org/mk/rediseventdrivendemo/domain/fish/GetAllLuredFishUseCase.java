package org.mk.rediseventdrivendemo.domain.fish;

import lombok.RequiredArgsConstructor;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class GetAllLuredFishUseCase {
    private final CrudRepository<Fish, String> fishRepo;

    public Iterable<Fish> run() {
        return fishRepo.findAll();
    }
}
