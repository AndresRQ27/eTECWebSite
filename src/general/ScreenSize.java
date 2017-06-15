package general;

/**
 * Created by andres on 16/05/17.
 * DrApp
 * PACKAGE_NAME
 */
public class ScreenSize {
    public static int getWidth() {
        return width;
    }

    public static void setWidth(int width) {
        ScreenSize.width = width;
    }

    private static int width = 1240;

    public static int getHeight() {
        return height;
    }

    public static void setHeight(int height) {
        ScreenSize.height = height;
    }

    private static int height = 680;
}
