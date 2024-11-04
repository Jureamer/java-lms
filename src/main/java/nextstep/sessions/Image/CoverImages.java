package nextstep.sessions.Image;

import java.util.ArrayList;
import java.util.List;

public class CoverImages {
    private List<CoverImage> coverImages;

    public CoverImages(CoverImage coverImage) {
        this.coverImages = new ArrayList<>();
        this.coverImages.add(coverImage);
    }

    public CoverImages(List<CoverImage> coverImages) {
        this.coverImages = new ArrayList<>(coverImages);
    }

    public List<CoverImage> getCoverImages() {
        return new ArrayList<>(coverImages);
    }

    public void addCoverImage(CoverImage coverImage) {
        this.coverImages.add(coverImage);
    }

    public int size() {
        return coverImages.size();
    }
}
