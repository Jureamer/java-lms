package nextstep.sessions.domain.image;

import nextstep.sessions.Image.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class CoverImageTest {

    @Test
    @DisplayName("ImageSize, ImageType, ImageWidth, ImageHeight, name을 통한 CoverImage 생성")
    void createCoverImage_withFullConstructor() {
        ImageSize imageSize = new ImageSize(1);
        ImageType imageType = ImageType.JPG;
        String name = "cover.jpg";
        ImageWidth imageWidth = new ImageWidth(1920);
        ImageHeight imageHeight = new ImageHeight(1080);

        CoverImage coverImage = new CoverImage(imageSize, imageType, name, imageWidth, imageHeight);

        assertThat(coverImage.getSize()).isEqualTo(imageSize);
        assertThat(coverImage.getType()).isEqualTo(imageType);
        assertThat(coverImage.getName()).isEqualTo(name);
        assertThat(coverImage.getWidth()).isEqualTo(imageWidth);
        assertThat(coverImage.getHeight()).isEqualTo(imageHeight);
    }

    @Test
    @DisplayName("int, String, String, int, int을 통한 CoverImage 생성")
    void createCoverImage_withPrimitiveConstructor() {
        int size = 1;
        String type = "jpg";
        String name = "cover.jpg";
        int width = 1920;
        int height = 1080;

        CoverImage coverImage = new CoverImage(size, type, name, width, height);

        assertThat(coverImage.getSize().getSize()).isEqualTo(size);
        assertThat(coverImage.getType()).isEqualTo(ImageType.JPG);
        assertThat(coverImage.getName()).isEqualTo(name);
        assertThat(coverImage.getWidth().getWidth()).isEqualTo(width);
        assertThat(coverImage.getHeight().getHeight()).isEqualTo(height);
    }

    @Test
    @DisplayName("int, ImageType, String, int, int을 통한 CoverImage 생성")
    void createCoverImage_withTypeEnumConstructor() {
        int size = 1;
        ImageType type = ImageType.PNG;
        String name = "cover.png";
        int width = 1920;
        int height = 1080;

        CoverImage coverImage = new CoverImage(size, type, name, width, height);

        assertThat(coverImage.getSize().getSize()).isEqualTo(size);
        assertThat(coverImage.getType()).isEqualTo(type);
        assertThat(coverImage.getName()).isEqualTo(name);
        assertThat(coverImage.getWidth().getWidth()).isEqualTo(width);
        assertThat(coverImage.getHeight().getHeight()).isEqualTo(height);
    }

    @Test
    @DisplayName("ImageSize, String, String, int, int을 통한 CoverImage 생성")
    void createCoverImage_withSizeObjectConstructor() {
        ImageSize imageSize = new ImageSize(1);
        String type = "png";
        String name = "small_cover.png";
        int width = 1280;
        int height = 720;

        CoverImage coverImage = new CoverImage(imageSize, type, name, width, height);

        assertThat(coverImage.getSize()).isEqualTo(imageSize);
        assertThat(coverImage.getType()).isEqualTo(ImageType.PNG);
        assertThat(coverImage.getName()).isEqualTo(name);
        assertThat(coverImage.getWidth().getWidth()).isEqualTo(width);
        assertThat(coverImage.getHeight().getHeight()).isEqualTo(height);
    }
}
