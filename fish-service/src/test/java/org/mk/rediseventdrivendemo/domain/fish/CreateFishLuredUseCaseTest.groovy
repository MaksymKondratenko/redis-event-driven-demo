package org.mk.rediseventdrivendemo.domain.fish

import org.mk.rediseventdrivendemo.domain.fish.adapters.TestPublisher
import org.mk.rediseventdrivendemo.domain.fish.adapters.TestRepo
import spock.lang.Specification

class CreateFishLuredUseCaseTest extends Specification {

    def "on create fish use case should persist a fish and publish an event" () {
        given:
        def repoMock = Mock(TestRepo)
        def publisherMock = Mock(TestPublisher)
        def sut = new CreateFishLuredUseCase(repoMock, publisherMock)

        when:
        sut.runWith(new Fish("ab31c", "herring", 0.5, 1.0 ))

        then:
        1 * repoMock.save(_)
        1 * publisherMock.publish(_)
    }
}




