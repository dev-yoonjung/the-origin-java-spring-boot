package springboot.mssion.challenge.challenge.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import springboot.mssion.challenge.challenge.model.dto.response.FileAPIResponse;
import springboot.mssion.challenge.challenge.model.entity.File;
import springboot.mssion.challenge.challenge.repository.FileRepository;
import springboot.mssion.challenge.challenge.util.UploadFileUtils;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;

@Service
public class FileAPILogicService implements FileService {

    private static final Logger logger = LoggerFactory.getLogger(FileAPILogicService.class);
    private final Path rootLocation;
    private final FileRepository fileRepository;

    public FileAPILogicService(@Autowired FileRepository fileRepository) {
        this.rootLocation = Paths.get("C:\\data\\image");
        this.fileRepository = fileRepository;
    }

    @Override
    public FileAPIResponse store(MultipartFile file) throws Exception {
        try {
            if (file.isEmpty()) throw new Exception("Failed to store empty file");

            String saveFileName = UploadFileUtils.fileSave(rootLocation.toString() , file);

            if (saveFileName.toCharArray()[0] == '/') {
                saveFileName = saveFileName.substring(1);
            }

            Resource resource = loadAsResource(saveFileName);

            File fileEntity = new File();
            fileEntity.setSavedName(saveFileName);
            fileEntity.setName(file.getOriginalFilename());
            fileEntity.setType(file.getContentType());
            fileEntity.setPath(rootLocation.toString().replace(java.io.File.separatorChar, '/') + java.io.File.separator + saveFileName);
            fileEntity.setSize(resource.contentLength());
            fileRepository.save(fileEntity);

            return response(fileEntity);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public Stream<Long> loadAll() {
        List<File> files = fileRepository.findAll();
        return files.stream().map(File::getId);
    }

    @Override
    public FileAPIResponse load(Long id) {
        Optional<File> file = this.fileRepository.findById(id);
        return file.map(this::response).orElse(null);
    }

    @Override
    public Resource loadAsResource(String name) throws Exception {
        try {
            if (name.toCharArray()[0] == '/') {
                name = name.substring(1);
            }

            Path file = loadPath(name);
            Resource resource = new UrlResource(file.toUri());
            if (resource.exists() || resource.isReadable()) {
                return resource;
            } else {
                throw new Exception("Could not read file: " + name);
            }
        } catch (Exception e) {
            throw new Exception("Could not read file: " + name);
        }
    }

    @Override
    public Path loadPath(String name) {
        return rootLocation.resolve(name);
    }

    private FileAPIResponse response(File file) {
        return new FileAPIResponse(file.getId(),
                file.getName(),
                file.getSavedName(),
                file.getPath(),
                file.getType(),
                file.getSize());
    }
}
