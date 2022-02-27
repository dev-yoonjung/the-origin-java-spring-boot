package theorigin.javaspringboot.community.service;

import org.springframework.web.multipart.MultipartFile;
import theorigin.javaspringboot.community.model.MediaDescriptorDTO;

import java.util.Collection;

public interface MediaService {

    MediaDescriptorDTO saveFile(MultipartFile file);

    Collection<MediaDescriptorDTO> saveFileBulk(MultipartFile[] files);

    byte[] getFileAsBytes(String resourcePath);
}
