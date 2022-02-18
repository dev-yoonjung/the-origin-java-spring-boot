package springboot.mssion.challenge.challenge.util;

import org.springframework.http.MediaType;

import java.util.HashMap;
import java.util.Map;

public class MediaUtils {

    private static Map<String, MediaType> mediaTypeMap;

    static {
        mediaTypeMap = new HashMap<>();

        mediaTypeMap.put("JPEG", MediaType.IMAGE_JPEG);
        mediaTypeMap.put("JPG", MediaType.IMAGE_JPEG);
        mediaTypeMap.put("GIF", MediaType.IMAGE_GIF);
        mediaTypeMap.put("PNG", MediaType.IMAGE_PNG);
    }

    public static MediaType getMediaType(String type) {
        return mediaTypeMap.get(type.toUpperCase());
    }

    public static boolean containsImageMediaType(String mediaType) {
        return mediaTypeMap.values().contains(MediaType.valueOf(mediaType));
    }

}
