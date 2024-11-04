package nextstep.sessions;

import nextstep.sessions.Image.CoverImage;
import nextstep.sessions.Image.CoverImages;
import nextstep.users.domain.Student;

import java.time.LocalDateTime;

public class Session {
    public static final String SESSION_NOT_OPEN_MESSAGE = "강의 수강신청은 강의 상태가 모집중일 때만 가능합니다.";
    private static final int MAX_STUDENT_COUNT = 999;
    private static final boolean DEFAULT_IS_FREE = true;
    private static final Long DEFAULT_SESSION_FEE = 0L;
    private static final SessionRecruitmentState DEFAULT_RECRUITMENT_STATE = SessionRecruitmentState.NOT_RECRUITING;
    private final Long id;
    private final String name;
    private final String description;
    private final CoverImages images;
    private final SessionDetail sessionDetail;
    private final SessionDate sessionDate;
    private SessionState state;
    private SessionRecruitmentState recruitmentState = DEFAULT_RECRUITMENT_STATE;

    private Session(SessionBuilder builder) {
        this.id = builder.id;
        this.name = builder.name;
        this.description = builder.description;
        this.images = builder.images;
        this.state = builder.state != null ? builder.state : SessionState.READY;
        this.recruitmentState = builder.recruitmentState != null ? builder.recruitmentState : DEFAULT_RECRUITMENT_STATE;
        this.sessionDate = new SessionDate(builder.startDate, builder.endDate);
        this.sessionDetail = new SessionDetail(
                builder.isFree,
                builder.isFree ? MAX_STUDENT_COUNT : builder.maxStudentCount,
                builder.sessionFee
        );
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public LocalDateTime getStartDate() {
        return sessionDate.getStartDate();
    }

    public LocalDateTime getEndDate() {
        return sessionDate.getEndDate();
    }

    public boolean isRecruiting() {
        return recruitmentState.isRecruiting();
    }

    public void register(Student student, Long amount) {
        validateRegistrationEligibility(amount);
        sessionDetail.registerNewStudent(student);
    }

    private void validateRegistrationEligibility(Long amount) {
        if (!state.isInProgress() || !recruitmentState.isRecruiting()) {
            throw new IllegalStateException(SESSION_NOT_OPEN_MESSAGE);
        }

        sessionDetail.checkRegistrationEligibility(amount);
    }

    public void setClose() {
        this.state = SessionState.CLOSE;
    }

    public boolean contains(Student student) {
        return sessionDetail.contains(student);
    }

    public static class SessionBuilder {
        private final Long id;
        private final String name;
        private final String description;
        private final CoverImages images;
        private final LocalDateTime startDate;
        private final LocalDateTime endDate;
        private SessionRecruitmentState recruitmentState = DEFAULT_RECRUITMENT_STATE;
        private boolean isFree = DEFAULT_IS_FREE;
        private int maxStudentCount = MAX_STUDENT_COUNT;
        private Long sessionFee = DEFAULT_SESSION_FEE;
        private SessionState state;

        public SessionBuilder(Long id, String name, String description, CoverImages images, LocalDateTime startDate, LocalDateTime endDate) {
            this.id = id;
            this.name = name;
            this.description = description;
            this.images = images;
            this.startDate = startDate;
            this.endDate = endDate;
        }

        public SessionBuilder(Long id, String name, String description, CoverImage image, LocalDateTime startDate, LocalDateTime endDate) {
            this.id = id;
            this.name = name;
            this.description = description;
            this.images = new CoverImages(image);
            this.startDate = startDate;
            this.endDate = endDate;
        }

        public SessionBuilder isFree(boolean isFree) {
            this.isFree = isFree;
            return this;
        }

        public SessionBuilder maxStudentCount(int maxStudentCount) {
            this.maxStudentCount = maxStudentCount;
            return this;
        }

        public SessionBuilder sessionFee(Long sessionFee) {
            this.sessionFee = sessionFee;
            return this;
        }

        public SessionBuilder state(SessionState state) {
            this.state = state;
            return this;
        }

        public SessionBuilder recruitmentState(SessionRecruitmentState recruitmentState) {
            this.recruitmentState = recruitmentState;
            return this;
        }

        public Session build() {
            return new Session(this);
        }
    }
}
