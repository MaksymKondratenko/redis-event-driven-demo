package org.mk.rediseventdrivendemo.domain.fish.adapters;

import lombok.extern.slf4j.Slf4j;
import org.mk.rediseventdrivendemo.domain.fish.Fish;
import org.mk.rediseventdrivendemo.domain.fish.GetAllLuredFishUseCase;
import org.mk.rediseventdrivendemo.domain.fish.CreateFishLuredUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@Slf4j
@Controller
@RequestMapping("/fish")
@RequiredArgsConstructor
public class FishResource {
    private final CreateFishLuredUseCase createFishLuredUseCase;
    private final GetAllLuredFishUseCase getAllLuredFishUseCase;

    @PostMapping
    public ResponseEntity<Fish> save(@RequestBody Fish fish) {
        log.info("Persisting request mapped. Running create fish-lured use case.");
        Fish persistedFish = createFishLuredUseCase.runWith(fish);
        log.info("Fish-lured use case created. Request processing completed. Returning to a client.");
        return ResponseEntity.ok(persistedFish);
    }

    @GetMapping
    public ResponseEntity<Iterable<Fish>> getAll() {
        log.info("Retrieval request mapped. Running get all lured fish use case.");
        Iterable<Fish> allFish = getAllLuredFishUseCase.run();
        log.info("All lured fish is retrieved. Request processing completed. Returning to a client.");
        return ResponseEntity.ok(allFish);
    }
}
