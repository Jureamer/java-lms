package nextstep.sessions;

public class SessionRecruitmentState {
    private final boolean recruiting;

    public SessionRecruitmentState(boolean recruiting) {
        this.recruiting = recruiting;
    }

    public boolean isRecruiting() {
        return recruiting;
    }
}
