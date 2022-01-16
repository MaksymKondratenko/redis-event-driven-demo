package org.mk.rediseventdrivendemo.domain.challenge

import org.mk.rediseventdrivendemo.domain.challenge.adapter.TestRepo
import spock.lang.Specification

class CommitToChallengeUseCaseTest extends Specification {

    def "on commit to challenge use case should update the challenge"() {
        given:
        def repoMock = Mock(TestRepo)
        def sut = new CommitToChallengeUseCase(repoMock)

        when:
        sut.runWith("new event")

        then:
        1 * repoMock.saveAll(_)
    }
}
