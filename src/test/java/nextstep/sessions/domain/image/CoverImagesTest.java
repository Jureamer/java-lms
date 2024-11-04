package nextstep.sessions.domain.image;

import nextstep.sessions.Image.CoverImage;
import nextstep.sessions.Image.CoverImages;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class CoverImagesTest {
    private CoverImage image1;
    private CoverImage image2;

    @BeforeEach
    void setUp() {
        image1 = new CoverImage(1, "jpg", "image1.jpg", 300, 400);
        image2 = new CoverImage(1, "png", "image2.png", 300, 500);
    }

    @Test
    @DisplayName("단일 커버 이미지를 추가하여 CoverImages 생성")
    void createWithSingleImage() {
        CoverImages coverImages = new CoverImages(image1);

        assertThat(coverImages.size()).isEqualTo(1);
        assertThat(coverImages.getCoverImages()).containsExactly(image1);
    }

    @Test
    @DisplayName("여러 개의 커버 이미지 리스트로 CoverImages 생성")
    void createWithImageList() {
        List<CoverImage> imageList = Arrays.asList(image1, image2);
        CoverImages coverImages = new CoverImages(imageList);

        assertThat(coverImages.size()).isEqualTo(2);
        assertThat(coverImages.getCoverImages()).containsExactly(image1, image2);
    }

    @Test
    @DisplayName("커버 이미지를 추가할 수 있다")
    void addCoverImage() {
        CoverImages coverImages = new CoverImages(image1);
        coverImages.addCoverImage(image2);

        assertThat(coverImages.size()).isEqualTo(2);
        assertThat(coverImages.getCoverImages()).containsExactly(image1, image2);
    }
}
