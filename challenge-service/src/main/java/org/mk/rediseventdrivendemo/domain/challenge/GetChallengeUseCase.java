package org.mk.rediseventdrivendemo.domain.challenge;

import lombok.RequiredArgsConstructor;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class GetChallengeUseCase {
    private final CrudRepository<Challenge, String> fishRepo;

    public Iterable<Challenge> run() {
        return fishRepo.findAll();
    }
}
