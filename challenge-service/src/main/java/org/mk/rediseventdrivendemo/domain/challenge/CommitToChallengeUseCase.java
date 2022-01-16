package org.mk.rediseventdrivendemo.domain.challenge;

import lombok.RequiredArgsConstructor;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.Collections;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Component
@RequiredArgsConstructor
public class CommitToChallengeUseCase {
    private final CrudRepository<Challenge, String> challengeRepo;

    @PostConstruct
    public void initializeChallengeStorage() {
        Challenge challenge = new Challenge("id", "clash", 1000, 0);
        challengeRepo.save(challenge);
    }

    public void runWith(String event) {
        CommitToChallenge challengeCommit = CommitToChallenge.triggeredBy(event);
        Iterable<Challenge> allChallenge = Optional.ofNullable(challengeRepo.findAll())
                .orElse(Collections.emptyList());
        Set<Challenge> challenges = StreamSupport.stream(allChallenge.spliterator(), false)
                .filter(challenge -> challenge.doesQualify(event))
                .map(challenge -> challenge.commitPoints(challengeCommit.pointsToCommit()))
                .collect(Collectors.toSet());
        challengeRepo.saveAll(challenges);
    }
}
