package org.mk.rediseventdrivendemo.domain.fish.adapters;

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

@Controller
@RequestMapping("/fish")
@RequiredArgsConstructor
public class FishResource {
    private final CreateFishLuredUseCase createFishLuredUseCase;
    private final GetAllLuredFishUseCase getAllLuredFishUseCase;

    @PostMapping
    public ResponseEntity<Fish> save(@RequestBody Fish fish) {
        Fish persistedFish = createFishLuredUseCase.runWith(fish);
        return ResponseEntity.ok(persistedFish);
    }

    @GetMapping
    public ResponseEntity<Iterable<Fish>> getAll() {
        Iterable<Fish> allFish = getAllLuredFishUseCase.run();
        return ResponseEntity.ok(allFish);
    }
}
