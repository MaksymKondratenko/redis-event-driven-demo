package org.mk.rediseventdrivendemo.domain.challenge;

public class CommitToChallenge {

    private CommitToChallenge() {
        // should not be instantiated
    }

    public static CommitToChallenge triggeredBy(String sourceEvent) {
        return new CommitToChallenge();
    }

    public int pointsToCommit() {
        return 100;
    }
}
