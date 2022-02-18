package springboot.mssion.challenge.challenge.service;

import org.springframework.core.io.Resource;
import org.springframework.web.multipart.MultipartFile;
import springboot.mssion.challenge.challenge.model.dto.response.FileAPIResponse;

import java.nio.file.Path;
import java.util.stream.Stream;

public interface FileService {

    FileAPIResponse store(MultipartFile file) throws Exception;

    Stream<Long> loadAll();

    FileAPIResponse load(Long id);

    Resource loadAsResource(String name) throws Exception;

    Path loadPath(String name);
}
