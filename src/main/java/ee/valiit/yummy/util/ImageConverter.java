package ee.valiit.yummy.util;

import ee.valiit.yummy.domain.image.Image;
import org.springframework.stereotype.Component;

import java.nio.charset.StandardCharsets;
@Component
public class ImageConverter {

    public static Image stringToImage(String imageData) {
        if (imageData == null) {
            return null;
        }
        Image image = new Image();
        image.setData(stringToByteArray(imageData));
        return image;
    }

    public static byte[] stringToByteArray(String imageData) {
        if (imageData == null) {
            return null;
        }
        return imageData.getBytes(StandardCharsets.UTF_8);
    }

    public static String byteArrayToString(byte[] bytes) {
        if (bytes == null) {
            return "";
        }
        return new String(bytes, StandardCharsets.UTF_8);
    }
}
