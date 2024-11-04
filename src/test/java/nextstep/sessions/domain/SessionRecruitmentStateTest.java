package nextstep.sessions.domain;

import nextstep.sessions.SessionRecruitmentState;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class SessionRecruitmentStateTest {

    @Test
    @DisplayName("모집 상태가 true인 경우 isRecruiting이 true를 반환한다")
    void isRecruiting_withRecruitingTrue() {
        SessionRecruitmentState recruitmentState = new SessionRecruitmentState(true);

        assertThat(recruitmentState.isRecruiting()).isTrue();
    }

    @Test
    @DisplayName("모집 상태가 false인 경우 isRecruiting이 false를 반환한다")
    void isRecruiting_withRecruitingFalse() {
        SessionRecruitmentState recruitmentState = new SessionRecruitmentState(false);

        assertThat(recruitmentState.isRecruiting()).isFalse();
    }
}
