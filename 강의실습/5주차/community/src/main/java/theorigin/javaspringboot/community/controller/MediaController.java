package theorigin.javaspringboot.community.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import theorigin.javaspringboot.community.model.MediaDescriptorDTO;
import theorigin.javaspringboot.community.service.MediaService;

import javax.servlet.http.HttpServletRequest;
import java.util.Collection;

@RestController
@RequestMapping("/media")
public class MediaController {

    private static final Logger logger = LoggerFactory.getLogger(MediaController.class);
    private final MediaService mediaService;

    public MediaController(@Autowired MediaService mediaService) {
        this.mediaService = mediaService;
    }

    @PostMapping("/upload")
    public ResponseEntity<MediaDescriptorDTO> uploadMedia(@RequestParam("file") MultipartFile file) {
        MediaDescriptorDTO descriptorDTO = this.mediaService.saveFile(file);
        return ResponseEntity.status(descriptorDTO.getStatus()).body(descriptorDTO);
    }

    @PostMapping("/upload-bulk")
    public ResponseEntity<Collection<MediaDescriptorDTO>> uploadMediaBulk(@RequestParam("file") MultipartFile[] files) {
        return ResponseEntity
                .status(HttpStatus.MULTI_STATUS)
                .body(this.mediaService.saveFileBulk(files));
    }

    @GetMapping("/**")
    public ResponseEntity<byte[]> staticLikeEndpoint(HttpServletRequest request) {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.IMAGE_JPEG);
        return new ResponseEntity<>(
                this.mediaService.getFileAsBytes(request.getRequestURI().split("media")[1]),
                headers,
                HttpStatus.OK
        );
    }
}
