package org.mk.rediseventdrivendemo.domain.fish

import org.mk.rediseventdrivendemo.domain.fish.adapters.TestRepo
import spock.lang.Specification

class GetAllLuredFishUseCaseTest extends Specification {

    def "on create fish use case should persist a fish and publish an event"() {
        given:
        def repoMock = Mock(TestRepo)
        def sut = new GetAllLuredFishUseCase(repoMock)

        when:
        sut.run()

        then:
        1 * repoMock.findAll()
    }
}




