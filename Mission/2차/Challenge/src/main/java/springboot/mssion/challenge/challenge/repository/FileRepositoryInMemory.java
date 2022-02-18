package springboot.mssion.challenge.challenge.repository;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;
import springboot.mssion.challenge.challenge.common.exception.DeleteException;
import springboot.mssion.challenge.challenge.common.exception.UpdateException;
import springboot.mssion.challenge.challenge.model.entity.File;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

/**
 * File repository. This class implements FileRepository interface.
 * File is saved in memory(ArrayList).
 *
 * <pre>
 *     <b>History:</b>
 *     yoonjung choi, 1.0, 2022. 02. 18. 최초작성
 * </pre>
 *
 * @author yoonjung choi
 * @version 1.0
 */
@Repository
public class FileRepositoryInMemory implements FileRepository {

    private static final Logger logger = LoggerFactory.getLogger(FileRepositoryInMemory.class);
    private final List<File> fileList;

    public FileRepositoryInMemory() {
        this.fileList = new ArrayList<>();
    }

    /**
     * Save file.
     *
     * @param file
     * @return file
     */
    @Override
    public Optional<File> save(File file) {
        if (this.fileList.size() == 0) file.setId(1L);
        else file.setId((this.fileList.get(this.fileList.size()-1)).getId() + 1); // Auto Increment
        this.fileList.add(file);
        logger.info("insert into fileList.");

        return Optional.of(file);
    }

    /**
     * Get file list.
     *
     * @return files
     */
    @Override
    public List<File> findAll() {
        logger.info("select * from fileList");
        return this.fileList;
    }

    /**
     * Get file by file id.
     *
     * @param id file id
     * @return file
     */
    @Override
    public Optional<File> findById(Long id) {
        int index = findIndexById(id);
        logger.info("select * from postList where id = " + id);
        return index != -1 ? Optional.ofNullable(this.fileList.get(index)) : Optional.empty();
    }

    /**
     * update file.
     *
     * @param id file id
     */
    @Override
    public Optional<File> update(Long id, File file) throws UpdateException {
        int index = findIndexById(id);
        if (index != -1) {
            this.fileList.set(index, file);
            logger.info("update fileList set " + file.toString());
            return Optional.of(file);
        } else {
            throw new UpdateException("update failed because there was no file with this id.");
        }
    }

    /**
     * remove file by file id.
     *
     * @param id file id
     */
    @Override
    public void delete(Long id) throws DeleteException {
        int index = findIndexById(id);
        if (index != -1) {
            this.fileList.remove(index);
            logger.info("delete from postList where id = " + id);
        } else {
            throw new DeleteException("delete failed because there was no file with this id.");
        }
    }

    /**
     * Get index by file id.
     *
     * @param id file id
     * @return index
     */
    private int findIndexById(Long id) {
        int index = 0;
        boolean isExist = false;
        for (File post : this.fileList) {
            if (Objects.equals(post.getId(), id)) {
                isExist = true;
                break;
            }
            index++;
        }

        return isExist ? index : -1;
    }
}
