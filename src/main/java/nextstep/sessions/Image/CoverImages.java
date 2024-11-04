package nextstep.sessions.Image;

import java.util.List;

public class CoverImages {
    private List<CoverImage> coverImages;

    public CoverImages(CoverImage coverImage) {
        this.coverImages.add(coverImage);
    }

    public CoverImages(List<CoverImage> coverImages) {
        this.coverImages = coverImages;
    }

    public List<CoverImage> getCoverImages() {
        return coverImages;
    }
}
