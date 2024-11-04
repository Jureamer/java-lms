package nextstep.sessions;

public enum SessionRecruitmentState {
    RECRUITING, NOT_RECRUITING;

    public boolean isRecruiting() {
        return this == RECRUITING;
    }
}
