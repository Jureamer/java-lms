package nextstep.sessions;

public enum SessionState {
    READY, IN_PROGRESS, CLOSE;
    public boolean isInProgress() {
        return this == IN_PROGRESS;
    }
}
