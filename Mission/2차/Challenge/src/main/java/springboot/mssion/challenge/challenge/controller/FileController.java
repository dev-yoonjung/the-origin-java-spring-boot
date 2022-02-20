package springboot.mssion.challenge.challenge.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import springboot.mssion.challenge.challenge.model.dto.response.FileAPIResponse;
import springboot.mssion.challenge.challenge.service.FileService;
import springboot.mssion.challenge.challenge.util.MediaUtils;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.stream.Collectors;

@Controller
public class FileController {

    private static final Logger logger = LoggerFactory.getLogger(FileController.class);
    private final FileService fileService;

    public FileController(@Autowired FileService fileService) {
        this.fileService = fileService;
    }

    @GetMapping("/")
    public String listUploadedFiles(Model model) throws IOException {

        model.addAttribute("files", fileService.loadAll().collect(Collectors.toList()));

        return "index";
    }

    @PostMapping("/file")
    @ResponseBody
    public ResponseEntity<?> handleFileUpload(@RequestParam("file") MultipartFile file) {
        try {
            FileAPIResponse uploadedFile = fileService.store(file);
            return ResponseEntity.ok().body("/file/" + uploadedFile.getId());
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.badRequest().build();
        }
    }

    @GetMapping("/file/{id}")
    @ResponseBody
    public ResponseEntity<?> serveFile(@PathVariable Long id) {
        try {
            FileAPIResponse responseFile = fileService.load(id);
            HttpHeaders headers = new HttpHeaders();

            String fileName = responseFile.getName();
            headers.add(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + new String(fileName.getBytes(StandardCharsets.UTF_8), "ISO-8859-1") + "\"");

            if (MediaUtils.containsImageMediaType(responseFile.getType())) {
                headers.setContentType(MediaType.valueOf(responseFile.getType()));
            } else {
                headers.setContentType(MediaType.APPLICATION_OCTET_STREAM);
            }

            Resource resource = fileService.loadAsResource(responseFile.getSavedName());
            return ResponseEntity.ok().headers(headers).body(resource);

        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.badRequest().build();
        }
    }

}
