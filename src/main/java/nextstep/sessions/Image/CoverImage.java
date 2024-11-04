    package nextstep.sessions.Image;

    public class CoverImage {
        private ImageSize size;
        private ImageType type;
        private String name;
        private ImageWidth width;
        private ImageHeight height;

        public CoverImage(ImageSize size, ImageType type, String name, ImageWidth width, ImageHeight height) {
            ImageType.validateType(type);
            this.size = size;
            this.type = type;
            this.name = name;
            this.width = width;
            this.height = height;
        }

        public CoverImage(int size, String type, String name, int width, int height) {
            this(new ImageSize(size), ImageType.valueOf(type.toUpperCase()), name, new ImageWidth(width), new ImageHeight(height));
        }

        public CoverImage(int size, ImageType type, String name, int width, int height) {
            this(new ImageSize(size), type, name, new ImageWidth(width), new ImageHeight(height));
        }

        public CoverImage(ImageSize size, String type, String name, int width, int height) {
            this(size, ImageType.valueOf(type.toUpperCase()), name, new ImageWidth(width), new ImageHeight(height));
        }

        public ImageSize getSize() {
            return size;
        }

        public ImageType getType() {
            return type;
        }

        public String getName() {
            return name;
        }

        public ImageWidth getWidth() {
            return width;
        }

        public ImageHeight getHeight() {
            return height;
        }
    }
