package springboot.mission.basic.repository;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;
import springboot.mission.basic.common.exception.DeleteException;
import springboot.mission.basic.common.exception.UpdateException;
import springboot.mission.basic.model.entity.Board;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

/**
 * Board repository. This class implements BoardRepository interface.
 * board is saved in memory(ArrayList).
 *
 * <pre>
 *     <b>History:</b>
 *     yoonjung choi, 1.0, 2022. 02. 17. 최초작성
 * </pre>
 *
 * @author yoonjung choi
 * @version 1.0
 */
@Repository
public class BoardRepositoryInMemory implements BoardRepository {

    private static final Logger logger = LoggerFactory.getLogger(BoardRepositoryInMemory.class);
    private final List<Board> boardList;

    public BoardRepositoryInMemory() {
        this.boardList = new ArrayList<>();
    }

    /**
     * Get board save.
     *
     * @param board
     * @return board
     */
    @Override
    public Optional<Board> save(Board board) {
        if (this.boardList.size() == 0) board.setId(1L);
        else board.setId(this.boardList.get(this.boardList.size()-1).getId() + 1);
        this.boardList.add(board);
        logger.info("insert into boardList");

        return Optional.of(board);
    }

    /**
     * Get board list.
     *
     * @return boards
     */
    @Override
    public List<Board> findAll() {
        logger.info("select * from boardList");
        return this.boardList;
    }

    /**
     * Get board by board id.
     *
     * @param  id board id
     * @return board
     */
    @Override
    public Optional<Board> findById(Long id) {
        int index = findIndexById(id);
        logger.info("select * from boardList where id = " + id);
        return index != -1 ? Optional.ofNullable(this.boardList.get(index)) : Optional.empty();
    }

    /**
     * update board.
     *
     * @param id board id
     */
    @Override
    public Optional<Board> update(Long id, Board board) throws UpdateException {
        int index = findIndexById(id);
        if (index != -1) {
            this.boardList.set(index, board);
            logger.info("update boardList set = " + board.toString());
            return Optional.of(board);
        } else {
            throw new UpdateException("update failed because there was no post with this id.");
        }
    }

    /**
     * remove board by board id.
     *
     * @param id post id
     */
    @Override
    public void delete(Long id) throws DeleteException {
        int index = findIndexById(id);
        if (index != -1) {
            this.boardList.remove(index);
            logger.info("delete from postList where id = " + id);
        } else {
            throw new DeleteException("delete failed because there was no post with this id.");
        }
    }

    /**
     * Get index by board id.
     *
     * @param id board id
     * @return index
     */
    private int findIndexById(Long id) {
        int index = 0;
        boolean isExist = false;
        for (Board board : this.boardList) {
            if (Objects.equals(board.getId(), id)) {
                isExist = true;
                break;
            }
            index++;
        }

        return isExist ? index : -1;
    }

}
