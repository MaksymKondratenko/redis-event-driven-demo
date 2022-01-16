package org.mk.rediseventdrivendemo.domain.challenge.adapters;

import lombok.extern.slf4j.Slf4j;
import org.mk.rediseventdrivendemo.domain.challenge.Challenge;
import org.mk.rediseventdrivendemo.domain.challenge.GetChallengeUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Slf4j
@Controller
@RequestMapping("/challenge")
@RequiredArgsConstructor
public class ChallengeResource {
    private final GetChallengeUseCase getChallengeUseCase;

    @GetMapping
    public ResponseEntity<Iterable<Challenge>> getAll() {
        log.info("Request mapped. Running get challenge use case.");
        Iterable<Challenge> allChallenges = getChallengeUseCase.run();
        log.info("Get challenge use case has completed. Request processed. Returning to a client.");
        return ResponseEntity.ok(allChallenges);
    }
}
